package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.ConfirmationTokenEntity;
import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.request.EmailNotificationRequest;
import com.ecommerce.posgrado.request.RegistrationRequest;
import com.ecommerce.posgrado.util.HtmlGeneratorUtil;
import com.ecommerce.posgrado.util.UrlGeneratorUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:56
 * Project Name: posgrado
 */
@Service
public class RegistrationImplementService implements RegistrationInterfaceService {

    private static final String DEFAULT_ROLE = "USER";
    private final UserInterfaceService userInterfaceService;

    private final RoleInterfaceService roleInterfaceService;

    private ConfirmationTokenInterfaceService confirmationTokenInterfaceService;

    private final PasswordEncoder passwordEncoder;

    private final EmailInterfaceService emailService;

    public RegistrationImplementService(UserInterfaceService userInterfaceService,
                                        RoleInterfaceService roleInterfaceService,
                                        ConfirmationTokenInterfaceService confirmationTokenInterfaceService,
                                        PasswordEncoder passwordEncoder,
                                        EmailInterfaceService emailService) {
        this.userInterfaceService = userInterfaceService;
        this.roleInterfaceService = roleInterfaceService;
        this.confirmationTokenInterfaceService = confirmationTokenInterfaceService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public String register(RegistrationRequest request) {
        if (this.userInterfaceService.existEmail(request.getEmail()))
            throw new AppHandleException("El Correo ya se encuentra en uso!", HttpStatus.BAD_REQUEST);

        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        String endedPassword = this.passwordEncoder.encode(request.getPassword());
        user.setPassword(endedPassword);
        user.setRole(this.roleInterfaceService.getByName(DEFAULT_ROLE));
        user = this.userInterfaceService.create(user);

        String token = UUID.randomUUID().toString();
        ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity();
        confirmationToken.setToken(token);
        confirmationToken.setCreatedAt(LocalDateTime.now());
        confirmationToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
        confirmationToken.setUser(user);

        this.confirmationTokenInterfaceService.create(confirmationToken);

        String confirmLink = UrlGeneratorUtil.create("/api/v1/auth/confirm", "token", token);
        String bodyHtml = HtmlGeneratorUtil.generateConfirmationTemplate(user.getFirstName(), confirmLink);

        EmailNotificationRequest emailNotification = EmailNotificationRequest.builder()
                .hasTemplate(true)
                .to(user.getEmail())
                .subject("Confirmation Account")
                .body(bodyHtml)
                .build();

        this.emailService.send(emailNotification);
        return token;
    }

    @Override
    public String confirm(String token) {
        ConfirmationTokenEntity confirmationToken = this.confirmationTokenInterfaceService.getByToken(token);
        if (confirmationToken.getConfirmedAt() != null) {
            throw new AppHandleException("Token is already confirmed", HttpStatus.BAD_REQUEST);
        }
        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new AppHandleException("Token expired", HttpStatus.BAD_REQUEST);
        }
        this.userInterfaceService.enableUser(confirmationToken.getUser());
        this.confirmationTokenInterfaceService.setConfirmedAt(confirmationToken);
        return "User account has been enabled successfully";
    }

}

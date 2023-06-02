package com.ecommerce.posgrado.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecommerce.posgrado.config.JwtConfig;
import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.response.LoginResponse;
import com.ecommerce.posgrado.security.UserDetailService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author gclaure from CochaSoft
 * Date: 5/29/23
 * Time: 20:33
 * Project Name: posgrado
 */
@Service
public class JwtImplementService implements JwtInterfaceService {

    private static final String TYPE_TOKEN = "Bearer";

    private final UserDetailService userDetailService;

    private final JwtConfig jwtConfig;

    public JwtImplementService(UserDetailService userDetailService,
                               JwtConfig jwtConfig) {
        this.userDetailService = userDetailService;
        this.jwtConfig = jwtConfig;
    }

    @Override
    public LoginResponse createToken(UserEntity user) {
        Date expireToken = calculateDateInMinutes(this.jwtConfig.getExpireToken());
        Date expireRefreshToken = calculateDateInMinutes(this.jwtConfig.getExpireRefreshToken());
        return LoginResponse
                .builder()
                .accessToken(generateToken(user.getEmail(), user.getRole().getName(), expireToken))
                .refreshToken(generateRefreshToken(user.getEmail(), user.getRole().getName(), expireRefreshToken))
                .expireTokenIn(expireToken.getTime())
                .expireRefreshTokenIn(expireRefreshToken.getTime())
                .tokenType(TYPE_TOKEN)
                .build();

    }


    @Override
    public UserEntity decodeToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(this.jwtConfig.getSecretkeyToken().getBytes())).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getSubject();
        return (UserEntity) this.userDetailService.loadUserByUsername(email);

    }

    @Override
    public UserEntity decodeRefreshToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(this.jwtConfig.getSecretRefreshToken().getBytes())).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getSubject();
        return (UserEntity) this.userDetailService.loadUserByUsername(email);
    }

    private String generateToken(String username, String roleName, Date expire) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", roleName)
                .withIssuedAt(new Date())
                .withExpiresAt(expire)
                .sign(Algorithm.HMAC256(this.jwtConfig.getSecretkeyToken().getBytes()));
    }

    private String generateRefreshToken(String username, String roleName, Date expire) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", roleName)
                .withIssuedAt(new Date())
                .withExpiresAt(expire)
                .sign(Algorithm.HMAC256(this.jwtConfig.getSecretRefreshToken().getBytes()));
    }

    private Date calculateDateInMinutes(Integer value) {
        return new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(value));
    }

}

package com.ecommerce.posgrado.security.jwt;

import com.ecommerce.posgrado.response.JwtExceptionResponse;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/31/23
 * Time: 21:54
 * Project Name: posgrado
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

            String jwt = authHeader.substring(7);
            JwtAuthenticationToken auth = new JwtAuthenticationToken(jwt);
            JwtAuthenticationToken authResult = (JwtAuthenticationToken) this.authenticationManager
                    .authenticate(auth);

            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authResult);
            SecurityContextHolder.setContext(context);

            filterChain.doFilter(request, response);

    }

    private void onError(HttpServletResponse response,
                         String message) throws IOException {
        JSONObject jtwResponse = new JSONObject(JwtExceptionResponse
                .builder()
                .status(Boolean.FALSE)
                .message(message)
                .time(LocalDateTime.now())
                .build());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        out.print(jtwResponse);
        out.flush();
    }
}

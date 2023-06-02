package com.ecommerce.posgrado.security.jwt;

import com.ecommerce.posgrado.response.JwtExceptionResponse;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * @author gclaure from CochaSoft
 * Date: 6/2/23
 * Time: 00:17
 * Project Name: posgrado
 */
@Component
public class JwtEntryPointSecurity implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        onError(response, authException.getMessage());
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

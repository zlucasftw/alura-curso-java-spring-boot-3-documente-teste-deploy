package br.com.alura.med.voll.api.service.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {


    public String retriveJwtToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer", "").trim();
        }
        return null;
    }

}

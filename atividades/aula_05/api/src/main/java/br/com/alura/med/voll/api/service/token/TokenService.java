package br.com.alura.med.voll.api.service.token;

import br.com.alura.med.voll.api.entity.user.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private static final String ISSUER = "API Voll.med";

    public String getToken(UserEntity user) {
        try {
            var hashedSecret = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getLogin())
                    .withExpiresAt(this.expirationDate())
                    .sign(hashedSecret);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error creating JWT token. ", exception);
        }
    }

    public String getSubject(String jwtToken) {
        try {
            var hashedSecret = Algorithm.HMAC256(secret);
            return JWT.require(hashedSecret)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(jwtToken)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid or expired JWT Token.");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}

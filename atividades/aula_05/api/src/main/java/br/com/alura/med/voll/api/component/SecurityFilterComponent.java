package br.com.alura.med.voll.api.component;

import br.com.alura.med.voll.api.repository.user.UserRepository;
import br.com.alura.med.voll.api.service.security.SecurityService;
import br.com.alura.med.voll.api.service.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilterComponent extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var tokenJWT = securityService.retriveJwtToken(request);

        if (tokenJWT != null) {
            var subject = this.tokenService.getSubject(tokenJWT);
            var user = this.userRepository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(
                    user.getUsername(), null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

}

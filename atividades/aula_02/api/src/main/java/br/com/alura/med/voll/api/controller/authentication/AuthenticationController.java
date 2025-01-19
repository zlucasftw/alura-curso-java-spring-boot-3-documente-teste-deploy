package br.com.alura.med.voll.api.controller.authentication;

import br.com.alura.med.voll.api.dto.authentication.AuthenticationDTO;
import br.com.alura.med.voll.api.dto.authentication.JWTTokenDTO;
import br.com.alura.med.voll.api.entity.user.UserEntity;
import br.com.alura.med.voll.api.service.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTTokenDTO> signIn(@RequestBody @Valid AuthenticationDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(authToken);

        var tokenJWT = tokenService.getToken((UserEntity) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTTokenDTO(tokenJWT));
    }

}

package com.ducapas.api.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducapas.api.config.TokenService;
import com.ducapas.api.dto.AuthenticationDto;
import com.ducapas.api.dto.LoginResponseDTO;
import com.ducapas.api.dto.RegisterDTO;
import com.ducapas.api.model.User;
import com.ducapas.api.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;



@RestController()
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final UserRepository repository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDto data){
        var usernamePass = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = manager.authenticate(usernamePass);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        User user = repository.findByLogin(data.login());
        return ResponseEntity.ok(new LoginResponseDTO(token, user.getNome()));
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDTO data){
        if(repository.findByLogin(data.login())!=null){return ResponseEntity.badRequest().build();}
        String crip = new BCryptPasswordEncoder().encode(data.password());
        User user = User.builder().login(data.login()).nome(data.nome()).password(crip).role("ROLE_ADMIN").build();
        this.repository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gerenciamentoCadastrados")
    public ResponseEntity<List<User>> gerenciamentoCadastrados(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String username = tokenService.validToken(token);

        List<User> users = repository.findAll().stream()
                .filter(user -> !user.getLogin().equals(username))
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if(repository.findById(id)==null){return ResponseEntity.badRequest().build();}
        this.repository.delete(repository.findById(id).get());
        return ResponseEntity.ok().build();
    }
}

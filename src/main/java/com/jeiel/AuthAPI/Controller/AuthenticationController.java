package com.jeiel.AuthAPI.Controller;

import com.jeiel.AuthAPI.Domains.User.User;
import com.jeiel.AuthAPI.Repositories.*;
import com.jeiel.AuthAPI.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    @RequestMapping("/users")
    public List<UserDTO> viewUsers(){
        List<User> users = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity loginController(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity registerController(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}

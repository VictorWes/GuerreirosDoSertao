package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.LoginRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.UserRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.UserSummaryResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.User;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.UserMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreiros")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserSummaryResponse> saveUserSummary(@RequestBody UserRequest request){
        User savedUserSummary = userService.save(UserMapper.toEntity(request));
        return ResponseEntity.ok(UserMapper.toResponse(savedUserSummary));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();



    }

}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.config.TokenService;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.LoginRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.SkillRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.UserRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.LoginResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.SkillResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.UserSummaryResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.User;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.SkillMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.UserMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.UserService;
import org.antlr.v4.runtime.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreiros/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public UserController(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserSummaryResponse> saveUserSummary(@RequestBody UserRequest request){
        User savedUserSummary = userService.save(UserMapper.toEntity(request));
        return ResponseEntity.ok(UserMapper.toResponse(savedUserSummary));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));


    }


}

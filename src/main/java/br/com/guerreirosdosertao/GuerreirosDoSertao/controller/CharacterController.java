package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CharacterRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.*;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.CharacterMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.UserMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.*;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guerreirosdosertao/character")
public class CharacterController {

    private final CharacterService characterService;
    private final UserService userService;
    private final ClanService clanService;
    private final CityService cityService;
    private final HistoryService historyGameService;
    private final SkillService skillService;


    public CharacterController(CharacterService characterService, UserService userService, ClanService clanService, CityService cityService, HistoryService historyGameService, SkillService skillService) {
        this.characterService = characterService;
        this.userService = userService;
        this.clanService = clanService;
        this.cityService = cityService;
        this.historyGameService = historyGameService;
        this.skillService = skillService;
    }

    @PostMapping("/registrar/basico")
    public ResponseEntity<CharacterResponse> characterResponseSave(@RequestBody CharacterRequest character){

        Character savedUser = characterService.saveCharacter(CharacterMapper.toEntityBasic(character));
        return ResponseEntity.ok(CharacterMapper.toResponse(savedUser));

    }

    @PostMapping("/registar/detalhado")
    public ResponseEntity<CharacterResponse> createCharacter(@Valid @RequestBody CharacterRequest request) {
        try {
            User user = userService.findById(request.usersId());
            Clan clan = request.clanId() != null ? clanService.findById(request.clanId()) : null;
            City city = cityService.findById(request.cityId());
            HistoryGame historyGame = historyGameService.findById(request.historyGameId());

            // CORRETO: usar findByIds (plural) para lista de IDs
            List<Skill> skills = request.skillsIds() != null ?
                    skillService.findByIds(request.skillsIds()) : null;

            Character character = CharacterMapper.toEntity(request, user, clan, historyGame, city, skills);

            Character savedCharacter = characterService.saveCharacter(character);
            CharacterResponse response = CharacterMapper.toResponse(savedCharacter);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CharacterRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.HistoryGameRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.SkillRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.HistoryGameResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.SkillResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.HistoryGameMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.SkillMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guerreirosdosertao/skill")
public class SkillController {


    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    ResponseEntity<SkillResponse> historySave(@RequestBody SkillRequest skill){
        Skill historyGameSa = skillService.saveSkill(SkillMapper.toEntity(skill));
        return ResponseEntity.ok(SkillMapper.toResponse(historyGameSa));
    }
}

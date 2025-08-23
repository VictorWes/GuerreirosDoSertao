package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Battle;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.CharacterRepository;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.SimpleBattleService;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battle")
public class BattleController {


    private final SimpleBattleService battleService;
    private final CharacterRepository characterRepository;

    public BattleController(SimpleBattleService battleService, CharacterRepository characterRepository) {
        this.battleService = battleService;
        this.characterRepository = characterRepository;
    }

    @PostMapping("/simulate/{char1Id}/{char2Id}")
    public Battle simulateBattle(@PathVariable Long char1Id, @PathVariable Long char2Id) {
        Character char1 = characterRepository.findById(char1Id).orElseThrow();
        Character char2 = characterRepository.findById(char2Id).orElseThrow();

        return battleService.simulateBattle(char1, char2);
    }
}

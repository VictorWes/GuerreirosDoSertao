package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.City;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;


    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character saveCharacter(Character character){
        return characterRepository.save(character);
    }

    public Character findById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clan not found with id: " + id));
    }
}
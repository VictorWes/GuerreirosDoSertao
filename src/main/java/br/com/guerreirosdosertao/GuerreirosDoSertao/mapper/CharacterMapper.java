package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CharacterRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.*;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.*;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import lombok.experimental.UtilityClass;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@UtilityClass
public class CharacterMapper {

    public static Character toEntity(CharacterRequest request,
                                     User user,
                                     Clan clan,
                                     HistoryGame historyGame,
                                     City city,
                                     List<Skill> skills) {

        return Character.builder()
                .name(request.name())
                .age(request.age())
                .biography(request.biography())
                .atributo(request.atributo())
                .users(user)
                .clan(clan)
                .historyGame(historyGame)
                .city(city)
                .skills(skills != null ? skills : new ArrayList<>())
                .weapons(new ArrayList<>())
                .build();
    }

    public static CharacterResponse toResponse(Character character) {


        List<WeaponResponse> weaponsResponse = character.getWeapons() != null
                ? character.getWeapons().stream()
                .map(WeaponMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();


        List<SkillResponse> skillsResponse = character.getSkills() != null
                ? character.getSkills().stream()
                .map(SkillMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        return CharacterResponse.builder()
                .id(character.getId())
                .name(character.getName())
                .age(character.getAge())
                .biography(character.getBiography())
                .user(UserMapper.toResponseDetail(character.getUsers()))
                .clan(ClanMapper.toResponse(character.getClan()))
                .weapons(weaponsResponse)
                .historyGame(HistoryGameMapper.toResponse(character.getHistoryGame()))
                .city(CityMapper.toResponse(character.getCity()))
                .atributo(character.getAtributo())
                .skills(skillsResponse)
                .createdAt(character.getCreatedAt())
                .updatedAt(character.getUpdatedAt())
                .build();
    }


    public static Character toEntityBasic(CharacterRequest request) {
        return Character.builder()
                .name(request.name())
                .age(request.age())
                .biography(request.biography())
                .atributo(request.atributo())
                .skills(new ArrayList<>())
                .weapons(new ArrayList<>())
                .build();
    }
}


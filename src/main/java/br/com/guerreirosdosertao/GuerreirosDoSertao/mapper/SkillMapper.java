package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.SkillRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.SkillResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class SkillMapper {

    public static Skill toEntity(SkillRequest skillRequest){

        return Skill
                .builder()
                .description(skillRequest.description())
                .habilityName(skillRequest.habilityName())
                .manaSpent(skillRequest.manaSpent())
                .firePower(skillRequest.firePower())
                .difficultyLearning(skillRequest.difficultyLearning())
                .requiredLevel(skillRequest.requiredLevel())
                .build();

    }

    public static SkillResponse toResponse (Skill skill){

        List<CharacterResponse> characterResponses = skill.getCharacters() != null
                ? skill.getCharacters().stream()
                .map(CharacterMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        return SkillResponse.builder()
                .id(skill.getId())
                .habilityName(skill.getHabilityName())
                .description(skill.getDescription())
                .firePower(skill.getFirePower())
                .manaSpent(skill.getManaSpent())
                .difficultyLearning(skill.getDifficultyLearning())
                .requiredLevel(skill.getRequiredLevel())
                .characters(characterResponses)
                .build();

    }


}

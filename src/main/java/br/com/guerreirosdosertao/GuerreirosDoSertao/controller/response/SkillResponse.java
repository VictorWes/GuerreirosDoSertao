package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.List;
import java.util.Set;


@Builder
public record SkillResponse( Long id,
                             String habilityName,
                             String description,
                             int firePower,
                             int manaSpent,
                             int difficultyLearning,
                             int requiredLevel,
                             List<CharacterResponse> characters) {
}

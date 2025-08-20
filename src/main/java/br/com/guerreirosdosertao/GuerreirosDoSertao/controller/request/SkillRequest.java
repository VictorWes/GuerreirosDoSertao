package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record SkillRequest(  String habilityName,
                             String description,
                             int firePower,
                             int manaSpent,
                             int difficultyLearning,
                             int requiredLevel,
                             List<Long> characters) {
}

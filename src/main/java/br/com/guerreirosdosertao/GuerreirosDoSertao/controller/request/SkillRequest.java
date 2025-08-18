package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

@Builder
public record SkillRequest(  String habilityName,
                             String description,
                             int firePower,
                             int manaSpent,
                             int difficultyLearning,
                             int requiredLevel) {
}

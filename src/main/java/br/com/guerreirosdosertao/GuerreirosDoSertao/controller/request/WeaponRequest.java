package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

@Builder
public record WeaponRequest(  String nameWeapon,
                              int powerDamage,
                              int requiredLevel,
                              int difficultyLearning) {
}

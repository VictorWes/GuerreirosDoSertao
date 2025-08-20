package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record WeaponResponse(  Long id,
                               String nameWeapon,
                               int powerDamage,
                               int requiredLevel,
                               int difficultyLearning,
                               CharacterResponse character) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.WeaponRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.WeaponResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Weapon;
import lombok.experimental.UtilityClass;



@UtilityClass
public class WeaponMapper {

    public static Weapon toEntity(WeaponRequest request) {
        return Weapon.builder()
                .nameWeapon(request.nameWeapon())
                .powerDamage(request.powerDamage())
                .requiredLevel(request.requiredLevel())
                .difficultyLearning(request.difficultyLearning())
                .build();
    }

    public static WeaponResponse toResponse(Weapon weapon) {
        return WeaponResponse.builder()
                .id(weapon.getId())
                .nameWeapon(weapon.getNameWeapon())
                .powerDamage(weapon.getPowerDamage())
                .requiredLevel(weapon.getRequiredLevel())
                .difficultyLearning(weapon.getDifficultyLearning())
                .character(weapon.getCharacters() != null
                        ? CharacterMapper.toResponse(weapon.getCharacters())
                        : null)
                .build();
    }

}

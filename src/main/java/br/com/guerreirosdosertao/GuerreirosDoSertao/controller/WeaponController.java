package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.SkillRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.WeaponRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.SkillResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.WeaponResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Weapon;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.SkillMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.WeaponMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.WeaponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreirosdosertao/weapon")
public class WeaponController {


    private final WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @PostMapping
    ResponseEntity<WeaponResponse> historySave(@RequestBody WeaponRequest weaponRequest){
        Weapon weapon = weaponService.saveWeapon(WeaponMapper.toEntity(weaponRequest));
        return ResponseEntity.ok(WeaponMapper.toResponse(weapon));
    }
}

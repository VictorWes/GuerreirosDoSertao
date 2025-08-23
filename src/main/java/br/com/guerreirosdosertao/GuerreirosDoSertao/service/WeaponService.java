package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.User;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Weapon;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon saveWeapon(Weapon weapon){
        return weaponRepository.save(weapon);
    }

    public Weapon findById(Long id) {
        return weaponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clan not found with id: " + id));
    }
}

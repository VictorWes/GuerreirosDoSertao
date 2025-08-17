package br.com.guerreirosdosertao.GuerreirosDoSertao.repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}

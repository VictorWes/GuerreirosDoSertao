package br.com.guerreirosdosertao.GuerreirosDoSertao.Repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.Entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}

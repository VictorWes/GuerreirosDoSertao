package br.com.guerreirosdosertao.GuerreirosDoSertao.Repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.Entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}

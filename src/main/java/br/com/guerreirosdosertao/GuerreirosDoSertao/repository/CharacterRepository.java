package br.com.guerreirosdosertao.GuerreirosDoSertao.repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}

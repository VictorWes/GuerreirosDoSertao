package br.com.guerreirosdosertao.GuerreirosDoSertao.repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}

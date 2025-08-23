package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    public Skill saveSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public List<Skill> findByIds(List<Long> ids) {
        return skillRepository.findAllById(ids);
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
    }
}

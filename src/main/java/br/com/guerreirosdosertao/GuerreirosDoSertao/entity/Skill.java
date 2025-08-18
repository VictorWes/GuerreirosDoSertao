package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String habilityName;

    @Column(nullable = false, length = 120)
    private String description;

    @Min(1)
    @Column(nullable = false)
    private int firePower;

    @Min(0)
    @Column(nullable = false)
    private int manaSpent;

    @Min(0)
    @Column(nullable = false)
    private int difficultyLearning;

    @Min(0)
    @Column(nullable = false)
    private int requiredLevel;

    @ManyToMany(mappedBy = "skills")
    private Set<Character> characters = new HashSet<>();

    public Skill() {
    }

    public Skill(Long id, String habilityName, String description, int firePower, int manaSpent, int difficultyLearning, int requiredLevel, Set<Character> characters) {
        this.id = id;
        this.habilityName = habilityName;
        this.description = description;
        this.firePower = firePower;
        this.manaSpent = manaSpent;
        this.difficultyLearning = difficultyLearning;
        this.requiredLevel = requiredLevel;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabilityName() {
        return habilityName;
    }

    public void setHabilityName(String habilityName) {
        this.habilityName = habilityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public int getManaSpent() {
        return manaSpent;
    }

    public void setManaSpent(int manaSpent) {
        this.manaSpent = manaSpent;
    }

    public int getDifficultyLearning() {
        return difficultyLearning;
    }

    public void setDifficultyLearning(int difficultyLearning) {
        this.difficultyLearning = difficultyLearning;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}

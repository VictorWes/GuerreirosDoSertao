package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String nameWeapon;

    @Min(1)
    @Column(nullable = false)
    private int powerDamage;

    @Min(0)
    @Column(nullable = false)
    private int requiredLevel;

    @Min(0)
    @Column(nullable = false)
    private int difficultyLearning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id",
               foreignKey = @ForeignKey(name = "fk_weapon"))
    private Character characters;

    public Weapon() {
    }

    public Weapon(Long id, String nameWeapon, int powerDamage, int requiredLevel, int difficultyLearning, Character characters) {
        this.id = id;
        this.nameWeapon = nameWeapon;
        this.powerDamage = powerDamage;
        this.requiredLevel = requiredLevel;
        this.difficultyLearning = difficultyLearning;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public void setNameWeapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public int getPowerDamage() {
        return powerDamage;
    }

    public void setPowerDamage(int powerDamage) {
        this.powerDamage = powerDamage;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getDifficultyLearning() {
        return difficultyLearning;
    }

    public void setDifficultyLearning(int difficultyLearning) {
        this.difficultyLearning = difficultyLearning;
    }

    public Character getCharacters() {
        return characters;
    }

    public void setCharacters(Character characters) {
        this.characters = characters;
    }
}

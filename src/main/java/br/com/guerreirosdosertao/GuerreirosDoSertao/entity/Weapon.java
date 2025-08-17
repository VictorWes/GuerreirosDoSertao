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

}

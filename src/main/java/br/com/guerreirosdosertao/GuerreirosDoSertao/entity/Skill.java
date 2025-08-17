package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_skill", columnNames = "habilityName")
        })
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
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



}

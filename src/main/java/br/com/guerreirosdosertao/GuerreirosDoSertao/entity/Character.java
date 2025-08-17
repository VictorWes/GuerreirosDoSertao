package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters",
       indexes = {
       @Index(name = "ix_characters_name", columnList = "name")
       },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_characters", columnNames = "name")
        })
public class Character {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Min(0)
    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String biography;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id",
                foreignKey = @ForeignKey(name = "fk_character_users"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clans_id",
                foreignKey = @ForeignKey(name = "fk_character_clans"))
    private Clan clan;

    @OneToMany(mappedBy = "characters", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Weapon> weapons = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_character_historygame"))
    private HistoryGame historyGame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_character_city"))
    private City city;

    @ManyToMany
    @JoinTable(name = "character_skills",
               joinColumns = @JoinColumn(name = "character_id"),
               inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private Set<Skill> skills = new HashSet<>();

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;






}

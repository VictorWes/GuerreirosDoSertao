package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import br.com.guerreirosdosertao.GuerreirosDoSertao.embeddable.Atributo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@Table(name = "characters")
public class Character {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String name;

    @Min(0)
    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String biography;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id",
                foreignKey = @ForeignKey(name = "fk_character_users"))
    private User users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clans_id",
                foreignKey = @ForeignKey(name = "fk_character_clans"))
    private Clan clan;

    @OneToMany(mappedBy = "characters", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Weapon> weapons = new ArrayList<>();

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
    private List<Skill> skills = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Embedded
    private Atributo atributo;



    public Character() {
    }

    public Character(Long id, String name, int age, String biography, User users, Clan clan, List<Weapon> weapons, HistoryGame historyGame, City city, List<Skill> skills, LocalDateTime createdAt, LocalDateTime updatedAt, Atributo atributo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.users = users;
        this.clan = clan;
        this.weapons = weapons;
        this.historyGame = historyGame;
        this.city = city;
        this.skills = skills;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.atributo = atributo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public HistoryGame getHistoryGame() {
        return historyGame;
    }

    public void setHistoryGame(HistoryGame historyGame) {
        this.historyGame = historyGame;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }
}

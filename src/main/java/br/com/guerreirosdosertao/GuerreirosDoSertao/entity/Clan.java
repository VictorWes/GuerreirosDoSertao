package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "clans")
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String name;

    @Column(nullable = false, length = 120)
    private String description;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String clanHistory;

    @OneToMany(mappedBy = "clan", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Character> characters = new ArrayList<>();


    public Clan() {
    }

    public Clan(Long id, String name, String description, String clanHistory, List<Character> characters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clanHistory = clanHistory;
        this.characters = characters;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClanHistory() {
        return clanHistory;
    }

    public void setClanHistory(String clanHistory) {
        this.clanHistory = clanHistory;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<HistoryGame> historyGame;


    public City() {
    }

    public City(Long id, String cityName, Set<Character> characters, Set<HistoryGame> historyGame) {
        this.id = id;
        this.cityName = cityName;
        this.characters = characters;
        this.historyGame = historyGame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Set<HistoryGame> getHistoryGame() {
        return historyGame;
    }

    public void setHistoryGame(Set<HistoryGame> historyGame) {
        this.historyGame = historyGame;
    }
}

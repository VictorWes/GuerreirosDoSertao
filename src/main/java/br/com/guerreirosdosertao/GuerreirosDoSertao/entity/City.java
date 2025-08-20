package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Character> characters = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<HistoryGame> historyGame;


    public City() {
    }

    public City(Long id, String cityName, List<Character> characters, List<HistoryGame> historyGame) {
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

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<HistoryGame> getHistoryGame() {
        return historyGame;
    }

    public void setHistoryGame(List<HistoryGame> historyGame) {
        this.historyGame = historyGame;
    }
}

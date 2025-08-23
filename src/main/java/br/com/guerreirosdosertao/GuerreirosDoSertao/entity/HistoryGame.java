package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;

@Builder
@Entity
@Table(name = "history_game")
public class HistoryGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Column(nullable = false, unique = true)
    private int season;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String history;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",
            foreignKey = @ForeignKey(name = "fk_history_game_city"))
    @JsonProperty("city")
    private City city;


    public HistoryGame() {
    }

    public HistoryGame(Long id, int season, String history, City city) {
        this.id = id;
        this.season = season;
        this.history = history;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "history_game")
public class HistoryGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String season;

    private String history;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_history_game_city"))
    private Set<City> city = new HashSet<>();




}

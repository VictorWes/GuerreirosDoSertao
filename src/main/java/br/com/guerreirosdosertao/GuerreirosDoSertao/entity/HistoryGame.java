package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name = "city_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_history_game_city"))
    private Set<City> city = new HashSet<>();




}

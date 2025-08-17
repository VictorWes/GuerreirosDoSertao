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
    private HistoryGame historyGame;




}

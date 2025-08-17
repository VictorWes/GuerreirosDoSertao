package br.com.guerreirosdosertao.GuerreirosDoSertao.Entity;

import jakarta.persistence.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters = new HashSet<>();


    @OneToMany(mappedBy = "city", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private HistoryGame historyGame;




}

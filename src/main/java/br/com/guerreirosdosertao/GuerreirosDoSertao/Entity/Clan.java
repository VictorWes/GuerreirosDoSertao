package br.com.guerreirosdosertao.GuerreirosDoSertao.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clans",
     uniqueConstraints = {
        @UniqueConstraint(name = "uk_clans_name", columnNames = "name")
      })
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 120)
    private String description;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String clanHistory;

    @OneToMany(mappedBy = "clans", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Character> characters = new ArrayList<>();





}

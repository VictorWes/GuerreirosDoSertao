package br.com.guerreirosdosertao.GuerreirosDoSertao.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character1_id", nullable = false)
    private Character character1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character2_id", nullable = false)
    private Character character2;

    @Column(name = "winner_name", length = 120)
    private String winnerName;

    @Column(name = "battle_result", columnDefinition = "TEXT")
    private String battleResult;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public Battle() {
    }

    public Battle(Long id, Character character1, Character character2, String winnerName, String battleResult, LocalDateTime createdAt) {
        this.id = id;
        this.character1 = character1;
        this.character2 = character2;
        this.winnerName = winnerName;
        this.battleResult = battleResult;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter1() {
        return character1;
    }

    public void setCharacter1(Character character1) {
        this.character1 = character1;
    }

    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(Character character2) {
        this.character2 = character2;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getBattleResult() {
        return battleResult;
    }

    public void setBattleResult(String battleResult) {
        this.battleResult = battleResult;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

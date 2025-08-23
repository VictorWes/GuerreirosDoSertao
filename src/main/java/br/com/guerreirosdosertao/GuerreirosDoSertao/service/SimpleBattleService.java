package br.com.guerreirosdosertao.GuerreirosDoSertao.service;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Battle;
import org.springframework.stereotype.Service;

@Service
public class SimpleBattleService {

    public Battle simulateBattle(Character char1, Character char2) {
        StringBuilder battleLog = new StringBuilder();

        int hp1 = calculateHp(char1);
        int hp2 = calculateHp(char2);

        battleLog.append("=== BATALHA: ").append(char1.getName())
                .append(" vs ").append(char2.getName()).append(" ===\n\n");

        battleLog.append(char1.getName()).append(" HP: ").append(hp1).append("\n");
        battleLog.append(char2.getName()).append(" HP: ").append(hp2).append("\n\n");

        int turno = 1;
        while (hp1 > 0 && hp2 > 0) {
            battleLog.append("--- Turno ").append(turno).append(" ---\n");

            if (hp1 > 0) {
                int dano = calculateDamage(char1, char2);
                hp2 -= dano;
                if (hp2 < 0) hp2 = 0;

                battleLog.append(char1.getName()).append(" atacou ").append(char2.getName())
                        .append(" e causou ").append(dano).append(" de dano!\n");
                battleLog.append(char2.getName()).append(" HP: ").append(hp2).append("\n");
            }

            if (hp2 > 0 && hp1 > 0) {
                int dano = calculateDamage(char2, char1);
                hp1 -= dano;
                if (hp1 < 0) hp1 = 0;

                battleLog.append(char2.getName()).append(" atacou ").append(char1.getName())
                        .append(" e causou ").append(dano).append(" de dano!\n");
                battleLog.append(char1.getName()).append(" HP: ").append(hp1).append("\n");
            }

            battleLog.append("\n");
            turno++;
        }

        String winner;
        if (hp1 > 0) {
            winner = char1.getName();
            battleLog.append("🏆 ").append(char1.getName()).append(" VENCEU! 🏆");
        } else {
            winner = char2.getName();
            battleLog.append("🏆 ").append(char2.getName()).append(" VENCEU! 🏆");
        }

        return Battle.builder()
                .character1(char1)
                .character2(char2)
                .winnerName(winner)
                .battleResult(battleLog.toString())
                .build();
    }

    private int calculateHp(Character character) {
        int baseHp = 100;
        int stamina = character.getAtributo().getStamina();
        return baseHp + (stamina * 10);
    }


    private int calculateDamage(Character attacker, Character target) {

        int baseDamage = 20;
        if (!attacker.getWeapons().isEmpty()) {
            baseDamage = attacker.getWeapons().get(0).getPowerDamage();
        }

        int strength = attacker.getAtributo().getStrength();
        double strengthBonus = (strength / 10.0) * 0.01;


        int finalDamage = (int) (baseDamage + (baseDamage * strengthBonus));

        double randomFactor = 0.8 + (Math.random() * 0.4);
        finalDamage = (int) (finalDamage * randomFactor);

        return Math.max(1, finalDamage);
    }

}

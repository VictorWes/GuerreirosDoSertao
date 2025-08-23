package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Skill;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.HistoryGameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryService {

    private final HistoryGameRepository historyGame;

    public HistoryService(HistoryGameRepository historyGame) {
        this.historyGame = historyGame;
    }

    public HistoryGame saveHistory(HistoryGame skill){
        return historyGame.save(skill);
    }

    public HistoryGame findById(Long id) {
        return historyGame.findById(id)
                .orElseThrow(() -> new RuntimeException("Clan not found with id: " + id));
    }
}

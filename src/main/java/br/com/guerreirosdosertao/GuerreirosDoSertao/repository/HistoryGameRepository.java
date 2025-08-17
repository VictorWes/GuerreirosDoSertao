package br.com.guerreirosdosertao.GuerreirosDoSertao.repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryGameRepository extends JpaRepository<HistoryGame, Long> {
}

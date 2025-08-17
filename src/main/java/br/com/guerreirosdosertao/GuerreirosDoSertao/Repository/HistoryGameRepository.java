package br.com.guerreirosdosertao.GuerreirosDoSertao.Repository;

import br.com.guerreirosdosertao.GuerreirosDoSertao.Entity.HistoryGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryGameRepository extends JpaRepository<HistoryGame, Long> {
}

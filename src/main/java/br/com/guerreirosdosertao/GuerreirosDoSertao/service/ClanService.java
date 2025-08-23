package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Clan;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.ClanRepository;
import org.springframework.stereotype.Service;

@Service
public class ClanService {

    private final ClanRepository clanRepository;

    public ClanService(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    public Clan saveClan(Clan clan){
        return clanRepository.save(clan);
    }

    public Clan findById(Long id) {
        return clanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clan not found with id: " + id));
    }
}

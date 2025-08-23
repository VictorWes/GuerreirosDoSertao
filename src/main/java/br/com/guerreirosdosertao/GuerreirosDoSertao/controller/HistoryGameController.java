package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;


import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.ClanRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.HistoryGameRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.ClanResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.HistoryGameResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Clan;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.ClanMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.HistoryGameMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreirosdosertao/history")
public class HistoryGameController {


    private final HistoryService historyService;

    public HistoryGameController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    ResponseEntity<HistoryGameResponse> historySave(@RequestBody HistoryGameRequest history){
        HistoryGame historyGameSa = historyService.saveHistory(HistoryGameMapper.toEntity(history));
        return ResponseEntity.ok(HistoryGameMapper.toResponse(historyGameSa));
    }
}

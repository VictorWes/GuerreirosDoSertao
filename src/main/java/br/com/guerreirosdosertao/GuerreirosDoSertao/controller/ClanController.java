package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;


import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CityRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.ClanRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CityResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.ClanResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.City;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Clan;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.CityMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.ClanMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.ClanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreirosdosertao/clan")
public class ClanController {

    private final ClanService clanService;

    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    @PostMapping
    ResponseEntity<ClanResponse> clanSave(@RequestBody ClanRequest clan){
        Clan clanSa = clanService.saveClan(ClanMapper.toEntity(clan));
        return ResponseEntity.ok(ClanMapper.toResponse(clanSa));
    }
}

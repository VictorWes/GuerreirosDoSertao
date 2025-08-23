package br.com.guerreirosdosertao.GuerreirosDoSertao.controller;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CityRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CityResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.City;
import br.com.guerreirosdosertao.GuerreirosDoSertao.mapper.CityMapper;
import br.com.guerreirosdosertao.GuerreirosDoSertao.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guerreirosdosertao/city")
public class CityController {

    private final CityService cityService;


    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    ResponseEntity<CityResponse> saveCity(@RequestBody CityRequest city){
        City citySa = cityService.saveCity(CityMapper.toEntity(city));
        return ResponseEntity.ok(CityMapper.toResponse(citySa));
    }
}

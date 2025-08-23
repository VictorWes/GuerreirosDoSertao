package br.com.guerreirosdosertao.GuerreirosDoSertao.service;

import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.City;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Clan;
import br.com.guerreirosdosertao.GuerreirosDoSertao.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clan not found with id: " + id));
    }
}

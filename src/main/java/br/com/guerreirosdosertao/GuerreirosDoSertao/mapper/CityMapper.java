package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.CityRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CityResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.HistoryGameResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.City;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CityMapper {

    public static City toEntity(CityRequest cityRequest){

        return City
                .builder()
                .cityName(cityRequest.cityName())
                .build();
    }

    public static CityResponse toResponse(City city){

        List<CharacterResponse> characterResponse = city.getCharacters() !=null
                ? city.getCharacters()
                .stream()
                .map(CharacterMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        List<HistoryGameResponse> historyGameResponses = city.getHistoryGame() !=null
                ? city.getHistoryGame()
                .stream()
                .map(HistoryGameMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        return CityResponse
                .builder()
                .id(city.getId())
                .historyGame(historyGameResponses)
                .cityName(city.getCityName())
                .characters(characterResponse)
                .build();


    }

}

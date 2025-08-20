package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.HistoryGameRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CityResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.HistoryGameResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.HistoryGame;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HistoryGameMapper {


    public static HistoryGame toEntity(HistoryGameRequest request){

        return HistoryGame
                .builder()
                .season(request.season())
                .history(request.history())
                .build();

    }


    public static HistoryGameResponse toResponse(HistoryGame response){


        return HistoryGameResponse
                .builder()
                .id(response.getId())
                .season(response.getSeason())
                .history(response.getHistory())
                .city(response.getCity() != null ?
                        CityMapper.toResponse(response.getCity())
                        :null)
                .build();


    }

}

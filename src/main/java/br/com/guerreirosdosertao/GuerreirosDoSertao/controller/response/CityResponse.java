package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record CityResponse( Long id,
                            String cityName,
                            List<CharacterResponse> characters,
                            List<HistoryGameResponse> historyGame) {
}

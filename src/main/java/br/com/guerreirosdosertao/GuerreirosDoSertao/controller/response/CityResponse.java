package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.Set;

@Builder
public record CityResponse( Long id,
                            String cityName,
                            Set<CharacterResponse> characters,
                            Set<HistoryGameResponse> historyGame) {
}

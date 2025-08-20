package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record CityResponse( Long id,
                            String cityName,
                            List<CharacterResponse> characters,
                            List<HistoryGameResponse> historyGame) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

@Builder
public record HistoryGameResponse( Long id,
                                   int season,
                                   String history,
                                   CityResponse city) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

@Builder
public record HistoryGameRequest(int season,
                                 String history) {
}

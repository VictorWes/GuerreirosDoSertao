package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

@Builder
public record ClanRequest( String name,
                           String description,
                           String clanHistory) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ClanResponse( Long id,
                            String name,
                            String description,
                            String clanHistory,
                            List<CharacterResponse> characters) {
}

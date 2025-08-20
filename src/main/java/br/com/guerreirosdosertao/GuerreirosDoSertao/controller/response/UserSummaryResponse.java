package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

//Response para listagens basicas sem characters.

@Builder
public record UserSummaryResponse( Long id,
                                   String name,
                                   String email,
                                   LocalDateTime createdAt) {
}

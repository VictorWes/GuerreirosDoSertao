package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record UserResponse( Long id,
                            String name,
                            String email,
                            String cpf,
                            List<CharacterResponse> characters,
                            LocalDateTime createdAt,
                            LocalDateTime updateAt) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import br.com.guerreirosdosertao.GuerreirosDoSertao.embeddable.Atributo;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record CharacterResponse(Long id,
                                String name,
                                int age,
                                String biography,
                                UserResponse user,
                                ClanResponse clan,
                                Set<WeaponResponse> weapons,
                                HistoryGameResponse historyGame,
                                CityResponse city,
                                Atributo atributo,
                                Set<SkillResponse> skills,
                                LocalDateTime createdAt,
                                LocalDateTime updatedAt) {
}

package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response;

import br.com.guerreirosdosertao.GuerreirosDoSertao.embeddable.Atributo;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
public record CharacterResponse(Long id,
                                String name,
                                int age,
                                String biography,
                                UserResponseDetail user,
                                ClanResponse clan,
                                List<WeaponResponse> weapons,
                                HistoryGameResponse historyGame,
                                CityResponse city,
                                Atributo atributo,
                                List<SkillResponse> skills,
                                LocalDateTime createdAt,
                                LocalDateTime updatedAt) {
}

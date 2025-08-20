package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import br.com.guerreirosdosertao.GuerreirosDoSertao.embeddable.Atributo;
import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record CharacterRequest( String name,
                                int age,
                                String biography,
                                Long usersId,
                                Long clanId,
                                Long historyGameId,
                                Long cityId,
                                Atributo atributo,
                                List<Long> skillsIds) {
}

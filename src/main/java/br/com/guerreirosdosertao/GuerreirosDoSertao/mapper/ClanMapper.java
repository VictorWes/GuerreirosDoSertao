package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.ClanRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.ClanResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Clan;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ClanMapper {

    public static Clan toEntity(ClanRequest request){

        return Clan
                .builder()
                .name(request.name())
                .clanHistory(request.clanHistory())
                .description(request.description())
                .build();
    }


    public static ClanResponse toResponse(Clan response){

        List<CharacterResponse> characterResponses = response.getCharacters() !=null
                ? response.getCharacters()
                .stream()
                .map(CharacterMapper::toResponse)
                .collect(Collectors.toList())
                : List.of();

        return ClanResponse
                .builder()
                .id(response.getId())
                .name(response.getName())
                .clanHistory(response.getClanHistory())
                .description(response.getDescription())
                .characters(characterResponses)
                .build();
    }

}

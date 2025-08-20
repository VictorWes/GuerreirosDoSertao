package br.com.guerreirosdosertao.GuerreirosDoSertao.mapper;

import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request.UserRequest;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.CharacterResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.UserResponseDetail;
import br.com.guerreirosdosertao.GuerreirosDoSertao.controller.response.UserSummaryResponse;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.Character;
import br.com.guerreirosdosertao.GuerreirosDoSertao.entity.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {

    public static User toEntity(UserRequest userRequest){

        return User
                .builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .cpf(userRequest.cpf())
                .password(userRequest.password())
                .build();
    }

    public static UserSummaryResponse toResponse(User user) {
        return new UserSummaryResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }


    public static UserResponseDetail toResponseDetail(User userResponse){


    List<CharacterResponse> characters = userResponse.getCharacters() !=null
            ? userResponse.getCharacters()
            .stream()
            .map(CharacterMapper::toResponse)
            .collect(Collectors.toList())
            : List.of();


      return UserResponseDetail
              .builder()
              .id(userResponse.getId())
              .name(userResponse.getName())
              .email(userResponse.getEmail())
              .createdAt(userResponse.getCreatedAt())
              .characters(characters)
              .build();

    }


}

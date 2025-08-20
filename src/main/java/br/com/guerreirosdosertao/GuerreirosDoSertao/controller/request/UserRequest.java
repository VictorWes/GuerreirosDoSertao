package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

import java.util.List;

@Builder
public record UserRequest(  String name,
                            String email,
                            String cpf,
                            String password,
                            List<Long> characters) {
}

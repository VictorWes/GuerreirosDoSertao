package br.com.guerreirosdosertao.GuerreirosDoSertao.controller.request;

import lombok.Builder;

@Builder
public record UserRequest(  String name,
                            String email,
                            String cpf,
                            String password) {
}

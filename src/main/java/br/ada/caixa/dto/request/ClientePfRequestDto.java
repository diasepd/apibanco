package br.ada.caixa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientePfRequestDto {
    private String cpf;
    private String nome;
}

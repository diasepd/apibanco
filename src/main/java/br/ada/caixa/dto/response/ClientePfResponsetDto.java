package br.ada.caixa.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class ClientePfResponsetDto {

    private Long id;
    private String cpf;
    private String nome;
}
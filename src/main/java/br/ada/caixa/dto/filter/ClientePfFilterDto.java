package br.ada.caixa.dto.filter;

import lombok.Getter;

@Getter
public class ClientePfFilterDto {
    private Long id;
    private String cpf;
    private String nome;

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }
}

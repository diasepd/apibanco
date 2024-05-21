package br.ada.caixa.dto.request;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public class ClientePfRequestDto {
    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package br.ada.caixa.dto.filter;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class ClientePfFilterDto {
    private Long id;
    private String cpf;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

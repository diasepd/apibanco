package br.ada.caixa.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

//@Table
//@Setter
//@Getter
@Entity
@DiscriminatorValue("PF")
public class ClientePf extends Cliente {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "CPF", length = 11)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
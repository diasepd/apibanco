package br.ada.caixa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
//@Table
@Setter
@Getter
@ToString
public class ClientePf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CPF", length = 11)
    private String cpf;
    private String nome;

}

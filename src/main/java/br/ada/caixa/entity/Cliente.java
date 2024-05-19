package br.ada.caixa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //informa que é uma classe extendida
@DiscriminatorColumn(name="tipo_pessoa", discriminatorType = DiscriminatorType.STRING, length = 10)
public class Cliente {
    @Id
    private String documento;

    @Enumerated(EnumType.STRING)
    private StatusCliente status;
}
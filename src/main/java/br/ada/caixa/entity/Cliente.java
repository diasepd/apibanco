package br.ada.caixa.entity;

import br.ada.caixa.enums.StatusCliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

//@Getter
//@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //informa que é uma classe extendida
@DiscriminatorColumn(name="tipo_pessoa", discriminatorType = DiscriminatorType.STRING, length = 10)
public class Cliente {
    @Id
    private String documento;

    @Enumerated(EnumType.STRING)
    private StatusCliente status;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }
}
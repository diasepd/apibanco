package br.ada.caixa.dto.response;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public class ClienteResponsetDto {
    private String documento;
    private String tipo;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
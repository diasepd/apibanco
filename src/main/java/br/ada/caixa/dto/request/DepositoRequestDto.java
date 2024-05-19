package br.ada.caixa.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class DepositoRequestDto {
    private String numeroConta;
    private BigDecimal valor;
}

package br.ada.caixa.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class SaldoResponseDto {
    private String numeroConta;
    private BigDecimal saldo;
}
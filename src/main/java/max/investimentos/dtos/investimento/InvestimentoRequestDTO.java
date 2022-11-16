package max.investimentos.dtos.investimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.investimentos.enums.TipoDeAcao;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestimentoRequestDTO {

    private String titulo;
    private int quantidade;
    private Double valor;
    private TipoDeAcao tipoDeAcao;
    private final LocalDateTime data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

}

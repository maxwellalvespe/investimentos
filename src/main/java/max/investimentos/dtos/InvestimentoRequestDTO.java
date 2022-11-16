package max.investimentos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

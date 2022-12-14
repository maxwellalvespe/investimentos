package max.investimentos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.investimentos.domain.dtos.TipoDeAcao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LivroCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registro;

    private String titulo;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false,precision = 2)
    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoDeAcao tipoDeAcao;

    private String idInvestidor;

    private Double lucro;

    private Double totalTransacao;

    private final LocalDateTime data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

}

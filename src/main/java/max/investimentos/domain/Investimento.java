package max.investimentos.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String acao;
    private Double precoDeCompra;
    private Double precoDeVenda;
    //TODO A quantidade de ações atual será  devolvida através do calculo da quantidade adiquirida - quantidade vendida
    private int quantidadeAdiquirida;
    private int quantidadeVendida;

    @ManyToOne
    @JoinColumn(name = "investimentos")
    RegistroDeInvestimentos registroDeInvestimentos;

    public Integer obterQuantidadeDeAcoes() {
        return getQuantidadeAdiquirida() - getQuantidadeVendida();
    }
}

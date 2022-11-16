package max.investimentos.dtos.investidor;

import lombok.Data;
import max.investimentos.domain.Investidor;

@Data
public class InvestidorRequest {

    private String nome;

    public Investidor convert(InvestidorRequest investidorRequest) {
        return new Investidor(investidorRequest.nome);
    }
}


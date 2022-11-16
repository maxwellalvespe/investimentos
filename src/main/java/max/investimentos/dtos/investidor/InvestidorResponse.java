package max.investimentos.dtos.investidor;

import lombok.Data;
import max.investimentos.domain.Investidor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
public class InvestidorResponse {

    private UUID id;

    private String nome;

    public static InvestidorResponse of(Investidor investidor) {
        InvestidorResponse response = new InvestidorResponse();
        BeanUtils.copyProperties(investidor, response);
        return response;
    }
}

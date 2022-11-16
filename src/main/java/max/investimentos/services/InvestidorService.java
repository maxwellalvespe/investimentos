package max.investimentos.services;

import max.investimentos.dtos.investidor.InvestidorRequest;
import max.investimentos.dtos.investidor.InvestidorResponse;

import java.util.List;
import java.util.UUID;

public interface InvestidorService {

    InvestidorResponse cadastrar(InvestidorRequest investidorRequest);

    List<InvestidorResponse> listar();

    InvestidorResponse obterInvestidor(UUID id);

    void remover(UUID id);
}

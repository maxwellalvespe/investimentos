package max.investimentos.services.impl;

import lombok.RequiredArgsConstructor;
import max.investimentos.domain.Investidor;
import max.investimentos.dtos.investidor.InvestidorRequest;
import max.investimentos.dtos.investidor.InvestidorResponse;
import max.investimentos.repository.InvestidorRepository;
import max.investimentos.services.InvestidorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestidorImpl implements InvestidorService {

    private final InvestidorRepository repository;

    @Override
    public InvestidorResponse cadastrar(InvestidorRequest investidorRequest) {

        return InvestidorResponse.of(repository.save(investidorRequest.convert(investidorRequest)));

    }

    @Override
    public List<InvestidorResponse> listar() {
        return repository.findAll().stream()
                .map(n -> InvestidorResponse.of(n))
                .collect(Collectors.toList());
    }

    @Override
    public InvestidorResponse obterInvestidor(UUID id) {
        return repository.findById(id)
                .map(investidor -> InvestidorResponse.of(investidor))
                .orElseThrow();

    }

    @Override
    public void remover(UUID id) {

        repository.findById(id).ifPresent(investidor -> repository.delete(investidor));


    }
}

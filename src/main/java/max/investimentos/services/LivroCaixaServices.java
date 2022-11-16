package max.investimentos.services;

import max.investimentos.domain.LivroCaixa;
import max.investimentos.dtos.investimento.InvestimentoRequestDTO;
import max.investimentos.enums.TipoDeAcao;
import max.investimentos.repository.LivroCaixaRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class LivroCaixaServices {

    private LivroCaixaRepository livroCaixaRepository;

    LivroCaixaServices(LivroCaixaRepository livroCaixaRepository) {
        this.livroCaixaRepository = livroCaixaRepository;
    }


    public LivroCaixa comprar(InvestimentoRequestDTO requestDTO, String idInvestidor) {

        return livroCaixaRepository.save(LivroCaixa.builder()
                .idInvestidor(idInvestidor)
                .titulo(requestDTO.getTitulo())
                .quantidade(requestDTO.getQuantidade())
                .valor(requestDTO.getValor())
                .tipoDeAcao(TipoDeAcao.COMPRA)
                .totalTransacao(getTotalTransacao(requestDTO))
                .build());
    }

    public LivroCaixa vender(InvestimentoRequestDTO requestDTO, String idInvestidor) {
        return  livroCaixaRepository.save(LivroCaixa.builder()
                .idInvestidor(idInvestidor)
                .valor(requestDTO.getValor())
                .quantidade(requestDTO.getQuantidade())
                .tipoDeAcao(TipoDeAcao.VENDA)
                .titulo(requestDTO.getTitulo())
                .totalTransacao(getTotalTransacao(requestDTO))
                .lucro(calcularLucro(requestDTO,idInvestidor.toString()))
                .build());
    }

    private Double calcularLucro(InvestimentoRequestDTO requestDTO, String idInvestidor) {
        var buscaRegistros = livroCaixaRepository.findByIdInvestidor(idInvestidor);
        var media = buscaRegistros.stream()
                .filter(f -> f.getTitulo().equals(requestDTO.getTitulo()))
                .filter(s -> s.getTipoDeAcao().equals(TipoDeAcao.COMPRA))
                .mapToDouble(LivroCaixa::getValor)
                .average();
        return media.orElseGet(() -> 0.0);
    }


    private Double getTotalTransacao(InvestimentoRequestDTO requestDTO) {
        return requestDTO.getQuantidade() * requestDTO.getValor();
    }


    public Stream<LivroCaixa> findAll(String idInvestidor) {
       return livroCaixaRepository.findAll().stream().filter(f -> f.getIdInvestidor().equals(idInvestidor));
    }
}

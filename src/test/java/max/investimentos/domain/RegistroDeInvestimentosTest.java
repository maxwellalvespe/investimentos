package max.investimentos.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegistroDeInvestimentosTest {

    RegistroDeInvestimentos registroDeInvestimentos;
    Investimento investimento;

    @BeforeEach
    void setup() {

        investimento = Investimento.builder()
                .quantidadeAdiquirida(100)
                .acao("ACAO")
                .precoDeCompra(9.5)
                .precoDeVenda(0.0)
                .quantidadeVendida(0)
                .build();

        var vendaInvestimento = new Investimento();
        vendaInvestimento.setQuantidadeVendida(50);
        vendaInvestimento.setPrecoDeVenda(10.0);
        vendaInvestimento.setAcao("ACAO");

        registroDeInvestimentos = new RegistroDeInvestimentos();
        registroDeInvestimentos.setIdInvestidor("MAX1020");
        registroDeInvestimentos.setInvestimentos(List.of(investimento, vendaInvestimento));


    }

    @Test
    void registrando_compra_de_uma_acao() {
        investimento.setQuantidadeVendida(10);
        var acao = registroDeInvestimentos.getInvestimentos().stream()
                .filter(reg -> reg.getAcao().equals("ACAO"))
                .map(item -> item.obterQuantidadeDeAcoes())
                .findFirst().get();
        assertEquals(90, acao);
        assertEquals(2,        registroDeInvestimentos.getInvestimentos().size());
    }
}

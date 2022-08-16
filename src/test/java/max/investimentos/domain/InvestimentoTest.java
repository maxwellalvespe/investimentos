package max.investimentos.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvestimentoTest {

    private final String ACAO = "DEVC4";
    private final Double VALOR_COMPRA = 7.2;
    private final Double VALOR_VENDA = 0.0;
    private final int QUANTIDADE_ADIQUIRIDA = 100;
    public Investimento investimento;

    @BeforeEach
    void setup(){
        this.investimento = Investimento.builder()
                .quantidadeAdiquirida(QUANTIDADE_ADIQUIRIDA)
                .acao(ACAO)
                .precoDeCompra(VALOR_COMPRA)
                .precoDeVenda(VALOR_VENDA)
                .quantidadeVendida(0)
                .build();
    }

    @Test
    void deve_criar_um_investimento_e_devolver_a_quantidade_de_acoes_correta(){
        assertEquals(QUANTIDADE_ADIQUIRIDA,investimento.getQuantidadeAdiquirida());
        assertEquals(QUANTIDADE_ADIQUIRIDA,investimento.obterQuantidadeDeAcoes());
    }

    @Test
    void realizando_validacao_dos_valores_obtidos(){
        assertEquals(VALOR_COMPRA,investimento.getPrecoDeCompra());
        assertEquals(VALOR_VENDA,investimento.getPrecoDeVenda());
        assertEquals(ACAO,investimento.getAcao());
    }

    @Test
    void realizando_venda_de_acoes(){
        var valorDeVendaDaAcao = .25;

        investimento.setQuantidadeVendida(10);
        investimento.setPrecoDeVenda(VALOR_COMPRA+valorDeVendaDaAcao);

        assertEquals(90,investimento.obterQuantidadeDeAcoes());
        assertEquals(VALOR_COMPRA+valorDeVendaDaAcao, investimento.getPrecoDeVenda());

    }
}

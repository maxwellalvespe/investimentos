package max.investimentos.enums;

import lombok.Getter;

@Getter
public enum TipoDeAcao {

    COMPRA("C"),
    VENDA("V");
    private String acao;

    TipoDeAcao(String acao) {
        this.acao = acao;
    }
}

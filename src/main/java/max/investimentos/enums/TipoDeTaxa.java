package max.investimentos.enums;

import lombok.Getter;

@Getter
public enum TipoDeTaxa {
    SWING_TRADE(.15),
    DAY_TRADE(.20);
    private double aliquota;

     TipoDeTaxa(Double aliquota){
        this.aliquota = aliquota;
    }

}

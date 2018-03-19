package fr.kata;

import java.math.BigDecimal;

public class Montant {

    private final BigDecimal montantBrut;
    private final String devise;

    public Montant(BigDecimal montantBrut) {
        this.montantBrut = montantBrut;
        this.devise = "EURO";
    }

    static Montant ZERO() {
        return new Montant(BigDecimal.ZERO);
    }

    public BigDecimal getMontantBrut() {
        return montantBrut;
    }

    public String getDevise() {
        return devise;
    }

    public Montant appliquerTaux(BigDecimal taux) {
        BigDecimal tauxApplique = this.montantBrut.multiply(taux);
        return new Montant(tauxApplique);
    }
}

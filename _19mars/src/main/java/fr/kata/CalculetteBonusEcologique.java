package fr.kata;

import java.math.BigDecimal;

public class CalculetteBonusEcologique {

    public static final BigDecimal LIMITE_PRIME_EN_FONCTION_PRIX_ACQUISITION = new BigDecimal("0.27");

    public Montant calculePrime(Vehicule vehicule) {
        if (!vehicule.isVehiculePropre()) {
            return Montant.ZERO();
        }
        return calculePrimeVehiculePropre(vehicule);
    }

    private Montant calculePrimeVehiculePropre(Vehicule vehicule) {
        Montant montant = new Montant(vehicule.calculerPrimeBrute());
        if (!vehicule.primeLimitéeParPrixAchat()) {
            return montant;
        }
        Montant primeMaximaleSelonPrix = getPrimeMaximaleSelonPrix(vehicule);
        return montant.min(primeMaximaleSelonPrix);
    }



    private Montant getPrimeMaximaleSelonPrix(Vehicule vehicule) {
        return vehicule.getPrixAchat().appliquerTaux(LIMITE_PRIME_EN_FONCTION_PRIX_ACQUISITION);
    }
}

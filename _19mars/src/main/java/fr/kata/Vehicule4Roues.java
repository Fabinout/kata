package fr.kata;

import java.math.BigDecimal;

public abstract class Vehicule4Roues implements Vehicule {

    private static final BigDecimal PRIME_MAXIMALE = new BigDecimal("6000");
    protected final int tauxEmission;
    protected final Montant prixAchat;

    public Vehicule4Roues(Montant prixAchat,
        int tauxEmission) {
        this.prixAchat = prixAchat;
        this.tauxEmission = tauxEmission;
    }

    public Montant getPrixAchat() {
        return prixAchat;
    }

    public int getTauxEmission() {
        return tauxEmission;
    }

    @Override
    public BigDecimal calculerPrimeBrute() {
        return Vehicule4Roues.PRIME_MAXIMALE;
    }
}

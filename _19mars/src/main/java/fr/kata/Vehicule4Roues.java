package fr.kata;

import java.math.BigDecimal;

public abstract class Vehicule4Roues implements Vehicule {

    public static final int SEUIL_TAUX_EMISSION_CO2 = 20;
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

    @Override
    public BigDecimal calculerPrimeBrute() {
        return Vehicule4Roues.PRIME_MAXIMALE;
    }

    @Override
    public boolean isVehiculePropre() {
        return tauxEmission <= SEUIL_TAUX_EMISSION_CO2;
    }

    @Override
    public boolean primeLimitéeParPrixAchat() {
        return true;
    }
}

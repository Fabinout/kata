package fr.kata;

import java.math.BigDecimal;

public class Scooter implements Vehicule {

    public static final BigDecimal PRIME_MAXIMALE = new BigDecimal("1000");
    private final Moteur moteur;
    private final Montant prixAchat;

    public Scooter(Moteur moteur, Montant prixAchat) {
        this.moteur = moteur;
        this.prixAchat = prixAchat;
    }

    @Override
    public BigDecimal calculerPrimeBrute() {
        return PRIME_MAXIMALE;
    }

    @Override
    public Montant getPrixAchat() {
        return prixAchat;
    }

    @Override
    public boolean isVehiculePropre() {
        return !moteur.hasPlomb();
    }
}

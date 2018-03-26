package fr.kata;

import java.math.BigDecimal;

public class Scooter implements Vehicule {

    public static final BigDecimal PRIME_MAXIMALE = new BigDecimal("1000");
    public static final BigDecimal PRIME_PAR_KWH = new BigDecimal("250");
    public static final BigDecimal PRIME_PETIT_MOTEUR = new BigDecimal("100");

    private final Moteur moteur;
    private final Montant prixAchat;

    public Scooter(Moteur moteur, Montant prixAchat) {
        this.moteur = moteur;
        this.prixAchat = prixAchat;
    }

    @Override
    public BigDecimal calculerPrimeBrute() {
        if (moteur.isPetit()) {
            return PRIME_PETIT_MOTEUR;
        }
        return PRIME_PAR_KWH.multiply(new BigDecimal(moteur.getPuissanceMaximaleNette())).min(PRIME_MAXIMALE);
    }

    @Override
    public Montant getPrixAchat() {
        return prixAchat;
    }

    @Override
    public boolean isVehiculePropre() {
        return !moteur.hasPlomb();
    }

    @Override
    public boolean primeLimitéeParPrixAchat() {
        return !moteur.isPetit();
    }
}

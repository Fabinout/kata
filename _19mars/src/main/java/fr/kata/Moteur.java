package fr.kata;

public class Moteur {

    public static final int SEUIL_GROS_MOTEUR = 3;
    private final int puissanceMaximaleNette;

    public Moteur(int puissanceMaximaleNette) {
        this.puissanceMaximaleNette = puissanceMaximaleNette;
    }

    public int getPuissanceMaximaleNette() {
        return puissanceMaximaleNette;
    }

    public boolean hasPlomb() {
        return false;
    }

    boolean isPetit() {
        return getPuissanceMaximaleNette() < SEUIL_GROS_MOTEUR;
    }
}

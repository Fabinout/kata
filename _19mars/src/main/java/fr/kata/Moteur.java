package fr.kata;

public class Moteur {


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
}

package fr.kata;

public class MoteurAuPlomb extends Moteur {

    public MoteurAuPlomb(int puissanceMaximaleNette) {
        super(puissanceMaximaleNette);
    }

    @Override
    public boolean hasPlomb() {
        return true;
    }
}

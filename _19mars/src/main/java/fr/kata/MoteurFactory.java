package fr.kata;

public class MoteurFactory {

    public static Moteur of(int puissanceMaximaleNette){
        return new Moteur(puissanceMaximaleNette);
    }

    public static Moteur ofPlomb(int puissanceMaximaleNette){
        return new MoteurAuPlomb(puissanceMaximaleNette);
    }
}

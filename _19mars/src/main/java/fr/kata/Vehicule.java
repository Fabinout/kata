package fr.kata;

import java.math.BigDecimal;

public interface Vehicule {

    BigDecimal calculerPrimeBrute();

    Montant getPrixAchat();

    boolean isVehiculePropre();
}

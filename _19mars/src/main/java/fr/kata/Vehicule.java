package fr.kata;

import java.math.BigDecimal;

public interface Vehicule {

    int SEUIL_TAUX_EMISSION_CO2 = 20;

    BigDecimal calculerPrimeBrute();

    Montant getPrixAchat();

    int getTauxEmission();

    default boolean isVehiculePropre(){
        return getTauxEmission() <= SEUIL_TAUX_EMISSION_CO2;
    }
}

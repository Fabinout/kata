package fr.kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class CalculetteBonusEcologiqueShould {

    private CalculetteBonusEcologique calculette;

    @Before
    public void setUp() {
        calculette = new CalculetteBonusEcologique();

    }

    @Test
    public void prime_maximum_pour_VP_avec_taux_faible() {
        Montant prixAchat = new Montant(new BigDecimal("100000"));
        VoitureParticuliere vehicule = new VoitureParticuliere(20, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "6000");
    }

    @Test
    public void prime_proportionnelle_pour_VP_pas_cher__avec_taux_faible() {
        Montant prixAchat = new Montant(new BigDecimal("5000"));
        VoitureParticuliere vehicule = new VoitureParticuliere(20, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "1350");
    }

    @Test
    public void prime_proportionnelle_pour_VP_un_peu_cher_avec_taux_faible() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        VoitureParticuliere vehicule = new VoitureParticuliere(20, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "2700");

    }

    @Test
    public void aucune_prime_pour_VP_polluant() {
        Montant prixAchat = new Montant(new BigDecimal("100000"));
        VoitureParticuliere porscheCayenne = new VoitureParticuliere(100, prixAchat);

        Montant prime = calculette.calculePrime(porscheCayenne);

        verifierMontant(prime, "0");
    }

    @Test
    public void prime_proportionnelle_pour_camionnette_a_taux_faible() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        Vehicule vehicule = new Camionnette(20, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "2700");

    }

    @Test
    public void prime_selon_batterie_pour_scooter_electrique() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        Moteur moteur = MoteurFactory.of(4);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "1000");
    }

    @Test
    public void prime_selon_batterie_et_prix_max_pour_scooter_electrique() {
        Montant prixAchat = new Montant(new BigDecimal("1000"));
        Moteur moteur = MoteurFactory.of(4);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "270");
    }

    @Test
    public void sans_prime_pour_scooter_electrique_avec_batterie_au_plomb() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        Moteur moteur = MoteurFactory.ofPlomb(4);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "0");
    }

    @Test
    public void prime_selon_batterie_en_deça_de_la_prime_maximale() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        Moteur moteur = MoteurFactory.of(3);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "750");
    }

    @Test
    public void prime_selon_batterie_avec_faible_puissance() {
        Montant prixAchat = new Montant(new BigDecimal("10000"));
        Moteur moteur = MoteurFactory.of(2);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "100");
    }

    @Test
    public void prime_selon_batterie_avec_faible_puissance_et_petit_prix() {
        Montant prixAchat = new Montant(new BigDecimal("100"));
        Moteur moteur = MoteurFactory.of(2);
        Vehicule vehicule = new Scooter(moteur, prixAchat);

        Montant prime = calculette.calculePrime(vehicule);

        verifierMontant(prime, "100");
    }

    private void verifierMontant(Montant prime, String montantAttendu) {
        assertThat(prime.getMontantBrut()).isEqualByComparingTo(montantAttendu);
        assertThat(prime.getDevise()).isEqualTo("EURO");
    }
}

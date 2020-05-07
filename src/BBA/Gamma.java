package BBA;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Klasse für den Sicherheitsbeiwert Gamma nach Tabelle 2 DIN 18230-1
 */
public class Gamma {

    //TODO: Interpolationsfunktionen für jede Brandsicherheitsklasse, ein- und mehrgeschossig schreiben
    // Klaerung: Was ist bei Werten die nicht mehr in der Tabelle sind anzusetzen?

    // Flaeche und ein- oder mehrgeschossig werden in der BBA-Klasse anhand der festgelegten Werte gesetzt
    public double flaeche;

    public double getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
        this.flaeche = flaeche;
    }

    public boolean isEingeschossig() {
        return eingeschossig;
    }

    public void setEingeschossig(boolean eingeschossig) {
        this.eingeschossig = eingeschossig;
    }

    boolean eingeschossig;

    //Konstruktor
    public Gamma(Double newFlaeche, boolean newEingeschossig) {
        flaeche = newFlaeche;
        eingeschossig = newEingeschossig;
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    //eingeschossig, SKb3, Spalte 0 in Tabelle
    public double gammaEingeschossigSkb3() throws IOException {
        if (flaeche <= 2500) {
            return tabelleGammaEingeschossig[0][0];

        } else if (flaeche > 2500 && flaeche < 5000){
            double gamma = tabelleGammaEingeschossig[0][0] + ((tabelleGammaEingeschossig[1][0] - tabelleGammaEingeschossig[0][0])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaEingeschossig[1][0];

        } else if (flaeche > 5000 && flaeche < 10000) {
            double gamma = tabelleGammaEingeschossig[1][0] + ((tabelleGammaEingeschossig[2][0] - tabelleGammaEingeschossig[1][0]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaEingeschossig[2][0];

        } else if (flaeche > 10000 && flaeche < 20000) {
            double gamma = tabelleGammaEingeschossig[2][0] + ((tabelleGammaEingeschossig[3][0] - tabelleGammaEingeschossig[2][0]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaEingeschossig[3][0];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaEingeschossig[3][0] + ((tabelleGammaEingeschossig[4][0] - tabelleGammaEingeschossig[3][0]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaEingeschossig[4][0];

        } else if (flaeche > 30000 && flaeche < 60000) {
            double gamma = tabelleGammaEingeschossig[4][0] + ((tabelleGammaEingeschossig[5][0] - tabelleGammaEingeschossig[4][0]) / (60000 - 30000)) * (flaeche - 30000);
            return gamma;

        } else if (flaeche == 60000) {
            return tabelleGammaEingeschossig[5][0];

        } else if (flaeche > 60000 && flaeche < 120000) {
            double gamma = tabelleGammaEingeschossig[5][0] + ((tabelleGammaEingeschossig[6][0] - tabelleGammaEingeschossig[5][0]) / (120000 - 60000)) * (flaeche - 60000);
            return gamma;

        } else if (flaeche == 120000) {
            return tabelleGammaEingeschossig[6][0];

        }   else if (flaeche > 120000){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fehlermeldungen/FehlerGrundflaecheEingeschossig.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Achtung");
            stage.setScene(new Scene(root1));
            stage.show();

            return 0;

        } else {

            return 0;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    //eingeschossig, SKb2

    public double gammaEingeschossigSkb2() throws IOException {
        if (flaeche <= 2500) {
            return tabelleGammaEingeschossig[0][1];

        } else if (flaeche > 2500 && flaeche <5000){
            double gamma = tabelleGammaEingeschossig[0][1]+ ((tabelleGammaEingeschossig[1][1] - tabelleGammaEingeschossig[0][1])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaEingeschossig[1][1];

        } else if (flaeche > 5000 && flaeche <10000) {
            double gamma = tabelleGammaEingeschossig[1][1] + ((tabelleGammaEingeschossig[2][1] - tabelleGammaEingeschossig[1][1]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaEingeschossig[2][1];

        } else if (flaeche > 10000 && flaeche <20000) {
            double gamma = tabelleGammaEingeschossig[2][1] + ((tabelleGammaEingeschossig[3][1] - tabelleGammaEingeschossig[2][1]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaEingeschossig[3][1];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaEingeschossig[3][1] + ((tabelleGammaEingeschossig[4][1] - tabelleGammaEingeschossig[3][1]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaEingeschossig[4][1];

        } else if (flaeche > 30000 && flaeche < 60000) {
            double gamma = tabelleGammaEingeschossig[4][1] + ((tabelleGammaEingeschossig[5][1] - tabelleGammaEingeschossig[4][1]) / (60000 - 30000)) * (flaeche - 30000);
            return gamma;

        } else if (flaeche == 60000) {
            return tabelleGammaEingeschossig[5][1];

        } else if (flaeche > 60000 && flaeche < 120000) {
            double gamma = tabelleGammaEingeschossig[5][1] + ((tabelleGammaEingeschossig[6][1] - tabelleGammaEingeschossig[5][1]) / (120000 - 60000)) * (flaeche - 60000);
            return gamma;

        } else if (flaeche == 120000) {
            return tabelleGammaEingeschossig[6][1];

        } else if (flaeche > 120000){

            return 0;

        } else {

            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //eingeschossig, SKb1

    public double gammaEingeschossigSkb1() throws IOException {
        if (flaeche <= 2500) {
            return tabelleGammaEingeschossig[0][2];

        } else if (flaeche > 2500 && flaeche <5000){
            double gamma = tabelleGammaEingeschossig[0][2]+ ((tabelleGammaEingeschossig[1][2] - tabelleGammaEingeschossig[0][1])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaEingeschossig[1][2];

        } else if (flaeche > 5000 && flaeche <10000) {
            double gamma = tabelleGammaEingeschossig[1][2] + ((tabelleGammaEingeschossig[2][2] - tabelleGammaEingeschossig[1][2]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaEingeschossig[2][2];

        } else if (flaeche > 10000 && flaeche <20000) {
            double gamma = tabelleGammaEingeschossig[2][2] + ((tabelleGammaEingeschossig[3][2] - tabelleGammaEingeschossig[2][2]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaEingeschossig[3][2];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaEingeschossig[3][2] + ((tabelleGammaEingeschossig[4][2] - tabelleGammaEingeschossig[3][2]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaEingeschossig[4][2];

        } else if (flaeche > 30000 && flaeche < 60000) {
            double gamma = tabelleGammaEingeschossig[4][2] + ((tabelleGammaEingeschossig[5][2] - tabelleGammaEingeschossig[4][2]) / (60000 - 30000)) * (flaeche - 30000);
            return gamma;

        } else if (flaeche == 60000) {
            return tabelleGammaEingeschossig[5][2];

        } else if (flaeche > 60000 && flaeche < 120000) {
            double gamma = tabelleGammaEingeschossig[5][2] + ((tabelleGammaEingeschossig[6][2] - tabelleGammaEingeschossig[5][2]) / (120000 - 60000)) * (flaeche - 60000);
            return gamma;

        } else if (flaeche == 120000) {
            return tabelleGammaEingeschossig[6][2];

        } else if (flaeche > 120000){

            return 0;

        } else {

            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    //mehrgeschossig, SKb3
    public double gammaMehrgeschossigSkb3() throws IOException {
        if (flaeche <= 2500) {
            return tabelleGammaMehrgeschossig[0][0];

        } else if (flaeche > 2500 && flaeche <5000){
            double gamma = tabelleGammaMehrgeschossig[0][0] + ((tabelleGammaMehrgeschossig[1][0] - tabelleGammaMehrgeschossig[0][0])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaMehrgeschossig[1][0];

        } else if (flaeche > 5000 && flaeche <10000) {
            double gamma = tabelleGammaMehrgeschossig[1][0] + ((tabelleGammaMehrgeschossig[2][0] - tabelleGammaMehrgeschossig[1][0]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaMehrgeschossig[2][0];

        } else if (flaeche > 10000 && flaeche <20000) {
            double gamma = tabelleGammaMehrgeschossig[2][0] + ((tabelleGammaMehrgeschossig[3][0] - tabelleGammaMehrgeschossig[2][0]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaMehrgeschossig[3][0];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaMehrgeschossig[3][0] + ((tabelleGammaMehrgeschossig[4][0] - tabelleGammaMehrgeschossig[3][0]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaMehrgeschossig[4][0];

        } else if (flaeche > 30000) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fehlermeldungen/FehlerGrundflaecheMehrgeschossig.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Achtung");
            stage.setScene(new Scene(root1));
            stage.show();

            return 0;

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    //mehrgeschossig, SKb2
    public double gammaMehrgeschossigSkb2(){
        if (flaeche <= 2500) {
            return tabelleGammaMehrgeschossig[0][1];

        } else if (flaeche > 2500 && flaeche <5000){
            double gamma = tabelleGammaMehrgeschossig[0][1] + ((tabelleGammaMehrgeschossig[1][1] - tabelleGammaMehrgeschossig[0][1])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaMehrgeschossig[1][1];

        } else if (flaeche > 5000 && flaeche <10000) {
            double gamma = tabelleGammaMehrgeschossig[1][1] + ((tabelleGammaMehrgeschossig[2][1] - tabelleGammaMehrgeschossig[1][1]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaMehrgeschossig[2][1];

        } else if (flaeche > 10000 && flaeche <20000) {
            double gamma = tabelleGammaMehrgeschossig[2][1] + ((tabelleGammaMehrgeschossig[3][1] - tabelleGammaMehrgeschossig[2][1]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaMehrgeschossig[3][1];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaMehrgeschossig[3][1] + ((tabelleGammaMehrgeschossig[4][1] - tabelleGammaMehrgeschossig[3][1]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaMehrgeschossig[4][1];

        } else if (flaeche > 30000) {

            return 0;

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    //mehrgeschossig, SKb1
    public double gammaMehrgeschossigSkb1(){
        if (flaeche <= 2500) {
            return tabelleGammaMehrgeschossig[0][2];

        } else if (flaeche > 2500 && flaeche <5000){
            double gamma = tabelleGammaMehrgeschossig[0][2] + ((tabelleGammaMehrgeschossig[1][2] - tabelleGammaMehrgeschossig[0][2])/(5000-2500)) * (flaeche-2500);
            return gamma;

        } else if (flaeche == 5000) {
            return tabelleGammaMehrgeschossig[1][2];

        } else if (flaeche > 5000 && flaeche <10000) {
            double gamma = tabelleGammaMehrgeschossig[1][2] + ((tabelleGammaMehrgeschossig[2][2] - tabelleGammaMehrgeschossig[1][2]) / (10000 - 5000)) * (flaeche - 5000);
            return gamma;

        } else if (flaeche == 10000) {
            return tabelleGammaMehrgeschossig[2][2];

        } else if (flaeche > 10000 && flaeche <20000) {
            double gamma = tabelleGammaMehrgeschossig[2][2] + ((tabelleGammaMehrgeschossig[3][2] - tabelleGammaMehrgeschossig[2][2]) / (20000 - 10000)) * (flaeche - 10000);
            return gamma;

        } else if (flaeche == 20000) {
            return tabelleGammaMehrgeschossig[3][2];

        } else if (flaeche > 20000 && flaeche < 30000) {
            double gamma = tabelleGammaMehrgeschossig[3][2] + ((tabelleGammaMehrgeschossig[4][2] - tabelleGammaMehrgeschossig[3][2]) / (30000 - 20000)) * (flaeche - 20000);
            return gamma;

        } else if (flaeche == 30000) {
            return tabelleGammaMehrgeschossig[4][2];

        } else if (flaeche > 30000) {

            return 0;

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------


    double [] [] tabelleGammaEingeschossig = {
            {1.0, 0.6, 0.5},
            {1.05, 0.6, 0.5},
            {1.1, 0.7, 0.5},
            {1.2, 0.8, 0.5},
            {1.25, 0.9, 0.5},
            {1.35, 1.0, 0.55},
            {1.5, 1.1, 0.6}
    };

//----------------------------------------------------------------------------------------------------------------------
    double [][] tabelleGammaMehrgeschossig = {
        {1.25, 0.9, 0.5},
        {1.35, 1.0, 0.6},
        {1.45, 1.1, 0.7},
        {1.55, 1.20, 0.80},
        {1.60, 1.25, 0.90}
    };
}

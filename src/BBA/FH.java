package BBA;

/**
 * Berechnung des Faktors F_H zur Berücksichtigung des Bezugsniveaus
 */

public class FH {

    double hoeheFussboden;

    //Konstruktor
    public FH(Double newHoeheFussboden) {
        hoeheFussboden = newHoeheFussboden;
    }

    // Wenn der Fussboden unterhalb des Bezugniveaus liegt, ist der doppelte Wert nach Tabelle 3 MIndBauRL anzusetzen
    public double berechneFH() {
        if (hoeheFussboden < 0) {
            double fh = berechneFHErsterSchritt() * 2;
            return fh;
        } else {
            return berechneFHErsterSchritt();
        }
    }

    public double berechneFHErsterSchritt() {
        if (hoeheFussboden == 0) {
            return 1.0;
        } else if (hoeheFussboden > 0 && hoeheFussboden < 5){
            double fh = 1.0 + ((1.1-1.0)/(5-0)) * (hoeheFussboden-0);
            return fh;

        } else if (hoeheFussboden == 5) {
            return 1.1;

        } else if (hoeheFussboden > 5 && hoeheFussboden < 10) {
            double fh = 1.1 + ((1.2 - 1.1) / (10 - 5)) * (hoeheFussboden - 5);
            return fh;

        } else if (hoeheFussboden == 10) {
            return 1.2;

        } else if (hoeheFussboden > 10 && hoeheFussboden < 15) {
            double fh = 1.2 + ((1.3 - 1.2) / (15 - 10)) * (hoeheFussboden - 10);
            return fh;

        } else if (hoeheFussboden == 15) {
            return 1.3;

        } else if (hoeheFussboden > 15 && hoeheFussboden < 20) {
            double fh = 1.3 + ((1.4 - 1.3) / (20 - 15)) * (hoeheFussboden - 15);
            return fh;

        } else if (hoeheFussboden == 20) {
            return 1.4;

        } else {
            return 0;
        }
    }
}

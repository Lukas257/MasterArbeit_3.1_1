package BBA;

/**
 * Tabelle 6 der MIndBauRL, nur Spalte 2, "zu 1." eingearbeitet
 *
 */
public class AnforderungenAnBaustoffeUndBauteile {

    // t_F aus Klasse BBA wird im Konstruktor uebergeben
    // muss für SKb3- Skb1 geschehen!
    Double t_F;

    //Konstruktor
    public AnforderungenAnBaustoffeUndBauteile(Double newTf) {
        t_F = newTf;
    }

    public String anforderungen() {

        if (t_F <= 15.0) {
            return tabelleAnforderungen[0][0];

        } else if (t_F > 15 && t_F <= 30) {
            return tabelleAnforderungen[1][0];

        } else if (t_F > 30 && t_F <= 60) {
            return tabelleAnforderungen [2][0];

            //t_F ist größer als 60min
        } else {
            return tabelleAnforderungen[3][0];
        }

    };

    //TODO: Prüfen ob auch einfach F90 - AB etc. geschrieben werden kann

    String a0_0 = "feuerhemmend und aus nichtbrennbaren Bausstofen"; //+
//                    "zu 2. feuerhemmend, dicht- und selbstschließend" +
//                        "zu 3. feuerhemmend";

    String a1_0 = "feuerhemmend und aus nichtbrennbaren Baustoffen"; // +
//                    "zu 2. feuerhemmend, dicht- und selbstschließend" +
//                        "zu 3. feuerhemmend";

    String a2_0 = "hochfeuerhemmend und aus nichtbrennbaren Baustoffen"; //+
//                    "zu 2. hochfeuerhemmend, dicht- und selbstschließend" +
//                        "zu 3. hochfeuerhemmend";

    String a3_0 = "feuerbeständig und aus nichtbrennbaren Baustoffen"; //+
//                    "zu 2. feuerbeständig, dicht- und selbstschließend" +
//                        "zu 3. feuerbeständig";


    String[][] tabelleAnforderungen = {
            {a0_0},
            {a1_0},
            {a2_0},
            {a3_0}
    };
}

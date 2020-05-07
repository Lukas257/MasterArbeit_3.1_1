package BBA;

import org.bouncycastle.tsp.TSPUtil;

/**
 * Klasse zur Bestimmung von alpha_L nach Tabelle 3, DIN 18230-1
 */

public class AlphaL {

    boolean automatischeBrandmeldeanlagen;

    boolean werkfeuerwehrHauptberuflich;

    String werkfeuerwehrSchichtstaerke;

    boolean loeschanlagenVorhanden;

    boolean selbsttaetigeLoeschanlagenVorhanden;

    double q_R;


    //Konstruktor
    public AlphaL(Boolean newAutomatischeBrandmeldeanlagen, Boolean newWerkfeuerwehrHauptberuflich, String newWerkfeuerSchichtstaerke, Boolean newLoeschanlagenVorhanden,
                   Boolean newSelbstaetigeLoeschanlagenVorhanden, Double newQ_R) {
        automatischeBrandmeldeanlagen = newAutomatischeBrandmeldeanlagen;
        werkfeuerwehrHauptberuflich = newWerkfeuerwehrHauptberuflich;
        werkfeuerwehrSchichtstaerke = newWerkfeuerSchichtstaerke;
        loeschanlagenVorhanden = newLoeschanlagenVorhanden;
        selbsttaetigeLoeschanlagenVorhanden = newSelbstaetigeLoeschanlagenVorhanden;
        q_R = newQ_R;
    }

//----------------------------------------------------------------------------------------------------------------------
    //Bestimmung des Wertes aus Spalte 1
    public double spalte1() {

        //Werkfeuerwehr hauptberuflich
        if(werkfeuerwehrHauptberuflich) {
            if(werkfeuerwehrSchichtstaerke.equals("keine")) {
                return 1.0;
            } else if (werkfeuerwehrSchichtstaerke.equals("1 Staffel (6)")) {
                return 0.90;
            } else if (werkfeuerwehrSchichtstaerke.equals("1 Gruppe (9)")) {
                return 0.85;
            } else if (werkfeuerwehrSchichtstaerke.equals("2 Staffeln (12)")) {
                return 0.80;
            }  else if (werkfeuerwehrSchichtstaerke.equals("3 Staffeln (18)")) {
                return 0.70;
            }   else if (werkfeuerwehrSchichtstaerke.equals("4 Staffeln (24)")) {
                return 0.60;
            } else {
                return 1.0;
            }

            //Werkfeuerwehr ist NEBENberuflich
        } else {
            if(werkfeuerwehrSchichtstaerke.equals("keine")) {
                return 1.0;
            } else if (werkfeuerwehrSchichtstaerke.equals("1 Staffel (6)")) {
                return 0.95;
            } else if (werkfeuerwehrSchichtstaerke.equals("1 Gruppe (9)")) {
                return 0.90;
            } else if (werkfeuerwehrSchichtstaerke.equals("2 Staffeln (12)")) {
                return 0.85;
            }  else if (werkfeuerwehrSchichtstaerke.equals("3 Staffeln (18)")) {
                return 0.80;
            }   else if (werkfeuerwehrSchichtstaerke.equals("4 Staffeln (24)")) {
                return 0.75;
            } else {
                return 1.0;
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    public double spalte2() {
        //wenn automatische BMA vorhanden sind
        if (automatischeBrandmeldeanlagen) {
            return 0.95;
        } else {
            return 0.90;
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    //TODO:  Wird nicht richtig erkannt! liefert anstatt 0.6 <-> 1.0
    public double spalte3(){

        //Loeschanlagen sind vorhanden
        if(loeschanlagenVorhanden) {

            //selbsttaetige Loeschanlage vorhanden
            if (selbsttaetigeLoeschanlagenVorhanden) {
                return 0.60;

            // halbstationaere Loeschanlage vorhanden
            } else {
                return 0.85;
            }

        // keine Loeschanlagen vorhanden
        } else {
            return 1.0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    // Alpha_L wird berechnet, inklusive der ABminderungen nach DIN 18230-1 10.1

    public double berechneAlphaL() {

        double alpha = spalte1() * spalte2() * spalte3();

        //Zum Testen
        System.out.println("alpha Spalte 1 = " + spalte1());
        System.out.println("alpha Spalte 2 = " + spalte2());
        System.out.println("alpha Spalte 3 = " + spalte3());
        System.out.println("");
        System.out.println("");


        if(alpha <= 0.85 && q_R <= 45) {
            return alpha * 0.80;

        } else if (alpha <= 0.85 && q_R <= 100) {
            return alpha * 0.90;

        } else {
            return alpha;
        }

    }

//----------------------------------------------------------------------------------------------------------------------

    public boolean isAutomatischeBrandmeldeanlagen() {
        return automatischeBrandmeldeanlagen;
    }

    public void setAutomatischeBrandmeldeanlagen(boolean automatischeBrandmeldeanlagen) {
        this.automatischeBrandmeldeanlagen = automatischeBrandmeldeanlagen;
    }

    public boolean isWerkfeuerwehrHauptberuflich() {
        return werkfeuerwehrHauptberuflich;
    }

    public void setWerkfeuerwehrHauptberuflich(boolean werkfeuerwehrHauptberuflich) {
        this.werkfeuerwehrHauptberuflich = werkfeuerwehrHauptberuflich;
    }

    public String getWerkfeuerwehrSchichtstaerke() {
        return werkfeuerwehrSchichtstaerke;
    }

    public void setWerkfeuerwehrSchichtstaerke(String werkfeuerwehrSchichtstaerke) {
        this.werkfeuerwehrSchichtstaerke = werkfeuerwehrSchichtstaerke;
    }

    public boolean isLoeschanlagenVorhanden() {
        return loeschanlagenVorhanden;
    }

    public void setLoeschanlagenVorhanden(boolean loeschanlagenVorhanden) {
        this.loeschanlagenVorhanden = loeschanlagenVorhanden;
    }

    public boolean isSelbsttaetigeLoeschanlagenVorhanden() {
        return selbsttaetigeLoeschanlagenVorhanden;
    }

    public void setSelbsttaetigeLoeschanlagenVorhanden(boolean selbsttaetigeLoeschanlagenVorhanden) {
        this.selbsttaetigeLoeschanlagenVorhanden = selbsttaetigeLoeschanlagenVorhanden;
    }



}

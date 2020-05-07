package BBA;

public class VWAF {

    String nameVWAF;

    String anrechenbarkeit;

    //Wert der Anrechenbarkeit der Flaeche nach Tabelle E.3
    Double anrechenbarkeitWert;

    double anrechenbarkeitWertOben;

    String lageInDerWand;


    Integer anzahl;

    Double flaecheRohbauEinzeln;

    //85 % der Rohnbauflaeche des einzelnen Bauteils
    Double flaecheEinzeln;

    //Anzahl * flaecheEinzeln
    Double flaecheGesamt;

    // die anrechenbare Flaeche unter Beruecksichtigung von Tabelle E.3
    Double anrechenBareFlaeche;

    Double anrechenBareFlaecheOben;

    //in Abhängigkeit von t_ae wird die Anrechenbarkeit neu bestimmt
    double anrechenBareFlaecheZweiterDurchgang;

    double anrechenBareFlaecheZweiterDurchgangOben;

    //zur Einarbeitung der Fussnoten der Tabelle
    Boolean werkfeuerwehrVorhanden;

    //t_ae aus erster Berechnung um Werte der Tabelle evtl anzupassen
    Double t_ae;

    //Konstruktor
//    public VWAF(Double newT_ae, Boolean newWerkfeuerwehrVorhanden) {
//        t_ae = newT_ae;
//        werkfeuerwehrVorhanden = newWerkfeuerwehrVorhanden;
//    }

    //----------------------------------------------------------------------------------------------------------------------
    public void berechneFlaecheEinzeln() {
        double f;
        f = getFlaecheRohbauEinzeln() * 0.85;
        setFlaecheEinzeln(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void berechneFlaecheGesamt() {
        double f;
        f = getFlaecheEinzeln() * getAnzahl();
        setFlaecheGesamt(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void bestimmeWertDerAnrechenbarkeitZweiterDurchgang() {

        //TODO Zeile 4,6 tä>30 einarbeiten      Zeile 6,7 Thomas fragen welchen Wert man ansetzen darf
        //TODO FUssnoten der Tabelle einarbeiten! -> Abfrage ob Werkfeuerwehr in den Konstruktor!

        if (anrechenbarkeit.equals("Tabelle E.3 Zeile 1")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 2")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 3")) {
            setAnrechenbarkeitWert(1.0);


        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 4") && getLageInDerWand().equals("obere Hälfte")) {

            System.out.println("");
            System.out.println("Zeile 4, Liegt oben in der Wand ? : " + getLageInDerWand().equals("obere Hälfte"));
            System.out.println("");
            System.out.println("t_ae = " + t_ae);
            System.out.println("");
            System.out.println("Werkfeuerwehr vorhanden: " + getWerkfeuerwehrVorhanden());

            if (t_ae <= 15) {
                setAnrechenbarkeitWert(0.50);
            } else if (t_ae<=15 && werkfeuerwehrVorhanden) {
                setAnrechenbarkeitWert(1.0);
            } else if (t_ae>15 && t_ae<30){
                double w;
                w = 0.5 + ((1-0.5)/(30-15)) * (t_ae-15);
                setAnrechenbarkeitWert(w);
            } else if (t_ae>= 30) {
                setAnrechenbarkeitWert(1.0);
            }



        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (1)")){

            if (t_ae<= 15) {
                setAnrechenbarkeitWert(0.80);
            } else if (t_ae<= 15 && werkfeuerwehrVorhanden){
                setAnrechenbarkeitWert(1.0);
            } else if (t_ae>=30) {
                setAnrechenbarkeitWert(1.0);
            }

        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (2)")) {

            if (t_ae < 15 && !werkfeuerwehrVorhanden) {
                setAnrechenbarkeitWert(0.35);
            } else if (t_ae < 15 && werkfeuerwehrVorhanden) {
                setAnrechenbarkeitWert(0.70);
            } else if(t_ae>15 && t_ae<=30 && !werkfeuerwehrVorhanden){
                setAnrechenbarkeitWert(0.50);
            }  else if(t_ae>15 && t_ae<=30 && werkfeuerwehrVorhanden){
                setAnrechenbarkeitWert(1.0);
            } else {
                setAnrechenbarkeitWert(1.0);
            }

        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 6")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 7")) {
            setAnrechenbarkeitWert(1.0);

        } else {
            setAnrechenbarkeitWert(0.0);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void bestimmeWertDerAnrechenbarkeit() {
        // Erster Durchgang der Berechnung
        // Zeile 4 und 5 werden nicht berücksichtigt!
        //Es werden die Werte auf der sicheren Seite liegend angenommen!


        if (anrechenbarkeit.equals("Tabelle E.3 Zeile 1")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 2")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 3")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 4")) {
            setAnrechenbarkeitWert(0.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (1)")) {
            setAnrechenbarkeitWert(0.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (2)")) {
            setAnrechenbarkeitWert(0.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 6")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 7")) {
            setAnrechenbarkeitWert(1.0);
        } else {
            setAnrechenbarkeitWert(0.0);
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public void berechneAnrechenbareFlaeche() {
        double f;
        f = getFlaecheGesamt() * getAnrechenbarkeitWert();
        setAnrechenBareFlaeche(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void anrechenbareFlaecheBerechnungGesamt() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeit();
        berechneAnrechenbareFlaeche();
    }

//----------------------------------------------------------------------------------------------------------------------
    //TODO Methode um Av,oben im ersten Durchgang zu bestimmen
    //bestimmt  die Anrechenbarkeit für die Berechnung von Av,oben im 1. Durchgang

    public void bestimmeWertDerAnrechenbarkeitOben() {

        if (getLageInDerWand().equals("obere Hälfte")) {

            if (anrechenbarkeit.equals("Tabelle E.3 Zeile 1")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 2")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 3")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 4")) {
                setAnrechenbarkeitWertOben(0.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (1)")) {
                setAnrechenbarkeitWertOben(0.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (2)")) {
                setAnrechenbarkeitWertOben(0.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 6")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 7")) {
                setAnrechenbarkeitWertOben(1.0);
            } else {
                setAnrechenbarkeitWertOben(0.0);
            }
        } else {
            setAnrechenbarkeitWertOben(0.0);
        }
    }

    public void berechneAnrechenbareFlaecheOben() {
        double f;
        f = getFlaecheGesamt() * getAnrechenbarkeitWertOben();
        setAnrechenBareFlaecheOben(f);
    }

    //Berechnet Av,Oben im 1. Durchgang
    public void anrechenbareFlaecheBerechnungGesamtOben() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeitOben();
        berechneAnrechenbareFlaecheOben();
    }
//----------------------------------------------------------------------------------------------------------------------

    public void bestimmeWertDerAnrechenbarkeitZweiterDurchgangOben() {

        //TODO Zeile 4,6 tä>30 einarbeiten      Zeile 6,7 Thomas fragen welchen Wert man ansetzen darf
        //TODO FUssnoten der Tabelle einarbeiten! -> Abfrage ob Werkfeuerwehr in den Konstruktor!

        if (lageInDerWand.equals("obere Hälfte")) {

            if (anrechenbarkeit.equals("Tabelle E.3 Zeile 1")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 2")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 3")) {
                setAnrechenbarkeitWertOben(1.0);


            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 4") && getLageInDerWand().equals("obere Hälfte")) {

                System.out.println("");
                System.out.println("Zeile 4, Liegt oben in der Wand ? : " + getLageInDerWand().equals("obere Hälfte"));
                System.out.println("");
                System.out.println("t_ae = " + t_ae);
                System.out.println("");
                System.out.println("Werkfeuerwehr vorhanden: " + getWerkfeuerwehrVorhanden());

                if (t_ae <= 15) {
                    setAnrechenbarkeitWertOben(0.50);
                } else if (t_ae <= 15 && werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(1.0);
                } else if (t_ae > 15 && t_ae < 30) {
                    double w;
                    w = 0.5 + ((1 - 0.5) / (30 - 15)) * (t_ae - 15);
                    setAnrechenbarkeitWertOben(w);
                } else if (t_ae >= 30) {
                    setAnrechenbarkeitWertOben(1.0);
                }


            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (1)")) {

                if (t_ae <= 15) {
                    setAnrechenbarkeitWertOben(0.80);
                } else if (t_ae <= 15 && werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(1.0);
                } else if (t_ae >= 30) {
                    setAnrechenbarkeitWertOben(1.0);
                }

            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (2)")) {

                if (t_ae < 15 && !werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(0.35);
                } else if (t_ae < 15 && werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(0.70);
                } else if (t_ae > 15 && t_ae <= 30 && !werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(0.50);
                } else if (t_ae > 15 && t_ae <= 30 && werkfeuerwehrVorhanden) {
                    setAnrechenbarkeitWertOben(1.0);
                } else {
                    setAnrechenbarkeitWertOben(1.0);
                }

            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 6")) {
                setAnrechenbarkeitWertOben(1.0);
            } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 7")) {
                setAnrechenbarkeitWertOben(1.0);

            } else {
                setAnrechenbarkeitWertOben(0.0);
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
    //Zweiter Durchgang OBEN

    public void berechneAnrechenbareFlaecheZweiterDurchgangOben() {
        double f;
        f = getFlaecheGesamt() * getAnrechenbarkeitWertOben();
        setAnrechenBareFlaecheZweiterDurchgangOben(f);
    }

    public void anrechenbareFlaecheBerechnungGesamtZweiterDurchgangOben() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeitZweiterDurchgangOben();
        berechneAnrechenbareFlaecheZweiterDurchgangOben();
    }

//----------------------------------------------------------------------------------------------------------------------

    //"normale" anrechenbare Fläche
    //Zweiter Durchgang
    public void berechneAnrechenbareFlaecheZweiterDurchgang() {
        double f;
        f = getFlaecheGesamt() * getAnrechenbarkeitWert();
        setAnrechenBareFlaecheZweiterDurchgang(f);
    }

    public void anrechenbareFlaecheBerechnungGesamtZweiterDurchgang() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeitZweiterDurchgang();
        berechneAnrechenbareFlaecheZweiterDurchgang();
    }

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Getters und Setters
     */

    public String getNameVWAF() {
        return nameVWAF;
    }

    public void setNameVWAF(String nameVWAF) {
        this.nameVWAF = nameVWAF;
    }

    public String getAnrechenbarkeit() {
        return anrechenbarkeit;
    }

    public void setAnrechenbarkeit(String anrechenbarkeit) {
        this.anrechenbarkeit = anrechenbarkeit;
    }

    public Double getAnrechenbarkeitWert() {
        return anrechenbarkeitWert;
    }

    public void setAnrechenbarkeitWert(Double anrechenbarkeitWert) {
        this.anrechenbarkeitWert = anrechenbarkeitWert;
    }

    public String getLageInDerWand() {
        return lageInDerWand;
    }

    public void setLageInDerWand(String lageInDerWand) {
        this.lageInDerWand = lageInDerWand;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public Double getFlaecheRohbauEinzeln() {
        return flaecheRohbauEinzeln;
    }

    public void setFlaecheRohbauEinzeln(Double flaecheRohbauEinzeln) {
        this.flaecheRohbauEinzeln = flaecheRohbauEinzeln;
    }

    public Double getFlaecheEinzeln() {
        return flaecheEinzeln;
    }

    public void setFlaecheEinzeln(Double flaecheEinzeln) {
        this.flaecheEinzeln = flaecheEinzeln;
    }

    public Double getFlaecheGesamt() {
        return flaecheGesamt;
    }

    public void setFlaecheGesamt(Double flaecheGesamt) {
        this.flaecheGesamt = flaecheGesamt;
    }

    public Double getAnrechenBareFlaeche() {
        return anrechenBareFlaeche;
    }

    public void setAnrechenBareFlaeche(Double anrechenBareFlaeche) {
        this.anrechenBareFlaeche = anrechenBareFlaeche;
    }

    public Boolean getWerkfeuerwehrVorhanden() {
        return werkfeuerwehrVorhanden;
    }

    public void setWerkfeuerwehrVorhanden(Boolean werkfeuerwehrVorhanden) {
        this.werkfeuerwehrVorhanden = werkfeuerwehrVorhanden;
    }

    public Double getT_ae() {
        return t_ae;
    }

    public void setT_ae(Double t_ae) {
        this.t_ae = t_ae;
    }

    public double getAnrechenBareFlaecheZweiterDurchgang() {
        return anrechenBareFlaecheZweiterDurchgang;
    }

    public void setAnrechenBareFlaecheZweiterDurchgang(double anrechenBareFlaecheZweiterDurchgang) {
        this.anrechenBareFlaecheZweiterDurchgang = anrechenBareFlaecheZweiterDurchgang;
    }

    public double getAnrechenbarkeitWertOben() {
        return anrechenbarkeitWertOben;
    }

    public void setAnrechenbarkeitWertOben(double anrechenbarkeitWertOben) {
        this.anrechenbarkeitWertOben = anrechenbarkeitWertOben;
    }

    public Double getAnrechenBareFlaecheOben() {
        return anrechenBareFlaecheOben;
    }

    public void setAnrechenBareFlaecheOben(Double anrechenBareFlaecheOben) {
        this.anrechenBareFlaecheOben = anrechenBareFlaecheOben;
    }

    public double getAnrechenBareFlaecheZweiterDurchgangOben() {
        return anrechenBareFlaecheZweiterDurchgangOben;
    }

    public void setAnrechenBareFlaecheZweiterDurchgangOben(double anrechenBareFlaecheZweiterDurchgangOben) {
        this.anrechenBareFlaecheZweiterDurchgangOben = anrechenBareFlaecheZweiterDurchgangOben;
    }
}

package BBA;

public class HWAF {

    //TODO Zeile 4,6 tä>30 einarbeiten      Zeile 6,7 Thomas fragen welchen Wert man ansetzen darf
    //TODO FUssnoten der Tabelle einarbeiten! -> Abfrage ob Werkfeuerwehr in den Konstruktor!
    //TODO Zeilen für Anrechenbarkeit im alten Programm checken

    String nameHWAF;

    String anrechenbarkeit;

    Double anrechenbarkeitWert;

    Integer anzahl;

    Double flaecheRohbauEinzeln;

    //85% der Rohbaufläche des einzelnen Bauteils
    Double flaecheEinzeln;

    //Anzahl * flaecheEinzeln
    Double flaecheGesamt;

    //anrechenbare Flaeche unter Beruecksichtigung von Tabelle
    Double anrechenbareFlaeche;

    Double anrechenbareFlaecheZweiterDurchgang;

    //zur Einarbeitung der Fussnoten der Tabelle, wird übergeben
    Boolean werkfeuerwehrVorhanden;

    //t_ae aus erster Berechnung um Werte der Tabelle evtl anzupassen, wird übergeben
    Double t_ae;
//----------------------------------------------------------------------------------------------------------------------
    public void berechneFlaecheEinzeln() {
        double f;
        f = getFlaecheRohbauEinzeln() * 0.85;
        setFlaecheEinzeln(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void berechneFlaecheGesamt(){
        double f;
        f = getFlaecheEinzeln() * getAnzahl();
        setFlaecheGesamt(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void bestimmeWertDerAnrechenbarkeitZweiterDurchgang() {
        //Es werden die Werte auf der sicheren Seite liegend angenommen!
        //TODO Zeile 4,6 tä>30 einarbeiten      Zeile 6,7 Thomas fragen welchen Wert man ansetzen darf
        //TODO FUssnoten der Tabelle einarbeiten! -> Abfrage ob Werkfeuerwehr in den Konstruktor!

        if (anrechenbarkeit.equals("Tabelle E.3 Zeile 1")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 2")) {
            setAnrechenbarkeitWert(1.0);
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 3")) {
            setAnrechenbarkeitWert(1.0);

            //Für HWAF wird der Wert auf 100% gesetzt
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 4")) {
            setAnrechenbarkeitWert(1.00);

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
            setAnrechenbarkeitWert(1.0);
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
        } else if (anrechenbarkeit.equals("Tabelle E.3 Zeile 5 (1)")){
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
        setAnrechenbareFlaeche(f);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void anrechenbareFlaecheBerechnungGesamt() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeit();
        berechneAnrechenbareFlaeche();
    }



    //Zweiter Durchgang
    public void berechneAnrechenbareFlaecheZweiterDurchgang() {
        double f;
        f = getFlaecheGesamt() * getAnrechenbarkeitWert();
        setAnrechenbareFlaecheZweiterDurchgang(f);
    }

    public void anrechenbareFlaecheBerechnungGesamtZweiterDurchgang() {
        berechneFlaecheEinzeln();
        berechneFlaecheGesamt();
        berechneFlaecheGesamt();
        bestimmeWertDerAnrechenbarkeitZweiterDurchgang();
        berechneAnrechenbareFlaecheZweiterDurchgang();
    }
//----------------------------------------------------------------------------------------------------------------------

    public String getNameHWAF() {
        return nameHWAF;
    }

    public void setNameHWAF(String nameHWAF) {
        this.nameHWAF = nameHWAF;
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

    public Double getAnrechenbareFlaeche() {
        return anrechenbareFlaeche;
    }

    public void setAnrechenbareFlaeche(Double anrechenbareFläche) {
        this.anrechenbareFlaeche = anrechenbareFläche;
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

    public Double getAnrechenbareFlaecheZweiterDurchgang() {
        return anrechenbareFlaecheZweiterDurchgang;
    }

    public void setAnrechenbareFlaecheZweiterDurchgang(Double anrechenbareFlaecheZweiterDurchgang) {
        this.anrechenbareFlaecheZweiterDurchgang = anrechenbareFlaecheZweiterDurchgang;
    }
}

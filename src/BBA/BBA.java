/**
 * Klasse für die Brandbekämpfungsabschnitte
 */

package BBA;

import BBA.ABew;
import Fehlermeldungen.FehlerAhTB1_1Controller;
import Fehlermeldungen.FehlerBetaWTB1_1Controller;
import Fehlermeldungen.FehlerW0TB1_1Controller;
import Fehlermeldungen.FehlerWTB1_1Controller;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

public class BBA {

    //Name des BBA's
    String nameBBA;

    // Grundfläche [m²]
    double grundflaeche;

    //vertikale Wärmeabzugsflächen [m²]
    double vertikaleWAF;

    double horizontaleWAF;

    // bezogene vertikale Fläche
    double av;

    //bezogene horizontale Fläche von TB1
    double ahTB1;

    //Lagerguthöhe [m]
    double lagerguthoehe;

    //Brandschutztechnische Infrastruktur
    String bTI;

    //mittlere / lichte Geschosshöhe
    double mittlereHoehe;

    //Anzahl der Geschosse
    int anzahlGeschosse;

    //Anzahl der Ebenen
    int anzahlEbenen;

    //Gesamte vertikale ANbzugsflächen (für den globalen Nachweis)
    double vertikaleAbzugsflächenGesamt;

    //Gesamte horizontale Abzugsflächen (für den globalen Nachweis)
    double horizontaleAbzugsflächenGesamt;

    //Gesamte ungeschützte Brandlast (für den globalen Nachweis)
    double ungeschuetzteBrandlastGesamt;

    //Gesamte geschützte Brandlast (für den globalen Nachweis)
    double geschuetzteBrandlastGesamt;

    //Höhenlage des Fußbodens (für Faktor FH)
    double hoehenLageFussboden;

    double a_hGlobal;

    double a_vGlobal;

    double alpha_wGlobal;

    double beta_wGlobal;

    double w_0Global;

    double wGlobal;

    double q_RuGlobal;

    double q_RgGlobal;

    double q_RGlobal;

    double t_aeGlobal;

    double cGlobal;

    double zulFlaecheBBAGlobal;

    //Faktor FH
    double faktorFHGlobal;

    //Faktor FA
    double faktorFAGlobal;

    double grundflaecheGlobal;

    boolean globalerNachweisErfuellt;

    double gammaSKb3;

    double gammaSKb2;

    double gammaSKb1;

    boolean eingeschossig;

    boolean automatischeBrandmeldeanlagen;

    boolean werkfeuerwehrHauptberuflich;

    String werkfeuerwehrSchichtstaerke;

    boolean loeschanlagenVorhanden;

    boolean selbsttaetigeLoeschanlageVorhanden;

    double alpha_L;

    double t_FSKb1;

    double t_FSKb2;

    double t_FSKb3;

    String anforderungenSKb1;

    String anforderungenSKb2;

    String anforderungenSKb3;

    String lageInDerWand;

    double vertikaleWAFOben;

    //ArrayList für die Umfassungsbauteile aus der Tabelleneingabe
    public ArrayList<Umfassungsbauteil> umfassungsbauteileList = new ArrayList<>();

    //ArrayList für die vertikalen WAF aus der Tabelleneingabe
    public ArrayList<VWAF> vwafList = new ArrayList<>();

    //ArrayList für die horizontalen WAF aus der Tabelleneingabe
    public ArrayList<HWAF> hwafList = new ArrayList<>();

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Globaler Nachweis
     *
     * Die Methoden setzen den entsprechenden Wert auf den durch Sie berechneten Wert
     *
     * Die Berechnungen werden dann mit den get-Methoden der jeweiligen Werte ausgeführt
     *
     */

    // ah berechnen nach DIN 18230 (9)
    public void berechneA_hGlobal() throws IOException {

        //Es wird geprueft ob durch das Textfeld schon ein Ah gesetzt worden ist
        if (!(getHorizontaleAbzugsflächenGesamt() == 0)) {
            double a_hGlobal = getHorizontaleAbzugsflächenGesamt() / getGrundflaeche();
            setA_hGlobal(a_hGlobal);
        } else {
            double a_hGlobal = getHorizontaleWAF() / getGrundflaeche();
            setA_hGlobal(a_hGlobal);
        }

        // ah wird geprüft (DIN 18230, 8.3)
        // TODO Die Fehlermeldung wird 2 mal geladen, 1. und 2. Durchgang

        if (a_hGlobal <= 0.005) {

            double av1durchgang = getVertikaleWAF();
            double avoben1durchgang = getVertikaleWAFOben();

            //wenn Av <= 2*Av,oben ist bleibt der Wert gleich Av
            if (av1durchgang <= 2*avoben1durchgang) {
                setVertikaleWAF(getVertikaleWAF());
            // wenn Av > 2*Av,oben ist, wird der Wert für Av auf 2*Av,oben gesetzt
            } else {
                setVertikaleWAF(2*avoben1durchgang);
                System.out.println("Av wurde auf 2*Av,oben gesetzt");
            }


            //TODO Fehlermeldung anpassen, dem NUtzer sagen was angesetzt wird
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fehlermeldungen/FehlerAhTB1_1.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Achtung");
            stage.setScene(new Scene(root1));
            stage.show();


//            setA_hGlobal(0.005);

        }
    }

    public void berechneA_hGlobalZweiterDurchgang() throws IOException {

        //Es wird geprueft ob durch das Textfeld schon ein Ah gesetzt worden ist
        if (!(getHorizontaleAbzugsflächenGesamt() == 0)) {
            double a_hGlobal = getHorizontaleAbzugsflächenGesamt() / getGrundflaeche();
            setA_hGlobal(a_hGlobal);
        } else {
            double a_hGlobal = getHorizontaleWAF() / getGrundflaeche();
            setA_hGlobal(a_hGlobal);
        }

        // ah wird geprüft (DIN 18230, 8.3)
        // TODO Die Fehlermeldung wird 2 mal geladen, 1. und 2. Durchgang

        if (a_hGlobal <= 0.005) {

            double av2durchgang = getVertikaleWAF();
            double avoben2durchgang = getVertikaleWAFOben();

            //wenn Av <= 2*Av,oben ist bleibt der Wert gleich Av
            if (av2durchgang <= 2*avoben2durchgang) {
                setVertikaleWAF(getVertikaleWAF());
                // wenn Av > 2*Av,oben ist, wird der Wert für Av auf 2*Av,oben gesetzt
            } else {
                setVertikaleWAF(2*avoben2durchgang);
                System.out.println("Av wurde auf 2*Av,oben gesetzt");
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fehlermeldungen/FehlerAhTB1_1.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setTitle("Achtung");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    // av berechnen nach DIN 18230 (8)
    // Unterscheidung TextFeld vs Tabelle: Wenn keine gesamte VWAF gesetted wurde wird die Tabelle verwendet
    public void berechneA_vGlobal() {

        //Es wird geprueft ob durch das Textfeld schon ein Av gesetzt worden ist
        if (!(getVertikaleAbzugsflächenGesamt() == 0)) {
            double a_vGlobal = getVertikaleAbzugsflächenGesamt() / getGrundflaeche();
            setA_vGlobal(a_vGlobal);
        } else {
            double a_vGlobal = getVertikaleWAF() / getGrundflaeche();
            setA_vGlobal(a_vGlobal);
        }
    }

    //alpha_w berechnen nach DIN 18230 (14))
    //beim globalen Nachweis wird die mittlere Höhe h berücksichtigt
    public void berechneAlpha_wGlobal() {
        double alpha_w1= Math.pow((6/getMittlereHoehe()), 0.3);
        setAlpha_wGlobal(alpha_w1);
    }

    //Beta-W nach DIN 18230 (13)
    public void berechneBeta_wGlobal() {

        // a_v ist kleiner/gleich 0,025/*/**/*/
        if(getA_vGlobal() <= 0.025) {
            double a_v = 0.025;
            double beta_wGlobal = 20*(1+10*a_v-64*(a_v*a_v)); // DIN 18230 (13)

            if (beta_wGlobal < 16) {
                setBeta_wGlobal(16);
            } else {
                setBeta_wGlobal(beta_wGlobal);
            }

        // a_v ist größer als 0,25
        } else if(getA_vGlobal() > 0.25) {
            double a_v = 0.25;
            double beta_wGlobal = 20*(1+10*a_v-64*(a_v*a_v)); // DIN 18230 (13)

            if (beta_wGlobal < 16) {
                setBeta_wGlobal(16);
            } else {
                setBeta_wGlobal(beta_wGlobal);
            }

        // a_v liegt zwischen 0,025 und 0,25
        } else {
            double a_v = getA_vGlobal();
            double beta_wGlobal = 20 * (1 + 10 * a_v - 64 * (a_v * a_v)); // DIN 18230 (13)

            if (beta_wGlobal < 16) {
                setBeta_wGlobal(16);
            } else {
                setBeta_wGlobal(beta_wGlobal);
            }
        }


    }

    //w_o nach DIN 18230 (12), wenn w_o < 0,5 ist, werden 0,5 angesetzt
    //TODO av muss greprüft werden
    public void berechneW_oGlobal() {

        if (getA_vGlobal() <= 0.025) {
            double w_o1 = (1 + 145 * Math.pow((0.40 - 0.025), 4)) / (1.6 + getBeta_wGlobal() * getA_hGlobal());
            setW_0Global(w_o1);

        } else if (getA_vGlobal() > 0.25) {
            double w_o2 = (1 + 145 * Math.pow((0.40 - 0.25), 4)) / (1.6 + getBeta_wGlobal() * getA_hGlobal());
            setW_0Global(w_o2);
        } else {
            double w_o3 = (1 + 145 * Math.pow((0.40 - getA_vGlobal()), 4)) / (1.6 + getBeta_wGlobal() * getA_hGlobal());
            setW_0Global(w_o3);
        }

        if (getW_0Global() < 0.5) {
            setW_0Global(0.5);
        }
    }

    //wenn w < 0,5 ist, wird 0,5 angesetzt und ein Hinweis für den Nutzer ausgegeben
    public void berechneWGlobal() throws IOException {
        double w1 = getW_0Global() * getAlpha_wGlobal();

        if (w1 < 0.5) {

            FehlerWTB1_1Controller ftbc = new FehlerWTB1_1Controller();
            ftbc.ladeFensterFehlerMeldungWTB1_1();

            setwGlobal(0.5);

        } else {
            setwGlobal(w1);
        }
    }

    // q_R,u nach DIN 18230 (5)
    //TODO
    // im TreeViewController muss festgelegt werden wie UngeschuetzteBrandlastGesamt berechnet und "gesetted" wird!

    public void berechneQ_RuGlobal() {
        double qRu = getUngeschuetzteBrandlastGesamt() / getGrundflaeche();
        setQ_RuGlobal(qRu);
    }

    // q_R,g nach DIN 18230 (6)
    public void berechneQ_RgGlobal() {
        double qRg = getGeschuetzteBrandlastGesamt() / getGrundflaeche();/**/
        setQ_RgGlobal(qRg);
    }

    // q_R nach DIN 18230 (4)
    public void berechneQ_RGlobal() {
        double qR = getQ_RuGlobal() + getQ_RgGlobal();

        // Mindestbrandbelastung = 15 kWh/m²
        if (qR > 15) {
            setQ_RGlobal(qR);
        } else {
            setQ_RGlobal(15.0);
        }
    }

    //äquivalente Branddauer nach DIN 18230 (1)
    public void berechneT_aeGlobal() {
        double t = getQ_RGlobal() * getcGlobal() * getwGlobal();
        setT_aeGlobal(t);
    }

    //die zulässige Größe des BBA wird bestimmt (s. Klasse ABew)
    public void berechneZulFlaecheBBAGlobal() {
        double abew;
        ABew flaeche = new ABew(getT_aeGlobal(), getbTI());
        abew = flaeche.a_bew();
        setZulFlaecheBBAGlobal(abew);
    }

    //der Faktor FH wird bestimmt (s. Klasse FH)
    public void berechneFaktorFHGlobal() {
        double fh;
        FH newFH = new FH(getHoehenLageFussboden());
        fh = newFH.berechneFH();
        setFaktorFHGlobal(fh);
    }

    //beim globalen Nachweis, wird die Grundfläche des BBA bewertet, F_A wird mit 1.0 angesetzt
    public void berechneFaktorFAGlobal() {
        double fa;
        FA newFa = new FA();
        fa = newFa.berechneF_AGrundflächeGlobal();
        setFaktorFAGlobal(fa);
    }

    public void berechneGrundflaecheGlobalerNachweis() {
        double gfG;
        gfG = getGrundflaeche() * getFaktorFHGlobal() * getFaktorFAGlobal();
        setGrundflaecheGlobal(gfG);
    }

    //Prüfung ob der globale Nachweis erfüllt wird
    public void nachweisErfuellt(){

        //Nachweis wird erfüllt
        if (getZulFlaecheBBAGlobal() >= getGrundflaecheGlobal()) {
            setGlobalerNachweisErfuellt(true);

        //Nachweis wird nicht erfüllt
        } else {
            setGlobalerNachweisErfuellt(false);
        }
    }

    public void berechneGamma() throws IOException {
        Gamma gamma = new Gamma(getGrundflaeche(), isEingeschossig());

        if (gamma.isEingeschossig()){
            double g3 = gamma.gammaEingeschossigSkb3();
            setGammaSKb3(g3);

            double g2 = gamma.gammaEingeschossigSkb2();
            setGammaSKb2(g2);

            double g1 = gamma.gammaEingeschossigSkb1();
            setGammaSKb1(g1);

        } else {
            double g3 = gamma.gammaMehrgeschossigSkb3();
            setGammaSKb3(g3);

            double g2 = gamma.gammaMehrgeschossigSkb2();
            setGammaSKb2(g2);

            double g1 = gamma.gammaMehrgeschossigSkb1();
            setGammaSKb1(g1);
        }
    }

    public void berechneAlpha_L() {
        AlphaL alphaL = new AlphaL(isAutomatischeBrandmeldeanlagen(), isWerkfeuerwehrHauptberuflich(), getWerkfeuerwehrschichtstaerke(), isLoeschanlagenVorhanden(),
                isSelbsttaetigeLoeschanlageVorhanden(), getQ_RGlobal());
        double a = alphaL.berechneAlphaL();
        setAlpha_L(a);
    }

    //Achtung: Hier t_ae GLOBAL!
    public void berechneT_FSKb1() {
        double t = getT_aeGlobal() * getGammaSKb1() * getAlpha_L();
        setT_FSKb1(t);
    }

    public void berechneT_FSKb2() {
        double t = getT_aeGlobal() * getGammaSKb2() * getAlpha_L();
        setT_FSKb2(t);
    }

    public void berechneT_FSKb3() {
        double t = getT_aeGlobal() * getGammaSKb3() * getAlpha_L();
        setT_FSKb3(t);
    }

    public void bestimmeAnforderungenSKb1() {
        AnforderungenAnBaustoffeUndBauteile anf = new AnforderungenAnBaustoffeUndBauteile(getT_FSKb1());
        setAnforderungenSKb1(anf.anforderungen());
    }

    public void bestimmeAnforderungenSKb2() {
        AnforderungenAnBaustoffeUndBauteile anf = new AnforderungenAnBaustoffeUndBauteile(getT_FSKb2());
        setAnforderungenSKb2(anf.anforderungen());
    }

    public void bestimmeAnforderungenSKb3() {
        AnforderungenAnBaustoffeUndBauteile anf = new AnforderungenAnBaustoffeUndBauteile(getT_FSKb3());
        setAnforderungenSKb3(anf.anforderungen());
    }



//----------------------------------------------------------------------------------------------------------------------

    //Globaler Nachweis wird geführt
    public void fuehreGlobalenNachweis() throws IOException {

        System.out.println("Der BBA ist eingeschossig: " + isEingeschossig());
        System.out.println("Werkfeuerwehr Schichtstärke: " + getWerkfeuerwehrschichtstaerke());
        System.out.println("Werkfeuerwehr hauptberuflich: " + isWerkfeuerwehrHauptberuflich());
        System.out.println("Automatische BMA vorhanden: " + isAutomatischeBrandmeldeanlagen());
        System.out.println("Löschanlagen :" + isLoeschanlagenVorhanden());
        System.out.println("Selbsttätige Löschanlage vorhanden :" + isSelbsttaetigeLoeschanlageVorhanden());
        System.out.println("");
        System.out.println("");

//        //1. Durchgang
//        Av bestimmen ->
//                Av, oben bestimmen ->
//                Ah bestimmen -> in der Methode festlegen welches Av gesetzt wird -> av bestimmen

//            //wird schon im Treeview Controller ausgeführt
//        berechneVWAFAusTabelle();
//
//        //wird schon im Treeview Controller ausgeführt
//        berechneVWAFObenAusTabelle();

        berechneA_hGlobal();
        berechneA_vGlobal();

        berechneAlpha_wGlobal();
        berechneBeta_wGlobal();
        berechneW_oGlobal();
        berechneWGlobal();
        berechneQ_RuGlobal();
        berechneQ_RgGlobal();
        berechneQ_RGlobal();
        berechneT_aeGlobal();

        System.out.println("");
        System.out.println("Ah aus Tabelle = " + getHorizontaleWAF());
        System.out.println("Ah aus Textfeld = " + getHorizontaleAbzugsflächenGesamt());
        System.out.println("Av,oben aus Tabelle = " + getVertikaleWAFOben());
        System.out.println("Av aus Tabelle = " + getVertikaleWAF());
        System.out.println("Av aus Textfeld = " + getVertikaleAbzugsflächenGesamt());
        System.out.println("a_h_Global (Durchgang 1) = " + getA_hGlobal());
        System.out.println("a_v_Global (Durchgang 1)= " + getA_vGlobal());
        System.out.println("alpha_w_Global (Durchgang 1)= " + getAlpha_wGlobal());
        System.out.println("beta_w_Global (Durchgang 1)= " + getBeta_wGlobal());
        System.out.println("w_0_Global (Durchgang 1)= " + getW_0Global());
        System.out.println("w_Global (Durchgang 1)= " + getwGlobal());
        System.out.println("q_R,u_Global (Durchgang 1)= " + getQ_RuGlobal());
        System.out.println("q_R,g_Global (Durchgang 1)= " + getQ_RgGlobal());
        System.out.println("q_R_Global (Durchgang 1)= " + getQ_RGlobal());
        System.out.println("c_global (Durchgang 1)= " + getcGlobal());
        System.out.println("t_ä_Global (Durchgang 1)= " + getT_aeGlobal());
        System.out.println("");
        System.out.println("");


        //nach der Berechnung Zweiter Durchgang muss alles vorherige noch einmal bestimmt werden!
        //die beiden Methoden setzen die Werte für die Berechnung neu!
        berechneHWAFAusTabelleZweiterDurchgang();
        berechneVWAFAusTabelleZweiterDurchgang();
        berechneVWAFObenAusTabelleZweiterDurchgang();

        berechneA_hGlobalZweiterDurchgang();
        berechneA_vGlobal();
        berechneAlpha_wGlobal();
        berechneBeta_wGlobal();
        berechneW_oGlobal();
        berechneWGlobal();
        berechneQ_RuGlobal();
        berechneQ_RgGlobal();
        berechneQ_RGlobal();
        berechneT_aeGlobal();

        System.out.println("Ah 2. Durchgang: " + getHorizontaleWAF());
        System.out.println("Ah aus Textfeld 2. Durchgang: " + getHorizontaleAbzugsflächenGesamt());
        System.out.println("Av 2. Durchgang: " + getVertikaleWAF());
        System.out.println("a_h_Global (Durchgang 2) = " + getA_hGlobal());
        System.out.println("a_v_Global (Durchgang 2)= " + getA_vGlobal());
        System.out.println("alpha_w_Global (Durchgang 2)= " + getAlpha_wGlobal());
        System.out.println("beta_w_Global (Durchgang 2)= " + getBeta_wGlobal());
        System.out.println("w_0_Global (Durchgang 2)= " + getW_0Global());
        System.out.println("w_Global (Durchgang 2)= " + getwGlobal());
        System.out.println("q_R,u_Global (Durchgang 2)= " + getQ_RuGlobal());
        System.out.println("q_R,g_Global (Durchgang 2)= " + getQ_RgGlobal());
        System.out.println("q_R_Global (Durchgang 2)= " + getQ_RGlobal());
        System.out.println("c_global (Durchgang 2)= " + getcGlobal());
        System.out.println("t_ä_Global (Durchgang 2)= " + getT_aeGlobal());
        System.out.println("");
        System.out.println("");



        berechneZulFlaecheBBAGlobal();
        berechneFaktorFHGlobal();
        berechneFaktorFAGlobal();
        berechneGrundflaecheGlobalerNachweis();
        nachweisErfuellt();
        berechneGamma();
        berechneAlpha_L();
        berechneT_FSKb1();
        berechneT_FSKb2();
        berechneT_FSKb3();
        bestimmeAnforderungenSKb1();
        bestimmeAnforderungenSKb2();
        bestimmeAnforderungenSKb3();

        System.out.println("zulässige Fläche BBA (global) = " + getZulFlaecheBBAGlobal());
        System.out.println("F_H_Global = " + getFaktorFHGlobal());
        System.out.println("F_A_Global = " + getFaktorFAGlobal());
        System.out.println("Grundfläche für den globalen Nachweis = " + getGrundflaecheGlobal());
        System.out.println("Nachweis erfüllt: " + isGlobalerNachweisErfuellt());
        System.out.println("Gamma SKb3 = " + getGammaSKb3());
        System.out.println("Gamma SKb2 = " + getGammaSKb2());
        System.out.println("Gamma SKb1 = " + getGammaSKb1());
        System.out.println("alpha_L = " + getAlpha_L());
        System.out.println("t_F SKb 1 = " + getT_FSKb1());
        System.out.println("t_F SKb 2 = " + getT_FSKb2());
        System.out.println("t_F SKb 3 = " + getT_FSKb3());
        System.out.println("Anforderungen nach SKb1: " + getAnforderungenSKb1());
        System.out.println("Anforderungen nach SKb2: " + getAnforderungenSKb2());
        System.out.println("Anforderungen nach SKb3: " + getAnforderungenSKb3());

    }

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Berechnung der Werte anhand der Tabellen
     */

    //addiert die Anrechenbaren Flächen der VWAF-Liste auf
    public void berechneVWAFAusTabelle() {
        double f = 0;

        for (int i=0; i < vwafList.size(); i++) {
            vwafList.get(i).anrechenbareFlaecheBerechnungGesamt();
            f += vwafList.get(i).getAnrechenBareFlaeche();
        }
        setVertikaleWAF(f);

        //zum Test
        System.out.println("berechneVWAFAusTabelle() (1. Durchlauf):" + getVertikaleWAF());
    }

    //berechnet Av,oben aus der Tabelleneingabe
    public void berechneVWAFObenAusTabelle(){
        double f = 0;

        for (int i=0; i<vwafList.size(); i++) {
            vwafList.get(i).anrechenbareFlaecheBerechnungGesamtOben();
            f += vwafList.get(i).getAnrechenBareFlaecheOben();
        }
        setVertikaleWAFOben(f);

        //zum Test
        System.out.println("berechneVWAFObenAusTabelle() (1. Durchlauf):" + getVertikaleWAFOben());
    }

//----------------------------------------------------------------------------------------------------------------------

    public void berechneCresAusTabelle(){
        double summeCiAi = 0;
        double flaecheGesamt = 0;

        for(int i = 0; i<umfassungsbauteileList.size(); i++) {

            flaecheGesamt += umfassungsbauteileList.get(i).getFlaecheUmfassungsbauteil();

            umfassungsbauteileList.get(i).bestimmeCiAi();
            summeCiAi += umfassungsbauteileList.get(i).getCiAi();
        }

        double cRes = 0;
        cRes = summeCiAi / flaecheGesamt;
        setcGlobal(cRes);

        System.out.println("berechneCresAusTabelle() : " + getcGlobal());
    }
//----------------------------------------------------------------------------------------------------------------------
    public void berechneHWAFAusTabelle() {
        double f = 0;

        for (int i=0; i < hwafList.size(); i++) {
            hwafList.get(i).anrechenbareFlaecheBerechnungGesamt();
            f += hwafList.get(i).getAnrechenbareFlaeche();
        }
        setHorizontaleWAF(f);

        //zum Test
        System.out.println("berechgneHWAFAUsTabelle() liefert (1. Durchlauf):" + getHorizontaleWAF());
    }
//----------------------------------------------------------------------------------------------------------------------
    //Anpassung der Anrechenbarkeit, in Abhaengigkeit von t_ae und Werkfeuerwehr

    public void berechneVWAFAusTabelleZweiterDurchgang() {
        double f = 0;

        for (int i=0; i < vwafList.size(); i++) {

            vwafList.get(i).setT_ae(getT_aeGlobal());

            //wenn nicht keine werkfeuerwehr vorhanden ist -> true
            vwafList.get(i).setWerkfeuerwehrVorhanden(!werkfeuerwehrSchichtstaerke.equals("keine"));


            vwafList.get(i).anrechenbareFlaecheBerechnungGesamtZweiterDurchgang();
            f += vwafList.get(i).getAnrechenBareFlaecheZweiterDurchgang();
        }
        setVertikaleWAF(f);

        //zum Test
        System.out.println("berechneVWAFAusTabelleZweiterDurchgang() (2. Durchlauf):" + getVertikaleWAF());
        System.out.println("");

    }

    public void berechneVWAFObenAusTabelleZweiterDurchgang() {
        double f = 0;

        for (int i=0; i < vwafList.size(); i++) {

            vwafList.get(i).setT_ae(getT_aeGlobal());

            //wenn nicht keine werkfeuerwehr vorhanden ist -> true
            vwafList.get(i).setWerkfeuerwehrVorhanden(!werkfeuerwehrSchichtstaerke.equals("keine"));

            vwafList.get(i).anrechenbareFlaecheBerechnungGesamtZweiterDurchgangOben();

            f+= vwafList.get(i).getAnrechenBareFlaecheZweiterDurchgangOben();
        }
        setVertikaleWAFOben(f);

        //zum Test
        System.out.println("berechneVWAFObenAusTabelleZweiterDurchgang (2. Durchlauf):" + getVertikaleWAF());
        System.out.println("");

    }

    public void berechneHWAFAusTabelleZweiterDurchgang() {
        double f = 0;

        for (int i=0; i < hwafList.size(); i++) {

            hwafList.get(i).setT_ae(getT_aeGlobal());

            //wenn nicht keine werkfeuerwehr vorhanden ist -> true
            hwafList.get(i).setWerkfeuerwehrVorhanden(!werkfeuerwehrSchichtstaerke.equals("keine"));

            hwafList.get(i).anrechenbareFlaecheBerechnungGesamtZweiterDurchgang();
            f += hwafList.get(i).getAnrechenbareFlaecheZweiterDurchgang();
        }
        setHorizontaleWAF(f);

        //zum Test
        System.out.println("berechneHWAFAusTabelleZweiterDurchgang (2. Durchlauf):" + getHorizontaleWAF());
        System.out.println("");
    }
//----------------------------------------------------------------------------------------------------------------------


    public int getAnzahlEbenen() {
        return anzahlEbenen;
    }

    public void setAnzahlEbenen(int anzahlEbenen) {
        this.anzahlEbenen = anzahlEbenen;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void setGrundflaeche(double grundflaeche){
        this.grundflaeche = grundflaeche;
    }

    public double getGrundflaeche() {
        return this.grundflaeche;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getGeschuetzteBrandlastGesamt() {
        return geschuetzteBrandlastGesamt;
    }

    public void setGeschuetzteBrandlastGesamt(double geschuetzteBrandlastGesamt) {
        this.geschuetzteBrandlastGesamt = geschuetzteBrandlastGesamt;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getUngeschuetzteBrandlastGesamt() {
        return ungeschuetzteBrandlastGesamt;
    }

    public void setUngeschuetzteBrandlastGesamt(double ungeschuetzteBrandlastGesamt) {
        this.ungeschuetzteBrandlastGesamt = ungeschuetzteBrandlastGesamt;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getHorizontaleAbzugsflächenGesamt() {
        return horizontaleAbzugsflächenGesamt;
    }

    public void setHorizontaleAbzugsflächenGesamt(double horizontaleAbzugsflächenGesamt) {
        this.horizontaleAbzugsflächenGesamt = horizontaleAbzugsflächenGesamt;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getVertikaleAbzugsflächenGesamt() {
        return vertikaleAbzugsflächenGesamt;
    }

    public void setVertikaleAbzugsflächenGesamt(double vertikaleAbzugsflächenGesamt) {
        this.vertikaleAbzugsflächenGesamt = vertikaleAbzugsflächenGesamt;
    }
//----------------------------------------------------------------------------------------------------------------------

    public int getAnzahlGeschosse() {
        return anzahlGeschosse;
}

    public void setAnzahlGeschosse(int anzahlGeschosse) {
        this.anzahlGeschosse = anzahlGeschosse;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getAv() {
        return round(av, 4);
    }

    public void setAv(double av) {
        this.av = av;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getMittlereHoehe() {
        return mittlereHoehe;
    }

    public void setMittlereHoehe(double hoeheBBA) {
        this.mittlereHoehe = hoeheBBA;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getAhTB1() {
        return ahTB1;
    }

    public void setAhTB1(double ahTB1) {
        this.ahTB1 = ahTB1;
    }
//----------------------------------------------------------------------------------------------------------------------

    public void setName(String nameBBA) {
        this.nameBBA = nameBBA;
    }

    public String getNameBBA(){
        return this.nameBBA;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double getLagerguthoehe() {
        return lagerguthoehe;
}

    public void setLagerguthoehe(double lagerguthoehe) {
        this.lagerguthoehe = lagerguthoehe;
    }

//----------------------------------------------------------------------------------------------------------------------

    public String getbTI() {
        return bTI;
    }

    public void setbTI(String bTI) {
        this.bTI = bTI;
    }

//----------------------------------------------------------------------------------------------------------------------

    public void setVertikaleWAF(double vertikaleWAF){
        this.vertikaleWAF = vertikaleWAF;
    }

    public double getVertikaleWAF() {
        return this.vertikaleWAF;
    }

    public double getHorizontaleWAF() {
        return horizontaleWAF;
    }

    public void setHorizontaleWAF(double horizontaleWAF) {
        this.horizontaleWAF = horizontaleWAF;
    }

//----------------------------------------------------------------------------------------------------------------------

    public double getHoehenLageFussboden() {
        return hoehenLageFussboden;
    }

    public void setHoehenLageFussboden(double hoehenLageFussboden) {
        this.hoehenLageFussboden = hoehenLageFussboden;
    }

//----------------------------------------------------------------------------------------------------------------------

    public double getA_hGlobal() {
        return a_hGlobal;
    }

    public void setA_hGlobal(double a_hGlobal) {
        this.a_hGlobal = a_hGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getA_vGlobal() {
        return a_vGlobal;
    }

    public void setA_vGlobal(double a_vGlobal) {
        this.a_vGlobal = a_vGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getAlpha_wGlobal() {
        return alpha_wGlobal;
    }

    public void setAlpha_wGlobal(double alpha_wGlobal) {
        this.alpha_wGlobal = alpha_wGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getBeta_wGlobal() {
        return beta_wGlobal;
    }

    public void setBeta_wGlobal(double beta_wGlobal) {
        this.beta_wGlobal = beta_wGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getW_0Global() {
        return w_0Global;
    }

    public void setW_0Global(double w_0Global) {
        this.w_0Global = w_0Global;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getwGlobal() {
        return wGlobal;
    }

    public void setwGlobal(double wGlobal) {
        this.wGlobal = wGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getQ_RuGlobal() {
        return q_RuGlobal;
    }

    public void setQ_RuGlobal(double q_RuGlobal) {
        this.q_RuGlobal = q_RuGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getQ_RgGlobal() {
        return q_RgGlobal;
    }

    public void setQ_RgGlobal(double q_RgGlobal) {
        this.q_RgGlobal = q_RgGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getQ_RGlobal() {
        return q_RGlobal;
    }

    public void setQ_RGlobal(double q_RGlobal) {
        this.q_RGlobal = q_RGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getT_aeGlobal() {
        return t_aeGlobal;
    }

    public void setT_aeGlobal(double t_aeGlobal) {
        this.t_aeGlobal = t_aeGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getcGlobal() {
        return cGlobal;
    }

    public void setcGlobal(double cGlobal) {
        this.cGlobal = cGlobal;
    }

//----------------------------------------------------------------------------------------------------------------------

    public double getFaktorFHGlobal() {
        return faktorFHGlobal;
    }

    public void setFaktorFHGlobal(double faktorFHGlobal) {
        this.faktorFHGlobal = faktorFHGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getZulFlaecheBBAGlobal() {
        return zulFlaecheBBAGlobal;
    }

    public void setZulFlaecheBBAGlobal(double zulFlaecheBBAGlobal) {
        this.zulFlaecheBBAGlobal = zulFlaecheBBAGlobal;
    }

//----------------------------------------------------------------------------------------------------------------------

    public double getFaktorFAGlobal() {
        return faktorFAGlobal;
    }

    public void setFaktorFAGlobal(double faktorFAGlobal) {
        this.faktorFAGlobal = faktorFAGlobal;
    }

//----------------------------------------------------------------------------------------------------------------------
    public double getGrundflaecheGlobal() {
        return grundflaecheGlobal;
    }

    public void setGrundflaecheGlobal(double grundflaecheGlobal) {
        this.grundflaecheGlobal = grundflaecheGlobal;
    }
//----------------------------------------------------------------------------------------------------------------------
    public boolean isGlobalerNachweisErfuellt() {
        return globalerNachweisErfuellt;
    }

    public void setGlobalerNachweisErfuellt(boolean globalerNachweisErfuellt) {
        this.globalerNachweisErfuellt = globalerNachweisErfuellt;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getGammaSKb3() {
        return gammaSKb3;
    }

    public void setGammaSKb3(double gammaSKb3) {
        this.gammaSKb3 = gammaSKb3;
    }

    public double getGammaSKb2() {
        return gammaSKb2;
    }

    public void setGammaSKb2(double gammaSKb2) {
        this.gammaSKb2 = gammaSKb2;
    }

    public double getGammaSKb1() {
        return gammaSKb1;
    }

    public void setGammaSKb1(double gammaSKb1) {
        this.gammaSKb1 = gammaSKb1;
    }
//----------------------------------------------------------------------------------------------------------------------

    public boolean isEingeschossig() {
        return eingeschossig;
    }

    public void setEingeschossig(boolean eingeschossig) {
        this.eingeschossig = eingeschossig;
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

    public String getWerkfeuerwehrschichtstaerke() {
        return werkfeuerwehrSchichtstaerke;
    }

    public void setWerkfeuerwehrschichtstaerke(String werkfeuerwehrschichtstaerke) {
        this.werkfeuerwehrSchichtstaerke = werkfeuerwehrschichtstaerke;
    }

    public boolean isLoeschanlagenVorhanden() {
        return loeschanlagenVorhanden;
    }

    public void setLoeschanlagenVorhanden(boolean loeschanlagenVorhanden) {
        this.loeschanlagenVorhanden = loeschanlagenVorhanden;
    }

    public boolean isSelbsttaetigeLoeschanlageVorhanden() {
        return selbsttaetigeLoeschanlageVorhanden;
    }

    public void setSelbsttaetigeLoeschanlageVorhanden(boolean selbsttaetigeLoeschanlageVorhanden) {
        this.selbsttaetigeLoeschanlageVorhanden = selbsttaetigeLoeschanlageVorhanden;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getAlpha_L() {
        return alpha_L;
    }

    public void setAlpha_L(double alpha_L) {
        this.alpha_L = alpha_L;
    }
//----------------------------------------------------------------------------------------------------------------------

    public double getT_FSKb1() {
        return t_FSKb1;
    }

    public void setT_FSKb1(double t_FSKb1) {
        this.t_FSKb1 = t_FSKb1;
    }

    public double getT_FSKb2() {
        return t_FSKb2;
    }

    public void setT_FSKb2(double t_FSKb2) {
        this.t_FSKb2 = t_FSKb2;
    }

    public double getT_FSKb3() {
        return t_FSKb3;
    }

    public void setT_FSKb3(double t_FSKb3) {
        this.t_FSKb3 = t_FSKb3;
    }
//----------------------------------------------------------------------------------------------------------------------
    public String getAnforderungenSKb1() {
        return anforderungenSKb1;
    }

        public void setAnforderungenSKb1(String anforderungenSKb1) {
            this.anforderungenSKb1 = anforderungenSKb1;
        }

        public String getAnforderungenSKb2() {
            return anforderungenSKb2;
        }

        public void setAnforderungenSKb2(String anforderungenSKb2) {
            this.anforderungenSKb2 = anforderungenSKb2;
        }

        public String getAnforderungenSKb3() {
            return anforderungenSKb3;
        }

        public void setAnforderungenSKb3(String anforderungenSKb3) {
            this.anforderungenSKb3 = anforderungenSKb3;
        }

    public String getLageInDerWand() {
        return lageInDerWand;
    }

    public void setLageInDerWand(String lageInDerWand) {
        this.lageInDerWand = lageInDerWand;
    }

    public double getVertikaleWAFOben() {
        return vertikaleWAFOben;
    }

    public void setVertikaleWAFOben(double vertikaleWAFOben) {
        this.vertikaleWAFOben = vertikaleWAFOben;
    }

//----------------------------------------------------------------------------------------------------------------------

    public ArrayList<VWAF> getVwafList() {
        return vwafList;
    }

    public void setVwafList(ArrayList<VWAF> vwafList) {
        this.vwafList = vwafList;
    }
//----------------------------------------------------------------------------------------------------------------------

    //Funktion zum Runden von Double-Werten
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}


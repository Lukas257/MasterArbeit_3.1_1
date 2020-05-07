package BBA;

/**
 * Klasse zur Bestimmung von A_bew anhand von Tabelle 5 der MIndBauRL
 */

public class ABew {

    //tae wid in BBA-Klasse gleich der äquivalenten Branddauer gesetzt
    public double tae;

    //bTI wird in BBA-Klasse gleich der bewählten brandschutztechnischen Infrastruktur gesetzt
    public String bTI;

    //Konstruktor
    public ABew (Double newTae, String newBTI) {
        tae = newTae;
        bTI = newBTI;
    }

    //Berechnet A_bew
    public double a_bew() {
        if (bTI.equals("K 1")) {
            double abew = a_bewK1();
            return abew;
        } else if (bTI.equals("K 2")) {
            double abew = a_bewK2();
            return abew;
        } else if (bTI.equals("K 3.1")) {
            double abew = a_bewK3_1();
            return abew;
        } else if (bTI.equals("K 3.2")) {
            double abew = a_bewK3_2();
            return abew;
        } else if (bTI.equals("K 3.3")) {
            double abew = a_bewK3_3();
            return abew;
        } else if (bTI.equals("K 3.4")) {
            double abew = a_bewK3_4();
            return abew;
        } else if (bTI.equals("K 4")) {
            double abew = a_bewK4();
            return abew;
        } else {
            return 0;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 1 ist
    public double a_bewK1() {

        if(tae == 0) {
            return tabelleA_bew[0][0];

        } else if(tae > 0 && tae < 15) {
            double abew = tabelleA_bew[0][0] + ((tabelleA_bew[0][1] - tabelleA_bew[0][0]) / (15 - 0)) * (tae - 0);
            return abew;

        } else if (tae == 15) {
            return tabelleA_bew[0][1];

        } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[0][1] + ((tabelleA_bew[0][2] - tabelleA_bew[0][1]) / (30 - 15)) * (tae - 15);
            return abew;

        } else if (tae == 30) {
            return tabelleA_bew[0][2];

        } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[0][2] + ((tabelleA_bew[0][3] - tabelleA_bew[0][2]) / (60 - 30)) * (tae - 30);
            return abew;

        } else if (tae == 60) {
            return tabelleA_bew[0][3];

        } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[0][3] + ((tabelleA_bew[0][4] - tabelleA_bew[0][3]) / (90 - 60)) * (tae - 60);
            return abew;

        } else if (tae >= 90) {
            return tabelleA_bew[0][4];

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    //Bestimmen/Interpolieren von A_bew wenn BTI = K 2 ist
    public double a_bewK2() {

        if(tae == 0) {
            return tabelleA_bew[1][0];

        } else if(tae > 0 && tae < 15) {
            double abew = tabelleA_bew[1][0] + ((tabelleA_bew[1][1] - tabelleA_bew[1][0]) / (15 - 0)) * (tae - 0);
            return abew;

        } else if (tae == 15) {
            return tabelleA_bew[1][1];

        } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[1][1] + ((tabelleA_bew[1][2] - tabelleA_bew[1][1]) / (30 - 15)) * (tae - 15);
            return abew;

        } else if (tae == 30) {
            return tabelleA_bew[1][2];

        } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[1][2] + ((tabelleA_bew[1][3] - tabelleA_bew[1][2]) / (60 - 30)) * (tae - 30);
            return abew;

        } else if (tae == 60) {
            return tabelleA_bew[1][3];

        } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[1][3] + ((tabelleA_bew[1][4] - tabelleA_bew[1][3]) / (90 - 60)) * (tae - 60);
            return abew;

        } else if (tae >= 90) {
            return tabelleA_bew[1][4];

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 3.1 ist
    public double a_bewK3_1() {

        if(tae == 0) {
        return tabelleA_bew[2][0];

        } else if(tae > 0 && tae < 15) {
        double abew = tabelleA_bew[2][0] + ((tabelleA_bew[2][1] - tabelleA_bew[2][0]) / (15 - 0)) * (tae - 0);
        return abew;

        } else if (tae == 15) {
        return tabelleA_bew[2][1];

        } else if (tae > 15 && tae < 30){
        double abew = tabelleA_bew[2][1] + ((tabelleA_bew[2][2] - tabelleA_bew[2][1]) / (30 - 15)) * (tae - 15);
        return abew;

        } else if (tae == 30) {
        return tabelleA_bew[2][2];

        } else if (tae > 30 && tae < 60) {
        double abew = tabelleA_bew[2][2] + ((tabelleA_bew[2][3] - tabelleA_bew[2][2]) / (60 - 30)) * (tae - 30);
        return abew;

        } else if (tae == 60) {
        return tabelleA_bew[2][3];

        } else if (tae > 60 && tae < 90) {
        double abew = tabelleA_bew[2][3] + ((tabelleA_bew[2][4] - tabelleA_bew[2][3]) / (90 - 60)) * (tae - 60);
        return abew;

        } else if (tae >= 90) {
        return tabelleA_bew[2][4];

        } else {
        return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 3.2 ist
    public double a_bewK3_2() {

        if(tae == 0) {
         return tabelleA_bew[3][0];

        } else if(tae > 0 && tae < 15) {
         double abew = tabelleA_bew[3][0] + ((tabelleA_bew[3][1] - tabelleA_bew[3][0]) / (15 - 0)) * (tae - 0);
         return abew;

      } else if (tae == 15) {
            return tabelleA_bew[3][1];

      } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[3][1] + ((tabelleA_bew[3][2] - tabelleA_bew[3][1]) / (30 - 15)) * (tae - 15);
            return abew;

      } else if (tae == 30) {
            return tabelleA_bew[3][2];

      } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[3][2] + ((tabelleA_bew[3][3] - tabelleA_bew[3][2]) / (60 - 30)) * (tae - 30);
            return abew;

      } else if (tae == 60) {
            return tabelleA_bew[3][3];

      } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[3][3] + ((tabelleA_bew[3][4] - tabelleA_bew[3][3]) / (90 - 60)) * (tae - 60);
            return abew;

      } else if (tae >= 90) {
            return tabelleA_bew[3][4];

      } else {
            return 0;
      }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 3.3 ist
    public double a_bewK3_3() {

        if(tae == 0) {
            return tabelleA_bew[4][0];

        } else if(tae > 0 && tae < 15) {
            double abew = tabelleA_bew[4][0] + ((tabelleA_bew[4][1] - tabelleA_bew[4][0]) / (15 - 0)) * (tae - 0);
            return abew;

        } else if (tae == 15) {
            return tabelleA_bew[4][1];

        } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[4][1] + ((tabelleA_bew[4][2] - tabelleA_bew[4][1]) / (30 - 15)) * (tae - 15);
            return abew;

        } else if (tae == 30) {
            return tabelleA_bew[4][2];

        } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[4][2] + ((tabelleA_bew[4][3] - tabelleA_bew[4][2]) / (60 - 30)) * (tae - 30);
            return abew;

        } else if (tae == 60) {
            return tabelleA_bew[4][3];

        } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[4][3] + ((tabelleA_bew[4][4] - tabelleA_bew[4][3]) / (90 - 60)) * (tae - 60);
            return abew;

        } else if (tae >= 90) {
            return tabelleA_bew[4][4];

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 3.4 ist
    public double a_bewK3_4() {

        if(tae == 0) {
            return tabelleA_bew[5][0];

        } else if(tae > 0 && tae < 15) {
            double abew = tabelleA_bew[5][0] + ((tabelleA_bew[5][1] - tabelleA_bew[5][0]) / (15 - 0)) * (tae - 0);
            return abew;

        } else if (tae == 15) {
            return tabelleA_bew[5][1];

        } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[5][1] + ((tabelleA_bew[5][2] - tabelleA_bew[5][1]) / (30 - 15)) * (tae - 15);
            return abew;

        } else if (tae == 30) {
            return tabelleA_bew[5][2];

        } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[5][2] + ((tabelleA_bew[5][3] - tabelleA_bew[5][2]) / (60 - 30)) * (tae - 30);
            return abew;

        } else if (tae == 60) {
            return tabelleA_bew[5][3];

        } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[5][3] + ((tabelleA_bew[5][4] - tabelleA_bew[5][3]) / (90 - 60)) * (tae - 60);
            return abew;

        } else if (tae >= 90) {
            return tabelleA_bew[5][4];

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //Bestimmen/Interpolieren von A_bew wenn BTI = K 4 ist
    public double a_bewK4() {

        if(tae == 0) {
            return tabelleA_bew[6][0];

        } else if(tae > 0 && tae < 15) {
            double abew = tabelleA_bew[6][0] + ((tabelleA_bew[6][1] - tabelleA_bew[6][0]) / (15 - 0)) * (tae - 0);
            return abew;

        } else if (tae == 15) {
            return tabelleA_bew[6][1];

        } else if (tae > 15 && tae < 30){
            double abew = tabelleA_bew[6][1] + ((tabelleA_bew[6][2] - tabelleA_bew[6][1]) / (30 - 15)) * (tae - 15);
            return abew;

        } else if (tae == 30) {
            return tabelleA_bew[6][2];

        } else if (tae > 30 && tae < 60) {
            double abew = tabelleA_bew[6][2] + ((tabelleA_bew[6][3] - tabelleA_bew[6][2]) / (60 - 30)) * (tae - 30);
            return abew;

        } else if (tae == 60) {
            return tabelleA_bew[6][3];

        } else if (tae > 60 && tae < 90) {
            double abew = tabelleA_bew[6][3] + ((tabelleA_bew[6][4] - tabelleA_bew[6][3]) / (90 - 60)) * (tae - 60);
            return abew;

        } else if (tae >= 90) {
            return tabelleA_bew[6][4];

        } else {
            return 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Tabelle 5 der MIndBauRL
     */

    int [][] tabelleA_bew = {
            {40000, 20000, 12000, 6000, 4000},
            {60000, 30000, 18000, 9000, 6000},
            {72000, 36000, 21600, 10800, 7200},
            {80000, 40000, 24000, 12000, 8000},
            {92000, 46000, 27600, 13800, 9200},
            {100000, 50000, 30000, 15000, 10000},
            {140000, 70000, 42000, 21000, 14000}
    };

}

package BBA;

public class  Umfassungsbauteil {

    //TODO: Wenn hier geaendert wird muss auch die initialisierung der TableColumns im TVC geaendert werden!

    String nameUmfassungsbauteil;
    Double flaecheUmfassungsbauteil;

    //cFaktor für ein Umfassungsbauteil, anhand der Einflussgrußße festgelegt
    Double cFaktor;

    Double ciAi;

    Double flaecheUmfassungsbauteileGesamt;

    // 0 = I, 1 = II, 2=III (als Index der ComboBox!)
    String einflussgruppeUmfassungbauteile;

//----------------------------------------------------------------------------------------------------------------------

    //C-Faktor und Fläche werden miteinander multipliziert, für die Berechnung von C-res
    public void bestimmeCiAi(){
       setCiAi(cFaktor * flaecheUmfassungsbauteil);
    }

//----------------------------------------------------------------------------------------------------------------------

    public Double getCFaktor() {
    return cFaktor;
}

    public void setCFaktor(double cFaktor) {
        this.cFaktor = cFaktor;
    }

    public String getEinflussgruppeUmfassungbauteile() {
        return einflussgruppeUmfassungbauteile;
    }

    public void setEinflussgruppeUmfassungbauteile(String einflussgruppeUmfassungbauteile) {
        this.einflussgruppeUmfassungbauteile = einflussgruppeUmfassungbauteile;
    }

    public String getNameUmfassungsbauteil() {
        return nameUmfassungsbauteil;
    }

    public void setNameUmfassungsbauteil(String nameUmfassungsbauteil) {
        this.nameUmfassungsbauteil = nameUmfassungsbauteil;
    }

    public double getFlaecheUmfassungsbauteil() {
        return flaecheUmfassungsbauteil;
    }

    public void setFlaecheUmfassungsbauteil(double flaecheUmfassungsbauteil) {
        this.flaecheUmfassungsbauteil = flaecheUmfassungsbauteil;
    }

    public Double getCiAi() {
        return ciAi;
    }

    public void setCiAi(Double ciAi) {
        this.ciAi = ciAi;
    }

    public Double getFlaecheUmfassungsbauteileGesamt() {
        return flaecheUmfassungsbauteileGesamt;
    }

    public void setFlaecheUmfassungsbauteileGesamt(Double flaecheUmfassungsbauteileGesamt) {
        this.flaecheUmfassungsbauteileGesamt = flaecheUmfassungsbauteileGesamt;
    }
//----------------------------------------------------------------------------------------------------------------------
}


package Materialbibliothek;

public class Stoff {

    String nameStoff;

    String beschreibungStoff;

    Integer lagerungsdichteStoff;

    Double heizwertStoff;

    Double abbrandfaktorStoff;

    public Stoff(String nameStoff, String beschreibungStoff, Integer lagerungsdichteStoff, Double abbrandfaktorStoff, Double heizwertStoff) {
        this.nameStoff = nameStoff;
        this.beschreibungStoff = beschreibungStoff;
        this.lagerungsdichteStoff = lagerungsdichteStoff;
        this.heizwertStoff = heizwertStoff;
        this.abbrandfaktorStoff = abbrandfaktorStoff;
    }

    public String getNameStoff() {
        return nameStoff;
    }

    public void setNameStoff(String nameStoff) {
        this.nameStoff = nameStoff;
    }

    public String getBeschreibungStoff() {
        return beschreibungStoff;
    }

    public void setBeschreibungStoff(String beschreibungStoff) {
        this.beschreibungStoff = beschreibungStoff;
    }

    public Double getHeizwertStoff() {
        return heizwertStoff;
    }

    public void setHeizwertStoff(Double heizwertStoff) {
        this.heizwertStoff = heizwertStoff;
    }

    public Double getAbbrandfaktorStoff() {
        return abbrandfaktorStoff;
    }

    public void setAbbrandfaktorStoff(Double abbrandfaktorStoff) {
        this.abbrandfaktorStoff = abbrandfaktorStoff;
    }

    public Integer getLagerungsdichteStoff() {
        return lagerungsdichteStoff;
    }

    public void setLagerungsdichte(Integer lagerungsdichteStoff) {
        this.lagerungsdichteStoff = lagerungsdichteStoff;
    }
}

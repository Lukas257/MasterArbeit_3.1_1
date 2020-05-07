package Materialbibliothek;

public class Nutzung {

    String nutzung;

    Integer brandlast1;

    Integer brandlast2;

    Integer brandlast3;

    public Nutzung(String nutzung, Integer brandlast1, Integer brandlast2, Integer brandlast3) {
        this.nutzung = nutzung;
        this.brandlast1 = brandlast1;
        this.brandlast2 = brandlast2;
        this.brandlast3 = brandlast3;
    }
    public String getNutzung() {
        return nutzung;
    }

    public void setNutzung(String nutzung) {
        this.nutzung = nutzung;
    }

    public Integer getBrandlast1() {
        return brandlast1;
    }

    public void setBrandlast1(Integer brandlast1) {
        this.brandlast1 = brandlast1;
    }

    public Integer getBrandlast2() {
        return brandlast2;
    }

    public void setBrandlast2(Integer brandlast2) {
        this.brandlast2 = brandlast2;
    }

    public Integer getBrandlast3() {
        return brandlast3;
    }

    public void setBrandlast3(Integer brandlast3) {
        this.brandlast3 = brandlast3;
    }


}

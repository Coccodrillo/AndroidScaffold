package uk.co.span9.krneki.models;


public class Dogodek {

    private String naslov;
    private String tekst;
    private long datum;

    public Dogodek(String naslov, String tekst, long datum) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.datum = datum;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public long getDatum() {
        return datum;
    }

    public void setDatum(long datum) {
        this.datum = datum;
    }
}

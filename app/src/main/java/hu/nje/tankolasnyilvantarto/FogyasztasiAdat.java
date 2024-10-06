package hu.nje.tankolasnyilvantarto;

public class FogyasztasiAdat {

    private String datum;

    public float getFogyasztas() {
        return fogyasztas;
    }

    public void setFogyasztas(float fogyasztas) {
        this.fogyasztas = fogyasztas;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    private float fogyasztas;

    public FogyasztasiAdat(String datum, float fogyasztas) {
        this.datum = datum;
        this.fogyasztas = fogyasztas;
    }



}

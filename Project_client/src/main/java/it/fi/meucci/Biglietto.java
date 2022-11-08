package it.fi.meucci;

public class Biglietto {
    int id ;
    String NBiglietto;
    static int iD;

    public Biglietto(String nBiglietto) {
        NBiglietto = nBiglietto;
        iD++;
        id=iD;
        
    }
    public Biglietto() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNBiglietto() {
        return NBiglietto;
    }
    public void setNBiglietto(String nBiglietto) {
        NBiglietto = nBiglietto;
    }
    @Override
    public String toString() {
        return "Biglietti [id=" + id + ", NBiglietto=" + NBiglietto + "]";
    }

    
}

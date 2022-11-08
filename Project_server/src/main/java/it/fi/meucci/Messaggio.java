package it.fi.meucci;

import java.util.ArrayList;

public class Messaggio {
    
    ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

    @Override
    public String toString() {
        return "Messaggio [biglietti=" + biglietti + "]";
    }

    public Messaggio() {
    }

    public ArrayList<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }
    public void crea(Biglietto a){
        biglietti.add(a);
    }

}

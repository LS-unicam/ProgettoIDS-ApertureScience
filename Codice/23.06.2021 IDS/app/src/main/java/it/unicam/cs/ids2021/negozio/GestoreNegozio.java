package it.unicam.cs.ids2021.negozio;

import it.unicam.cs.ids2021.consegne.Posizione;

import java.util.HashSet;
import java.util.Set;

public class GestoreNegozio implements GestoreNegozioI {
    Set<Negozio> setNegozi;
    Set<Prodotti> setProdotti;

    // costruttore--------------------------------------------------------------------
    public GestoreNegozio(Set<Negozio> setNegozi) {
        this.setNegozi = setNegozi;
    }

    // getter & setter ---------------------------------------------------------------
    public Set<Negozio> getSetNegozi() {
        return setNegozi;
    }
    public void setSetNegozi(Set<Negozio> setNegozi) {
        this.setNegozi = setNegozi;
    }

    //Altri metodi---------------------------------------------------------------------
    public Negozio cercaNegozio(String nome)throws IllegalArgumentException{
        for(Negozio n : getSetNegozi()){if(n.getNome().equals(nome)) return n;}
        throw new IllegalArgumentException("Non e' stato inserito nel sistema un negozio con questo nome.");
    }
    public boolean containsNegozio(String nome) {
        for(Negozio n : getSetNegozi()){if(n.getNome().equals(nome)) return true;}
        return false;
    }


}

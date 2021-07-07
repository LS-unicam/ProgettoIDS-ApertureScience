package it.unicam.cs.ids2021.negozio;

import java.util.Set;

public interface GestoreNegozioI {
    Negozio cercaNegozio(String nome);
    boolean containsNegozio(String nome);
    public Set<Negozio> getSetNegozi();
}

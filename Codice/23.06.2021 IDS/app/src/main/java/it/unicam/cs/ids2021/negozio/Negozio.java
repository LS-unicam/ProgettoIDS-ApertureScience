package it.unicam.cs.ids2021.negozio;

import java.util.Map;

public interface Negozio {
    public Map<Prodotto, Integer> getMapProdotti();
    public boolean containsProdotto(Prodotto p);
    public void aggiungiProdotto(Prodotto p, Integer q);
    }


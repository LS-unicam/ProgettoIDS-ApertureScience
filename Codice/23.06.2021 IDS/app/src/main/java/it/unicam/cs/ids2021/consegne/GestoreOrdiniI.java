package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;

import java.util.List;

public interface GestoreOrdiniI {
    List<Dimensione> dimensionePacco(double d);
    public void aggiungiProdotto(Ordine o, Prodotto p, int quantita);
}

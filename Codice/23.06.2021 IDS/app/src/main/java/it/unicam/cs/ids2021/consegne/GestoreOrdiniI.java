package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Set;

public interface GestoreOrdiniI {
    public Set<Pacco> getSetPacco();
    public Set<Ordine> getSetOrdine();
    public String generaId();
    List<Dimensione> dimensionePacco(double d);
    public void aggiungiOrdine(Ordine o);
    public void aggiungiProdotto(Ordine o, Prodotto p, int quantita);
    public Ordine cercaOrdine (String idOrdine);
}

package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GestoreOrdiniI {
    public Set<Pacco> getSetPacco();
    public Set<Ordine> getSetOrdine();

    List<Dimensione> dimensionePacco(double d);

    public Ordine creaOrdine(Map<Prodotto, Integer> map);
    public String generaId();
    public void aggiungiOrdine(Ordine o);
    public Ordine cercaOrdine (String idOrdine);
    public Boolean containsOrdine(String idOrdine);
    public void eliminaOrdine(String idOrdine);

    public void aggiungiProdotto(Ordine o, Prodotto p, int quantita);
    public void eliminaProdotto(Ordine o,String idProdotto);
}

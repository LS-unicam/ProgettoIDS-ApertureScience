package it.unicam.cs.ids2021.consegne;
import it.unicam.cs.ids2021.negozio.Prodotto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestoreOrdini implements GestoreOrdiniI {

    private Set<Ordine> setOrdine;
    private Set<Pacco> setPacco;

    //costruttore gestore ordini----------------------------------
    public GestoreOrdini(Set<Ordine> setOrdine) {
        this.setOrdine = setOrdine;
        this.setPacco = setPacco;
    }

    public Set<Ordine> getSetOrdine() {
        return setOrdine;
    }

    public Set<Pacco> getSetPacco() {
        return setPacco;
    }

    //Altri metodi------------------------------------------------

    /**
     * Genera un Id per l'ordine
     *
     * @return
     */
    public String generaId() {
        String temp = RandomStringUtils.randomAlphanumeric(8, 8);
        for (Ordine o : getSetOrdine()) {
            if (o.getIdOrdine().equals(temp)) generaId();
        }
        return temp;
    }

    List<Dimensione> listaDim = new ArrayList<>();

    /**
     * Stabilisce le dimensioni ottimali dei pacchi
     *
     * @param d
     * @return una lista di dimensioni dei pacchi
     */
    public List<Dimensione> dimensionePacco(double d) {
        if (d < 30) {
            if (d < 10) {
                listaDim.add(Dimensione.PICCOLO);
            }
            if (d >= 10 && d < 20) {
                listaDim.add(Dimensione.MEDIO);
            }
            if (d >= 20 && d < 30) {
                listaDim.add(Dimensione.GRANDE);
            }
        } else {
            listaDim.add(Dimensione.GRANDE);
            dimensionePacco(d = d - 30);
        }
        return listaDim;
    }

    /**
     * Aggiunge un ordine al setOrdine
     * @param o
     */
    public void aggiungiOrdine(Ordine o) {
        this.setOrdine.add(o);
    }

    /**
     * Aggiungi un prodotto
     *
     * @param p
     * @param quantita
     */
    public void aggiungiProdotto(Ordine o, Prodotto p, int quantita) {
        if (o.containsProdotto(p) == false) {
            o.aggiungiProdotto(p, quantita);
        }
        o.getMapProdotti().computeIfPresent(p, (k, v) -> v += quantita);
    }


    /**
     * Cerca un ordine in base ad un Id
     *
     * @param idOrdine
     * @return L'ordine cercato
     * @throws IllegalArgumentException Se non viene trovato nessun ordine con quell'id
     */
    public Ordine cercaOrdine(String idOrdine) throws IllegalArgumentException {
        for (Ordine o : getSetOrdine()) {
            if (o.getIdOrdine().equals(idOrdine))
                return o;
        }
        throw new IllegalArgumentException("Nessun ordine ha questo id.");
    }


}

package it.unicam.cs.ids2021.consegne;
import it.unicam.cs.ids2021.negozio.Prodotto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

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



//ORDINE---------------------------------------------------------------
    /**
     * Genera un Id per l'ordine
     *
     * @return un id alfanumerico di otto cifre
     */
    public String generaId() {
        String temp = RandomStringUtils.randomAlphanumeric(8, 8);
        for (Ordine o : getSetOrdine()) {
            if (o.getIdOrdine().equals(temp)) generaId();
        }
        return temp;
    }

    public void setIdOrdine(Ordine o, String idOrdine){

        o.setIdOrdine(idOrdine);
    }
    public Ordine creaOrdine(Map<Prodotto, Integer> map) {
        Ordine o = new OrdineCreatoreConcrete().creatOrdine(map);
        o.setIdOrdine(generaId());
        aggiungiOrdine(o);
        return o;
    }

    /**
     * Aggiunge un ordine al setOrdine
     * @param o Ordine da eliminare
     */
    public void aggiungiOrdine(Ordine o) { this.setOrdine.add(o); }

    /**
     * Elimina il prodotto scelto
     * @param o Ordine da eliminare
     */
    private void eliminaOrdine(Ordine o) {
        this.setOrdine.remove(o);
    }

    public void eliminaOrdine(String idOrdine) throws IllegalArgumentException{
        if(containsOrdine(idOrdine))eliminaOrdine(cercaOrdine(idOrdine));
        else throw new IllegalArgumentException("L'ordine che si vuole eliminare non è presente.");
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

    /**
     * Cerca se un ordine è presente nel set di ordini.
     * @param idOrdine
     * @return true se è presente false altrimenti
     * @throws IllegalArgumentException
     */
    public Boolean containsOrdine(String idOrdine)  {
        for (Ordine o : getSetOrdine()) {
            if (o.getIdOrdine().equals(idOrdine))
                return true;
        }
        return false;
    }


    //-------------------------------------------------------------------------------

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

    public void eliminaProdotto(Ordine o, String idProdotto) throws IllegalArgumentException {
        if (o.containsProdotto(o.cercaProdotto(idProdotto))) {
            o.getMapProdotti().remove(o.cercaProdotto(idProdotto));
        }throw  new IllegalArgumentException("Il prodotto che si vuole eliminare non e' presente.");
    }

}

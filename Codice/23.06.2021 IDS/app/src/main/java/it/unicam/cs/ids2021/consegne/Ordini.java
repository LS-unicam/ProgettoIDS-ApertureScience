package it.unicam.cs.ids2021.consegne;
import it.unicam.cs.ids2021.negozio.Prodotto;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Ordini implements Ordine {
    private String idOrdine;
    private Map<Prodotto, Integer> mapProdotti;//map<Prodotti, quantita>
    private LocalDate data;
    private Set<Pacco> setPacchi; // set

    // Costruttore---------------------------------------------------------
    public Ordini(Map<Prodotto, Integer> mapProdotti) {
        this.mapProdotti = mapProdotti;
        this.data = LocalDate.now();
        this.setPacchi = new HashSet<>();
        this.idOrdine =  "";
    }

    //equals & hashcode----------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordini ordini = (Ordini) o;
        return idOrdine.equals(ordini.idOrdine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrdine);
    }

    //Getters & Setters-----------------------------------------------------
    @Override
    public String getIdOrdine() {
        return idOrdine;
    }

    @Override
    public void setIdOrdine(String idOrdine) {
        this.idOrdine = idOrdine;
    }

    @Override
    public Map<Prodotto, Integer> getMapProdotti() {
        return mapProdotti;
    }

    public Set<Pacco> getSetPacchi() {
        return setPacchi;
    }

    public LocalDate getData() {
        return data;
    }

    //Altri metodi---------------------------------------------------------

    /**
     * Il metodo volume Ordine Calcola il volume dei prodotti dell'ordine
     *
     * @return float: somma dei volumi di tutti i pprodotti che compongono l'ordine
     */
        public  double  volumeOrdine() {
            double sum = 0;
            for (Prodotto p: this.mapProdotti.keySet())
                sum +=( p.getVolume()*this.mapProdotti.get(p));
            return sum;
            }

    /**
     * cercaProdotto è un metodo a cui viene passato un prodotto, che restituisce un boolean
     *
     * @param p
     * @return true se il prodotto è stato trovato false altrimenti
     */
    public boolean containsProdotto(Prodotto p) {
        for (Prodotto prodotto : this.mapProdotti.keySet()) {
            if (p.equals(prodotto)) return true;
        }
        return false;
    }

    public Prodotto containsProdotto(String id) throws IllegalArgumentException {
        for (Prodotto prodotto : this.mapProdotti.keySet()) {
            if (id.equals(prodotto.getId())) return prodotto;
        }
        throw new IllegalArgumentException("Il prodotto non è presente.");
    }

    /**
     * Aggiungi un prodotto all'ordine dei prodotti
     *
     * @param p
     * @param quantita
     */
    public void aggiungiProdotto(Prodotto p, int quantita) {
        this.getMapProdotti().put(p, quantita);
    }



}

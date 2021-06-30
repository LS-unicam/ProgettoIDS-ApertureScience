package it.unicam.cs.ids2021.negozio;
import it.unicam.cs.ids2021.consegne.Posizione;
import it.unicam.cs.ids2021.utenti.Cassieri;

import java.util.*;

public class Negozi implements Negozio {
    private String nome;
    private Posizione posizione;
    private Map <Prodotto,Integer> mapProdotti;
    private Set<CategorieProdotti> categorie;


    //Costruttore----------------------------------------------
    public Negozi(String nome, Posizione posizione) {
        this.nome = nome;
        this.posizione = posizione;
        this.categorie = null;
        this.mapProdotti = new HashMap<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negozi negozi = (Negozi) o;
        return nome.equals(negozi.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    //Getters and Setters--------------------------------------
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Posizione getPosizione() { return posizione; }

    public void setPosizione(Posizione posizione) { this.posizione = posizione; }

    public Map<Prodotto, Integer> getMapProdotti() {
        return mapProdotti;
    }

    public Set<CategorieProdotti> getSetCategorie() { return categorie; }


    //altri metodi------------------------------------------------------

    /**Ricarca in base al prodotto
     * @param p
     * @return true se è presente, False altrimenti
     */
    public boolean containsProdotto(Prodotto p) {
        for (Prodotto prodotto : this.mapProdotti.keySet()) {
            if (p.equals(prodotto)) return true;
        }
        return false;
    }

    /**Ricerca in base all'id del prodotto
     * @param id
     * @return Ritorna il prodotto cercato
     * @throws IllegalArgumentException
     */
    public Prodotto containsProdotto(String id) throws IllegalArgumentException {
        for (Prodotto prodotto : this.mapProdotti.keySet()) {
            if (id.equals(prodotto.getId())) return prodotto;
        }
        throw new IllegalArgumentException("Il prodotto non è presente.");
    }

    /** Agginge un prodotto alla mappa di tutti i prodotti
     * @param p
     * @param q
     */
    public void aggiungiProdotto(Prodotto p, Integer q) {
        if (!this.mapProdotti.containsKey(p)) {
            this.mapProdotti.put(p, q);
        }
        this.mapProdotti.computeIfPresent(p, (k, v) -> v += q);
    }

    /**
     * La quantita viene modificata in base al numero passato
     * @param p
     * @param q
     */
    public void setQuantita(Prodotto p, Integer q) {
        this.mapProdotti.computeIfPresent(p, (k, v) -> v = q);
    }

}

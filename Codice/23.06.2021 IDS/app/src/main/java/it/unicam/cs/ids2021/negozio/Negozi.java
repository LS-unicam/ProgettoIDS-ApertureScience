package it.unicam.cs.ids2021.negozio;
import it.unicam.cs.ids2021.consegne.Posizione;
import it.unicam.cs.ids2021.utenti.Cassieri;

import java.util.*;

public class Negozi implements Negozio {
    private String nome;
    private Posizione posizione;
    private Map <Prodotto,Integer> mapProdotti;
    private Set<CategorieProdotti> categorie;
    private Set<Cassieri> setCassieri;

    //Costruttore----------------------------------------------
    public Negozi(String nome, Posizione posizione) {
        this.nome = nome;
        this.posizione = posizione;
        this.categorie = null;
        this.mapProdotti = new HashMap<>();
        this.setCassieri = new HashSet<>();
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

    public Set<Cassieri> getSetCassieri() {
        return setCassieri;
    }

}

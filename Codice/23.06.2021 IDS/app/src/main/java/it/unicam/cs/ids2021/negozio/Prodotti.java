package it.unicam.cs.ids2021.negozio;
import java.util.Objects;

public class Prodotti implements Prodotto {
    private String id;
    private String nome;
    private double prezzo;
    private CategorieProdotti categoria;
    private double volume;

    // costruttore------------------------------------------------------------------------------------------
    public Prodotti(String id, String nome, double prezzo, CategorieProdotti categoria,double volume) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.volume = volume;
    }

    // toString & equals & hashCode ----------------------------------------------

    @Override
    public String toString() { return this.id + ", " + this.nome + ", " + this.prezzo + ", " + this.categoria + "\n"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotti prodotti = (Prodotti) o;
        return id.equals(prodotti.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    //Getters & Setters ----------------------------------------------------------
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public double getPrezzo() { return prezzo; }

    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public double getVolume() { return volume; }

    public void setVolume(double volume) { this.volume = volume; }

    public CategorieProdotti getCategoria() { return categoria; }

    public void setCategoria(CategorieProdotti categoria) { this.categoria = categoria; }

}

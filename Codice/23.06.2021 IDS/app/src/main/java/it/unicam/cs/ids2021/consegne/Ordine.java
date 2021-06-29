package it.unicam.cs.ids2021.consegne;
import it.unicam.cs.ids2021.negozio.Prodotto;
import java.util.Map;

public interface Ordine {
    public String getIdOrdine();
    public Map<Prodotto, Integer> getMapProdotti();
    public void setIdOrdine(String idOrdine);
    public double volumeOrdine();
    public boolean containsProdotto(Prodotto p);
    public void aggiungiProdotto(Prodotto p, int quantita);
}

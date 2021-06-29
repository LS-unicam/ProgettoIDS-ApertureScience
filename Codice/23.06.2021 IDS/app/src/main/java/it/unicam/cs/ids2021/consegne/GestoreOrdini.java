package it.unicam.cs.ids2021.consegne;
import it.unicam.cs.ids2021.negozio.Prodotto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestoreOrdini implements GestoreOrdiniI,OrdineCreator{

    private Set<Ordine> setOrdine;
    private Set<Pacco> setPacco;

    //costruttore gestore ordini----------------------------------
    public GestoreOrdini(Set<Ordine> setOrdine) {
        this.setOrdine = setOrdine;
        this.setPacco = setPacco; }

    //creaOrdine-------------------------------------------------
    @Override
    public Ordine creatOrdine(Map<Prodotto,Integer> mapProdotti) {
        return new Ordini(mapProdotti);
    }

    //Altri metodi------------------------------------------------
    List<Dimensione> listaDim = new ArrayList<>();

    /** Stabilisce le dimensioni ottimali dei pacchi
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
     * @param p
     * @param quantita
     */
    public void aggiungiProdotto(Ordine o,Prodotto p,int quantita) {
        if(o.containsProdotto(p)==false){o.aggiungiProdotto(p,quantita);}
            o.getMapProdotti().computeIfPresent(p, (k, v) -> v +=quantita);
    }






}


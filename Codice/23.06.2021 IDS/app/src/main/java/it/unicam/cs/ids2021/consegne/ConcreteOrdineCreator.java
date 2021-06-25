package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;

import java.util.Map;

public class ConcreteOrdineCreator implements OrdineCreator {
    @Override
    public Ordine creatOrdine(Map<Prodotto,Integer> mapProdotti) {
        return new Ordini(mapProdotti);
    }
}

package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;

import java.util.Map;

public interface OrdineCreator {
    Ordine creatOrdine(Map<Prodotto,Integer> mapProdotti);
}

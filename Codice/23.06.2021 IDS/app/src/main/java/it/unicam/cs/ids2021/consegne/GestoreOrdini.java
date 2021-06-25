package it.unicam.cs.ids2021.consegne;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class GestoreOrdini implements GestoreOrdiniI {
    private Set<Ordine> setOrdine;
    private Set<Pacco> setPacco;

    //costruttore gestore ordini----------------------------------
    GestoreOrdini(Set<Ordine> setOrdine){this.setPacco=setPacco;}
    List<Dimensione> listaDim = new ArrayList<>();

    List<Dimensione>  dimensionePacco (float d){
        if(d<=10){listaDim.add(Dimensione.PICCOLO);}
        if(d<=20){listaDim.add(Dimensione.MEDIO);}
        if(d<=30){listaDim.add(Dimensione.GRANDE);}
        else{ listaDim.add(Dimensione.GRANDE) ;
            dimensionePacco(d-30);}
        return listaDim;}

    //void aggiungiProdotto (Pacco pacco,Prodotti prodotto) {}
    void modificaDimensione (Pacchi pacco, String dimensione) {
        if(dimensione.toUpperCase().equals(Dimensione.GRANDE.toString())||
                dimensione.toUpperCase().equals(Dimensione.MEDIO.toString())||
                dimensione.toUpperCase().equals(Dimensione.PICCOLO.toString())){
            pacco.setDimensione(Dimensione.valueOf(dimensione.toUpperCase()));
        }
    }
    void modificaStato (Pacchi pacco,String stato) {
        if(stato.toUpperCase().equals(StatoPacco.IN_PREPARAZIONE)||
                stato.toUpperCase().equals(StatoPacco.RITIRATO)||
                stato.toUpperCase().equals(StatoPacco.SPEDITO)){
            pacco.setStato(StatoPacco.valueOf(stato.toUpperCase()));
        }
    }

    /**
     *
     * @param listaProdotti
     * @return

    Dimensione calcolaDimensione (List<Prodotti> listaProdotti) { //prende in input le dimesioni e calcola in che range è
    if(listaProdotti.size()<=5)
    return Dimensione.PICCOLO;
    if(listaProdotti.size()>=20)
    return Dimensione.GRANDE;
    return  Dimensione.MEDIO;
    }*/
}
package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.Prodotto;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Ordini implements Ordine {
    private String idOrdine;
    private Map<Prodotto,Integer> mapProdotti;//map<Prodotti, quantita>
    private LocalDate data;
    private Set<Pacco> setPacchi; // set

    // Costruttore---------------------------------------------------------
    public Ordini (Map<Prodotto,Integer> mapProdotti) {
        this.mapProdotti = Ordini.this.mapProdotti;
        this.data = LocalDate.now();
        this.setPacchi=null;
        this.idOrdine=null; }

    //equals & hashcode----------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordini ordini = (Ordini) o;
        return idOrdine.equals(ordini.idOrdine);
    }

    @Override
    public int hashCode() { return Objects.hash(idOrdine); }

    //Getters & Setters-----------------------------------------------------
    @Override
    public String getIdOrdine() { return idOrdine; }

    @Override
    public void setIdOrdine(String idOrdine){this.idOrdine=idOrdine; }

    @Override
    public Map<Prodotto,Integer> getMapProdotti() { return mapProdotti; }

    public Set<Pacco> getSetPacchi() { return setPacchi; }

    public LocalDate getData() { return data; }

    //Altri metodi---------------------------------------------------------
    public float  volumeOrdine() {
        float count=0;
        for(Map.Entry<Prodotto, Integer> coppia: this.getMapProdotti().entrySet())
            count+=coppia.getKey().getVolume()* coppia.getValue();
        return count;
    }



    /* public static void addProdotto (List<Prodotto> listaProdottiP, String miao) {
        Prodotto ciccino = new Prodotti(miao,"NULL",0, CategorieProdotti.ALIMENTARI);
        listaProdottiP.add(ciccino);
        listaProdottiP.forEach(name -> System.out.println(name));
    }

    public void addProdotto2 (String miao) {
        Prodotti ciccino = new Prodotti(miao);
        listaProdotti.add(ciccino);
        listaProdotti.forEach(name -> System.out.println("hai aggiunto" + " " + name.toString()));
    }

    public void stampList() {
        listaProdotti.forEach((n) -> System.out.println(n));
    }
*/
}

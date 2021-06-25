package it.unicam.cs.ids2021.consegne;

public class Pacchi implements Pacco {
    private int id; //numero progressivo
    private String partenza; //negozio
    private String destinazione; // locker
    private StatoPacco stato;
    private Dimensione dimensione;

    public Pacchi(String partenza, String destinazione, StatoPacco stato) {
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.stato = stato;
        this.dimensione = dimensione;
    }

/*
    public Pacchi (ArrayList <Prodotti> listaProdotti, String negozioPartenza, String lockerDestinazione, StatoPacco stato, Dimensione dimensione) {
        idPacco++;
        this.listaProdotti = listaProdotti;
        this.negozioPartenza = negozioPartenza;
        this.lockerDestinazione = lockerDestinazione;
        this.stato = stato;
        this.dimensione = dimensione; }

    public ArrayList<Prodotti> getListaProdotti() {
        return listaProdotti;
    }
    public void setListaProdotti(ArrayList<Prodotti> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }*/

    public int getIdPacco() {
        return id;
    }

    public String getNegozioPartenza() {
        return partenza;
    }

    public void setNegozioPartenza(String negozioPartenza) {
        this.partenza = negozioPartenza;
    }

    public String getLockerDestinazione() {
        return destinazione;
    }

    public void setLockerDestinazione(String lockerDestinazione) {
        this.destinazione = lockerDestinazione;
    }

    public StatoPacco getStato() {
        return stato;
    }

    public void setStato(StatoPacco stato) {
        this.stato = stato;
    }

    public Dimensione getDimensione() {
        return dimensione;
    }

    public void setDimensione(Dimensione dimensione) {
        this.dimensione = dimensione;
    }


}

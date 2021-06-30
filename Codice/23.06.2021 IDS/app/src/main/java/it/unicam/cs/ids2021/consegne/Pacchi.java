package it.unicam.cs.ids2021.consegne;

import java.util.Objects;

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

    //Equals & HashCode--------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacchi pacchi = (Pacchi) o;
        return id == pacchi.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

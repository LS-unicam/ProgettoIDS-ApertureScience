package it.unicam.cs.ids2021.locker;

import it.unicam.cs.ids2021.consegne.Dimensione;

public interface Armadietto {

    public String getId();
    public void setPassword(int password);
    public boolean isBloccato();
    public boolean isVuoto();
    public Dimensione getDimensione();
    public void setDimensione(Dimensione dimensioneArmadietto);
}

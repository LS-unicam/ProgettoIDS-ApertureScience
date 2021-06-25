package it.unicam.cs.ids2021.locker;

import it.unicam.cs.ids2021.consegne.Dimensione;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Locker implements LockerI {

    private String posizione;
    private String idLocker;
    private List<Armadietto> listaArmadietti;

    public Locker(String posizione, String idLocker, List<Armadietto> listaArmadietti) {
        this.posizione = posizione;
        this.idLocker = idLocker;
        this.listaArmadietti = listaArmadietti;
    }

    public Locker(String posizione, String idLocker) {
        this.posizione = posizione;
        this.idLocker = idLocker;
        this.listaArmadietti = new ArrayList<Armadietto>();
        for (int i = 0; i < 10; i++) {
            listaArmadietti.add(new Armadietti(this.idLocker + String.valueOf(i), Dimensione.PICCOLO));
        }
        for (int i = 10; i < 15; i++) {
            listaArmadietti.add(new Armadietti(this.idLocker + String.valueOf(i), Dimensione.MEDIO));
        }
        for (int i = 15; i < 20; i++) {
            listaArmadietti.add(new Armadietti(this.idLocker + String.valueOf(i), Dimensione.GRANDE));
        }
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public String getIdLocker() {
        return idLocker;
    }

    public void setIdLocker(String idLocker) {
        this.idLocker = idLocker;
    }

    public List<Armadietto> getListaArmadietti() {
        return listaArmadietti;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locker locker = (Locker) o;
        return idLocker.equals(locker.idLocker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocker);
    }
}

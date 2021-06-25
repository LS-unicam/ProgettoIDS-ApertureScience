package it.unicam.cs.ids2021.locker;
import it.unicam.cs.ids2021.consegne.Dimensione;
import java.util.Objects;

public class Armadietti implements Armadietto {
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armadietti that = (Armadietti) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private int password;
    private boolean bloccato;
    private boolean vuoto;
    private boolean funzionante;
    private Dimensione dimensioneArmadietto;

    public Armadietti(String id, Dimensione dimensioneArmadietto) {
        this.id = id;
        this.password = 0;
        this.bloccato = true;
        this.vuoto = true;
        this.funzionante = true;
        this.dimensioneArmadietto = dimensioneArmadietto;
    }

    public String getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public boolean isVuoto() {
        return vuoto;
    }

    public void setVuoto(boolean vuoto) {
        this.vuoto = vuoto;
    }

    public Dimensione getDimensione() {return dimensioneArmadietto;}
    public void setDimensione(Dimensione dimensioneArmadietto) {
        this.dimensioneArmadietto = dimensioneArmadietto;
    }

}
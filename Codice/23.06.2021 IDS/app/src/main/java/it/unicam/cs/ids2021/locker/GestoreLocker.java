package it.unicam.cs.ids2021.locker;

import it.unicam.cs.ids2021.consegne.Ordine;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class GestoreLocker implements GestoreLockerI {

    private List<LockerI> listaLocker;

    //costruttore
    public GestoreLocker(List<LockerI> listaLocker) {
        this.listaLocker = listaLocker;
    }

    //Getter & Setter ------------------------------------------------------------------------

    public List<LockerI> getListaLocker() {
        return this.listaLocker;
    }
    public void setListaLocker(List<LockerI> listaLocker) {
        this.listaLocker = listaLocker;
    }


    public int generaPassword() {
        int temp = Integer.parseInt(RandomStringUtils.randomNumeric(8, 8));
        for (LockerI l : this.listaLocker) {
            for (Armadietto a : l.getListaArmadietti()) {
                if (a.getPassword()==temp) generaPassword();
            }
        }
        return temp;
    }


    // predicate and stream --------------------------------------------------------------
    public static Predicate<Armadietto> armadiettiLiberi() {
        return p -> !p.isVuoto();
    }

    public static Predicate<Armadietto> armadiettiAperto() {
        return p -> !p.isBloccato();
    }

    public List<Armadietto> mostraArmadietti(LockerI locker, Predicate<Armadietto> p) {
        return locker.getListaArmadietti().stream().filter(p).collect(Collectors.<Armadietto>toList());
    }

    /**
     * Aggiunge il locker alla lista dei locker.
     *
     * @param locker Locker
     * @throws IllegalArgumentException se il locker che si vuole aggiungere e' uguale ad un locker già presente
     */
    public void aggiungiLocker(LockerI locker) throws IllegalArgumentException {
        for (int i = 0; i < listaLocker.size(); i++) {
            if (locker.equals(listaLocker.get(i)))
                throw new IllegalArgumentException("Esiste già un locker con questo codice identificativo.\n");
        }
        this.listaLocker.add(locker);
    }

    /**
     * Aggiunge l'armadietto nel locker in cui si vuole aggiungere un nuovo armadietto.
     *
     * @param armadietto Armadietti
     * @param locker     Locker
     */
    public void aggiungiArmadietto(Armadietto armadietto, LockerI locker) {
        for (int i = 0; i < locker.getListaArmadietti().size(); i++) {
            if (locker.equals(locker.getListaArmadietti().get(i)))
                throw new IllegalArgumentException("Esiste già un armadietto con questo codice identificativo.\n");
        }
        locker.getListaArmadietti().add(armadietto);
    }

    /**
     * Elimina il locker di cui viene fornito l'id.
     *
     * @param id : String
     * @throws IllegalArgumentException : se L'id inserito non corrisponde a nessun locker
     */
    public void rimuoviLocker(String id) throws IllegalArgumentException {
        if (!cercaLocker(id)) throw new IllegalArgumentException
                ("Il codice identificativo immesso non corrisponde a nessun locker.\n" +
                        "Il locker da rimuovere non e' stato eliminato.");
        for (int i = 0; i < listaLocker.size(); i++) {
            if (listaLocker.get(i).getIdLocker().equals(id)) {
                listaLocker.remove(i);
            }
        }
    }

    /**
     * Viene rimosso l'armadietto di cui e' indicata il codice identificativo
     *
     * @param id String
     * @throws IllegalArgumentException se l'id immesso non corrisponde a nessuno armadietto
     */
    public void rimuoviArmadietto(String id) throws IllegalArgumentException {
        if (!cercaArmadietto(id)) throw new IllegalArgumentException
                ("Il codice identificativo immesso non corrisponde a nessun locker.\n" +
                        "Il locker da rimuovere non e' stato eliminato.");
        for (int i = 0; i < listaLocker.size(); i++) {
            for (int j = 0; j < listaLocker.get(i).getListaArmadietti().size(); j++) {
                if (listaLocker.get(i).getListaArmadietti().get(j).getId().equals(id)) {
                    listaLocker.get(i).getListaArmadietti().remove(j);
                }
            }
        }
    }

    /**
     * Cerca se il locker è contenuto nella lista dei locker o meno
     *
     * @param id
     * @return Boolean:True se il locker è stato trovato,
     * False altrimenti
     */
    public boolean cercaLocker(String id) {
        boolean temp = false;
        for (int i = 0; i < listaLocker.size(); i++) {
            if (listaLocker.get(i).getIdLocker().equals(id)) {
                temp = true;
            }
        }
        if (!temp) return false; // se temp è false
        else return true;
    }

    /**
     * Cerca l'armadietto è presente nel locker fornito
     *
     * @param id     String
     * @param locker Locker
     * @return Boolean: True se è presente
     * False se non è presente
     * @throws IllegalArgumentException se il locker fornito non è presente nella lista dei locker
     */
    public boolean cercaArmadietto(String id, LockerI locker) throws IllegalArgumentException {
        if (listaLocker.contains(locker)) throw new IllegalArgumentException("Il Locker non è presente.");
        boolean temp = false;
        for (int i = 0; i < locker.getListaArmadietti().size(); i++) {
            if (locker.getListaArmadietti().get(i).getId().equals(id)) {
                temp = true;
            }
        }
        if (!temp) return false; // se temp è false
        else return true;
    }

    /**
     * Cerca l'armadietto di cui viene fornito l'id.
     *
     * @param id
     * @return Boolean: True se l'ha trovato, False altrimenti
     */
    public boolean cercaArmadietto(String id) {
        boolean trovato = false;
        for (int i = 0; i < listaLocker.size(); i++)
            if (cercaArmadietto(id, listaLocker.get(i))) trovato = true;
        if (trovato) return true;
        return false;
    }

}
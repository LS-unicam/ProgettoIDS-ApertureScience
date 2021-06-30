package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.utenti.Corrieri;
import it.unicam.cs.ids2021.utenti.StatoCorriere;

public interface GestoreCorrieriI {
    void aggiungiConsegna(Ordine o, Corrieri c);
    void aggiornaPosizione(Corrieri c , Posizione p);
    void setStatoCorriere(StatoCorriere sc);
}

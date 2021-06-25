package it.unicam.cs.ids2021.utenti;
import it.unicam.cs.ids2021.consegne.Pacco;
import java.util.Set;

public class Corrieri implements Impiegato{
    String nome;
    String cognome;
    String email;
    Set<Pacco> setPacchi;

    //Costruttore---------------------------------------------------
    public Corrieri (String nome, String cognome, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
    }

    //Getters and Setters-------------------------------------------
    @Override
    public String getNome() {return this.nome;}

    @Override
    public void setNome(String nome) {this.nome= nome;}

    @Override
    public String getCognome() {return this.cognome;}

    @Override
    public void setCognome(String cognome) {this.cognome=cognome;}

    @Override
    public String getEmail() {return this.email;}

    @Override
    public void setEmail(String email) {this.email=email;}
}

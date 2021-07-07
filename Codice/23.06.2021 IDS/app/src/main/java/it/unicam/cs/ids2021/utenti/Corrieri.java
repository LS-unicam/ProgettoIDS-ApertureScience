package it.unicam.cs.ids2021.utenti;
import it.unicam.cs.ids2021.consegne.Pacco;
import java.util.Set;

public class Corrieri implements Corriere{
    String nome;
    String cognome;
    String email;
    Set<Pacco> setPacchi;
    StatoCorriere statoCorriere; // CREA GETTER E SETTER


    //Costruttore---------------------------------------------------
    public Corrieri (String nome, String cognome, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.statoCorriere= StatoCorriere.LIBERO;
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

    public Set<Pacco> getSetPacchi() {
        return setPacchi;
    }

    public void setSetPacchi(Set<Pacco> setPacchi) {
        this.setPacchi = setPacchi;
    }

    public StatoCorriere getStatoCorriere() { return statoCorriere; }

    public void setStatoCorriere(StatoCorriere statoCorriere) {this.statoCorriere = statoCorriere; }

}



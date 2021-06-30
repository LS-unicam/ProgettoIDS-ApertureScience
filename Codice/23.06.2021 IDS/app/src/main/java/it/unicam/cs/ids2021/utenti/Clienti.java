package it.unicam.cs.ids2021.utenti;

public class Clienti implements Cliente {
    String nome;
    String cognome;
    String email;

    //Costruttore--------------------------------------------------
    public Clienti(String nome, String cognome, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
    }

    //Getters and Setters------------------------------------------
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

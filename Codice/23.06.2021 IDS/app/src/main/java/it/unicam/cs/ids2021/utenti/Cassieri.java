package it.unicam.cs.ids2021.utenti;
import it.unicam.cs.ids2021.negozio.Negozi;
import it.unicam.cs.ids2021.negozio.Negozio;

public class Cassieri implements Cassiere {
    String nome;
    String cognome;
    String email;
    Negozio negozio;

    //Costruttore---------------------------------------------------
    public Cassieri(String nome, String cognome, String email, Negozio negozio){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.negozio= negozio;
    }

    //Getters and Setters-------------------------------------------

    public String getNome() {return this.nome;}

    public void setNome(String nome) {this.nome= nome;}

    public String getCognome() {return this.cognome;}

    public void setCognome(String cognome) {this.cognome=cognome;}

    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email=email;}

    @Override
    public Negozio getNegozio() { return negozio; }

    public void setNegozio(Negozio n) {this.negozio=n;}

}

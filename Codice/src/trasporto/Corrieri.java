package trasporto;

import pacco.*;
import java.util.*;

public class Corrieri {
	String nome;
	String cognome;
	String email;
	ArrayList <Pacchi> pic; //Pacchi in conegna
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNomeNegozio() {
		return email;
	}
	
	public void setPic(ArrayList <Pacchi> pic) {
		this.pic = pic;
	}
	
	public ArrayList <Pacchi> getPic() {
		return pic;
	}
	
}

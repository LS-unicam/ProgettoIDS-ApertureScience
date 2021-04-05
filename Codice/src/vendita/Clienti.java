package vendita;

public class Clienti {
	private String nome;
	private String cognome;
	private String email;
	
	public Clienti (String inome, String icognome, String iemail) {
		this.nome = inome;
		this.cognome = icognome;
		this.email = iemail;
	}

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
}

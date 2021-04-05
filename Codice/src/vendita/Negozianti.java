package vendita;

public class Negozianti {
	private String nome;
	private String cognome;
	private String email;
	private String nomeNegozio;
	
	public Negozianti (String nome, String cognome, String email, String nomeNegozio) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.nomeNegozio = nomeNegozio;
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
	
	public String getNomeNegozio() {
		return email;
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}
}
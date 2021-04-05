package vendita;


public class Prodotti {
	private String id;
	private String nome;
	private float prezzo;
	private CategorieProdotti Categoria;
	
	public Prodotti(String id, String nome, float prezzo) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	public Prodotti(String id, String nome, float prezzo, CategorieProdotti categoria) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		Categoria = categoria;
	}

	public Prodotti (String nome){
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public CategorieProdotti getCategoria() {
		return Categoria;
	}
	
	public void setCategoria(CategorieProdotti categoria) {
		Categoria = categoria;
	}
	
	@Override
	public String toString() {
		return this.id + ", " + this.nome + ", " + this.prezzo + ", " + this.Categoria + "\n";
	}

	public boolean myEquals (String idEsterno) {
		if(this.id == idEsterno) {
			return true;
		}
		return false;
	}
}

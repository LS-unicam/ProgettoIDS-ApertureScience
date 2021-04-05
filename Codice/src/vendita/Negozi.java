package vendita;

import java.util.*;

public class Negozi {
	private String nome;
	private String posizione;
	private ArrayList <CategorieProdotti> categorie;
	private ArrayList <Prodotti> listaProdotti;
	
	public Negozi(String nome, String posizione, ArrayList<CategorieProdotti> categorie) {
		this.nome = nome;
		this.posizione = posizione;
		this.categorie = categorie;
		this.listaProdotti = new ArrayList<Prodotti>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPosizione() {
		return posizione;
	}
	
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	public List<CategorieProdotti> getCategorie() {
		return categorie;
	}
	
	public void setCategorie(ArrayList<CategorieProdotti> categorie) {
		this.categorie = categorie;
	}
	
	public ArrayList<Prodotti> getListaProdotti() {
		return listaProdotti;
	}
	
	public void setListaProdotti(ArrayList<Prodotti> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	
}

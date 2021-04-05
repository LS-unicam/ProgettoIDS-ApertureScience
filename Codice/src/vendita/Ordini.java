package vendita;

import java.time.*;
import java.util.*;
import pacco.*;

public class Ordini {
	
	private int idOrdine = 0; //numero ordini totale effettuati da un singolo negozio
	private ArrayList <Prodotti> lista;
	private LocalDate data;
	private Pacchi pacco;
	
	public Ordini (ArrayList <Prodotti> lista) {
		idOrdine++;
		this.lista = lista;
		this.data = LocalDate.now();
	}
	
	public int getIdOrdine() {
		return idOrdine;
	}

	public List<Prodotti> getLista() {
		
		return lista;
	}

	public void setLista(ArrayList <Prodotti> lista) {
		this.lista = lista;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Pacchi getPacco() {
		return pacco;
	}

	public void setPacco(Pacchi pacco) {
		this.pacco = pacco;
	}

	public static void addProdotto (ArrayList<Prodotti> listaP, String miao) {
		Prodotti ciccino = new Prodotti(miao);
		listaP.add(ciccino);
		listaP.forEach(name -> System.out.println(name));
	}
	
	public void addProdotto2 (String miao) {
		Prodotti ciccino = new Prodotti(miao);
		lista.add(ciccino);
		lista.forEach(name -> System.out.println("hai aggiunto" + " " + name.toString()));
	}
	
	public void stampList() {
		 lista.forEach((n) -> System.out.println(n));
	}
	
}

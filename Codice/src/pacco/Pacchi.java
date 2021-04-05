package pacco;

import java.util.*;
import vendita.Prodotti;

public class Pacchi {
	private int idPacco; //numero progressivo
	private ArrayList <Prodotti> listaProdotti;
	private String negozioPartenza;
	private String lockerDestinazione;
	private StatoPacco stato;
	private DimensionePacco dimensione;
	
	public Pacchi (ArrayList <Prodotti> listaProdotti, String negozioPartenza, String lockerDestinazione, StatoPacco stato, DimensionePacco dimensione) {
		idPacco++;
		this.listaProdotti = listaProdotti;
		this.negozioPartenza = negozioPartenza;
		this.lockerDestinazione = lockerDestinazione;
		this.stato = stato;
		this.dimensione = dimensione;
	}

	public int getIdPacco() {
		return idPacco;
	}

	public ArrayList<Prodotti> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(ArrayList<Prodotti> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public String getNegozioPartenza() {
		return negozioPartenza;
	}

	public void setNegozioPartenza(String negozioPartenza) {
		this.negozioPartenza = negozioPartenza;
	}

	public String getLockerDestinazione() {
		return lockerDestinazione;
	}

	public void setLockerDestinazione(String lockerDestinazione) {
		this.lockerDestinazione = lockerDestinazione;
	}

	public StatoPacco getStato() {
		return stato;
	}

	public void setStato(StatoPacco stato) {
		this.stato = stato;
	}

	public DimensionePacco getDimensione() {
		return dimensione;
	}

	public void setDimensione(DimensionePacco dimensione) {
		this.dimensione = dimensione;
	}
	
	
}

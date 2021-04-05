package locker;

import java.util.*;

import pacco.DimensionePacco;

public class Locker {
	private int nArmadietti;
	private String posizione;
	private String idLocker;
	private ArrayList<Armadietti> listaArmadietti;

	public Locker (String posizione, String idLocker, ArrayList<Armadietti> listaArmadietti) {
		this.nArmadietti = 20;
		this.posizione = posizione;
		this.idLocker = idLocker;
		this.listaArmadietti = listaArmadietti;
	}
	
	public Locker (String posizione, String idLocker) {
		this.nArmadietti = 20;
		this.posizione = posizione;
		this.idLocker = idLocker;
		this.listaArmadietti = new ArrayList<Armadietti>();
		for(int i=0; i<10; i++) {
			listaArmadietti.add(new Armadietti(this.idLocker+String.valueOf(i), DimensionePacco.PICCOLO));
		}
		for(int i=10; i<15; i++) {
			listaArmadietti.add(new Armadietti(this.idLocker+String.valueOf(i), DimensionePacco.MEDIO));
		}
		for(int i=15; i<20; i++) {
			listaArmadietti.add(new Armadietti(this.idLocker+String.valueOf(i), DimensionePacco.GRANDE));
		}
	}

	public int getnArmadietti() {
		return nArmadietti;
	}

	public void setnArmadietti(int nArmadietti) {
		this.nArmadietti = nArmadietti;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public String getIdLocker() {
		return idLocker;
	}

	public void setIdLocker(String idLocker) {
		this.idLocker = idLocker;
	}
	
	public ArrayList<Armadietti> getListaArmadietti() {
		return listaArmadietti;
	}

	public void setListaArmadietti(ArrayList<Armadietti> listaArmadietti) {
		this.listaArmadietti = listaArmadietti;
	}
	
}

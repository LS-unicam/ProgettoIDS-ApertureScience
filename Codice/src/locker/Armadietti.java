package locker;

import pacco.*;

public class Armadietti {
	private String id;
	private int password;
	private Locker lockerAssociato;
	private boolean bloccato;
	private boolean pieno;
	private DimensionePacco dimensioneArmadietto;
	
	public Armadietti(String id, DimensionePacco dimensioneArmadietto) {
		this.id = id;
		this.password = 0;
		this.lockerAssociato = null; //da rivedere
		this.bloccato = true; 
		this.pieno = false;
		this.dimensioneArmadietto = dimensioneArmadietto;
	}

	public String getId() {
		return id;
	}
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Locker getLockerAssociato() {
		return lockerAssociato;
	}

	public void setLockerAssociato(Locker lockerAssociato) {
		this.lockerAssociato = lockerAssociato;
	}

	public boolean isBloccato() {
		return bloccato;
	}

	public void setBloccato(boolean bloccato) {
		this.bloccato = bloccato;
	}

	public boolean isPieno() {
		return pieno;
	}

	public void setPieno(boolean pieno) {
		this.pieno = pieno;
	}

	public DimensionePacco getDimensioneArmadietto() {
		return dimensioneArmadietto;
	}

	public void setDimensioneArmadietto(DimensionePacco dimensioneArmadietto) {
		this.dimensioneArmadietto = dimensioneArmadietto;
	}
	
}
package locker;

import java.util.*;

public class GestoreLocker {
	
	public void cambiaBloccato (Armadietti sportello) {
		if(sportello.isBloccato()) {
			sportello.setBloccato(false);
		}
		else {
			sportello.setBloccato(true);
		}
	}
	
	public void cambiaPieno (Armadietti sportello) {
		if(sportello.isPieno()) {
			sportello.setPieno(false);
		}
		else {
			sportello.setPieno(true);
		}
	}
	
	public void assegnaPassword (Armadietti sportello) {
		Random rn = new Random();
		int p = rn.nextInt(999998 - 100001 + 1) + 100001;
		
		while(p==111111 || p==222222 || p==333333 || p==444444 || p==555555 || p==666666 || p==777777 || p==888888) {
			p = rn.nextInt(999998 - 100001 + 1) + 100001;
		}

		sportello.setPassword(p);
	}
	
	//Armadietti liberi
	public ArrayList<Armadietti> mostraLiberi (Locker locker) {
		ArrayList<Armadietti> listaLiberi = new ArrayList<Armadietti>();
		for (Armadietti miao : locker.getListaArmadietti()) {
			if(!miao.isPieno()) {
				listaLiberi.add(miao);
			}
		}
		return listaLiberi;
	}
	
	//Armadietti sbloccati
		public ArrayList<Armadietti> mostraSbloccati (Locker locker) {
			ArrayList<Armadietti> listaSbloccati = new ArrayList<Armadietti>();
			for (Armadietti miao : locker.getListaArmadietti()) {
				if(!miao.isBloccato()) {
					listaSbloccati.add(miao);
				}
			}
			return listaSbloccati;
		}
}

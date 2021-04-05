package vendita;

import java.util.*;

public class GestoreVendite {
	
	
	public static Ordini creaOrdine (ArrayList <Prodotti> lista) {
		Ordini a = new Ordini(lista);
		return a;
	}
	
	void stampaRicevuta () {
		
	}
	
	float calcolaTotale (ArrayList <Prodotti> p) {         
		float tot = 0;         
		for (int i = 0 ; i < p.size (); i++){             
			tot += (p.get(i).getPrezzo());         
		}         
		return tot;
	}
}

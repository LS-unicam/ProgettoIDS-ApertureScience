package userinterface;

//import java.io.*;
import java.util.*;

import locker.Armadietti;
import vendita.*;

public class Console implements UI {
	
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		ArrayList <CategorieProdotti> listaCategorie = new ArrayList <CategorieProdotti>();
		listaCategorie.add(CategorieProdotti.ALIMENTARI);
		listaCategorie.add(CategorieProdotti.CURA_PERSONALE);
		listaCategorie.add(CategorieProdotti.PULIZIE);
		listaCategorie.add(CategorieProdotti.CANCELLERIA);
		listaCategorie.add(CategorieProdotti.VESTIARIO);
		
		Negozi market = new Negozi("FrescoMarket","Viale Trento",listaCategorie);
	
		System.out.println("Premere un numero per:");
		System.out.println("1 inserire un prodotto al database");
		System.out.println("2 modificare un prodotto");
		System.out.println("3 stampa prodotti");
		System.out.println("4 cancellare un prodotto dal database");
		System.out.println("5 creare un nuovo ordine");
		System.out.println("6 stampare lo scontrino");
		System.out.println("7 modificare un ordine");
		System.out.println("8 annullare un ordine");
		System.out.println("0 per uscire");

		int n;
		boolean exit=false;
		
		do{
			n = scan.nextInt();
			if(n>8 || n<0) {
				System.out.println("Il numero inserito non è valido. Inserire un altro numero: ");
			}
			switch(n) {
				case 0:
					exit=true;
					System.exit(0);
				break;
				case 1:
					scan.nextLine();//serve per consumare il carattere "\n"
					
					System.out.println("Inserire id: ");
					String idA = scan.nextLine();
					
					System.out.println("Inserire nome: ");
					String nomeA = scan.nextLine();
					
					System.out.println("Inserire prezzo: ");
					float prezzoA = scan.nextFloat();
					
					Prodotti prodA = new Prodotti(idA,nomeA,prezzoA);
					
					System.out.println("Scegliere numero associato alla categoria:");
					System.out.println("1 ALIMENTARI");
					System.out.println("2 CURA_PERSONALE");
					System.out.println("3 PULIZIE");
					System.out.println("4 CANCELLERIA");
					System.out.println("5 VESTIARIO");
					int catA = scan.nextInt();
					
					switch(catA) {
						case 1:
							prodA.setCategoria(CategorieProdotti.ALIMENTARI);
							break;
						case 2:
							prodA.setCategoria(CategorieProdotti.CURA_PERSONALE);
							break;
						case 3:
							prodA.setCategoria(CategorieProdotti.PULIZIE);
							break;
						case 4:
							prodA.setCategoria(CategorieProdotti.CANCELLERIA);
							break;
						case 5:
							prodA.setCategoria(CategorieProdotti.VESTIARIO);
							break;
					}
					market.getListaProdotti().add(prodA);
					System.out.println(prodA.toString());
					break;
				case 2:
					System.out.println("modifica prodotto in fase di implementazione");
					break;
				case 3:
					for (Prodotti prodAp : market.getListaProdotti()) {
						System.out.println(prodAp.toString());
					}
					break;
				case 4:
					scan.nextLine();//serve per consumare il carattere "\n"
					System.out.println("Inserire id del prodotto che si vuole cancellare");
					String temp = scan.nextLine();
					for (int i=0; i<market.getListaProdotti().size(); i++) {
						if(market.getListaProdotti().get(i).getId().equals(temp)) {
							market.getListaProdotti().remove(i);
						}
					}
					break;
				case 5:
					System.out.println("in fase di implementazione");
					break;
				case 6:
					System.out.println("in fase di implementazione");
					break;
				case 7:
					System.out.println("in fase di implementazione");
					break;
				case 8:
					System.out.println("in fase di implementazione");
					break;
			}
		}
		while(n<=8 || n>=0 && !exit);
		scan.close();
	}
	
	/*
	public static String getIn() {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		String in = sc.nextLine();
		sc.close();
		return in;
	}

	static public Ordini askProd(Ordini ord) {
		System.out.println("Che prodotto aggiunge?");
		System.out.println("Esci con 0");
		String inpu = getIn();

		if (inpu != "0") {
			ord.addProdotto2(inpu);
			askProd(ord);
		}
		else {
			ord.stampList();
		}
		return ord;
	}

	static public Ordini inputProd() {
		System.out.println("Immetta un numero");
		String inp = getIn();

		switch (inp) {
			case "0":
				System.out.println("Grazie, arriverci");
				break;
	
			case "1":
				Ordini ord = vendita.GestoreVendite.creaOrdine(new ArrayList<Prodotti>());
				askProd(ord);
				break;
	
			default:
				System.out.println("\nNon va bene");
				inputProd();
				break;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(" //**  IMMETTA UN NUMERO **\\ ");
		System.out.println(" 1 Per iniziare un ordine ");
		System.out.println(" 0 Per uscire ");
		Ordini andrea = inputProd();
	}*/
}
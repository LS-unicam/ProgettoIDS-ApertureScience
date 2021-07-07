package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.CategorieProdotti;
import it.unicam.cs.ids2021.negozio.Prodotti;
import it.unicam.cs.ids2021.negozio.Prodotto;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestoreOrdiniTest extends TestCase {

    Prodotto a = new Prodotti("1", "Pasta", 1.0, CategorieProdotti.ALIMENTARI, 1);
    Prodotto b = new Prodotti("2", "Pomodoro", 2.0, CategorieProdotti.ALIMENTARI, 1);
    Prodotto c = new Prodotti("3", "Gonna", 30.50, CategorieProdotti.VESTIARIO, 1);
    Prodotto d = new Prodotti("4", "Aspirapolvere", 138.90, CategorieProdotti.ELETTRONICA, 1);
    Prodotto e = new Prodotti("4", "Giocattoli", 138.90, CategorieProdotti.GIOCHI, 1);
    Prodotto f = new Prodotti("5", "Giocattoli", 138.90, CategorieProdotti.GIOCHI, 1);

    public Map<Prodotto, Integer> creaMappaProdottiA() {
        Map<Prodotto, Integer> map = new HashMap<>();
        map.put(a, 2);
        map.put(b, 2);
        map.put(c, 2);
        map.put(d, 2);
        return map;
    }
    public Map<Prodotto, Integer> creaMappaProdottiB() {
        Map<Prodotto, Integer> map = new HashMap<>();
        map.put(d, 3);
        map.put(b, 3);
        map.put(f, 3);
        return map;
    }
    public Map<Prodotto, Integer> creaMappaProdottiC() {
        Map<Prodotto, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, 1);
        map.put(f, 4);
        return map;
    }

    Set<Ordine> setOridine = new HashSet<>();
    GestoreOrdini gO = new GestoreOrdini(setOridine);

    Ordine o1 =gO.creaOrdine(creaMappaProdottiA());
    Ordine o2 =gO.creaOrdine(creaMappaProdottiB());
    Ordine o3 =gO.creaOrdine(creaMappaProdottiC());

    public void testCreaOrdine() {
        Ordine o =gO.creaOrdine(creaMappaProdottiB());
        assertTrue(gO.containsOrdine(o.getIdOrdine()));
        assertTrue(gO.containsOrdine(o1.getIdOrdine()));
        assertTrue(gO.containsOrdine(o3.getIdOrdine()));

    }

    public void testAggiungiOrdine() {
        gO.aggiungiOrdine(o1);
        gO.aggiungiOrdine(o2);
        Ordine o4 = new Ordini(creaMappaProdottiA());
        assertFalse(gO.containsOrdine(o4.getIdOrdine()));
        assertTrue(gO.containsOrdine(o1.getIdOrdine()));
        assertTrue(gO.containsOrdine(o2.getIdOrdine()));
        assertTrue(gO.containsOrdine(o3.getIdOrdine()));
    }

    public void testEliminaOrdine() { }

    public void testCercaOrdine() {
assertTrue(gO.cercaOrdine(o1.getIdOrdine()).equals(o1));
    }

    public void testContainsOrdine() {
        Ordine o4 = new Ordini(creaMappaProdottiA());
        assertTrue(gO.containsOrdine(o1.getIdOrdine()));
        assertTrue(gO.containsOrdine(o2.getIdOrdine()));
        assertTrue(gO.containsOrdine(o3.getIdOrdine()));
        assertFalse(gO.containsOrdine(o4.getIdOrdine()));
    }

    public void testDimensionePacco() { }

    public void testAggiungiProdotto() {
        gO.aggiungiProdotto(o2,f,4);
        assertTrue(o2.getMapProdotti().containsKey(f));
        assertTrue(o2.containsProdotto(f));
        assertTrue(o2.quantitaValue(f).equals(7));
    }
}
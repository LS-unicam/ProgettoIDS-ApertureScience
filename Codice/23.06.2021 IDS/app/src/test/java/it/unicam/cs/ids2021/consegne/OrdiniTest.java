package it.unicam.cs.ids2021.consegne;

import it.unicam.cs.ids2021.negozio.CategorieProdotti;
import it.unicam.cs.ids2021.negozio.Prodotti;
import it.unicam.cs.ids2021.negozio.Prodotto;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class OrdiniTest extends TestCase {
    Prodotto a = new Prodotti("1", "Pasta", 1.0, CategorieProdotti.ALIMENTARI, 1);
    Prodotto b = new Prodotti("2", "Pomodoro", 2.0, CategorieProdotti.ALIMENTARI, 1);
    Prodotto c = new Prodotti("3", "Gonna", 30.50, CategorieProdotti.VESTIARIO, 1);
    Prodotto d = new Prodotti("4", "Aspirapolvere", 138.90, CategorieProdotti.ELETTRONICA, 1);
    Prodotto e = new Prodotti("4", "Giocattoli", 138.90, CategorieProdotti.GIOCHI, 1);
    Prodotto f = new Prodotti("5", "Giocattoli", 138.90, CategorieProdotti.GIOCHI, 1);

    public Map<Prodotto, Integer> creaMappaProdotti() {
        Map<Prodotto, Integer> map = new HashMap<>();
        map.put(a, 2);
        map.put(b, 2);
        map.put(c, 2);
        map.put(d, 2);
        return map;
    }

    Ordine o = new Ordini(creaMappaProdotti());

    public void testTestEquals() {
        assertEquals(d, e);
        assertEquals(e, d);
        assertFalse(a.equals(b));
    }

    public void testTestHashCode() {
        assertEquals(d.hashCode(), e.hashCode());
    }

    public void testVolumeOrdine() {
        Map<Prodotto,Integer> m = new HashMap<>();
        m.put(a,2);
        Ordine o1 = new Ordini(m);
        assertTrue(o1.volumeOrdine()==2.0);
        assertTrue(o.volumeOrdine()==8.0);

    }

    public void testContainsProdotto() {
        assertTrue(o.containsProdotto(a));
        assertTrue(o.containsProdotto(d));
        assertFalse(o.containsProdotto(f));
    }

    public void testAggiungiProdotto() {
        o.aggiungiProdotto(f,4);
        assertTrue(o.getMapProdotti().containsKey(f));
    }
}
package aufgabenblatt1.a3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestArrayListe {

	@Test
	public void testHinzufuegen(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufuegen(10);
		Integer test = 10;
		assertEquals(test,arrayList.get(0));
	}
	
	
	@Test
	public void testEntfernen(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufuegen(3);
		arrayList.hinzufuegen(4);
		arrayList.hinzufuegen(5);
		
		arrayList.entfernen(4);
		
		Integer test[] = {3,5};
		for(int i =0; i< arrayList.getAnzahlElemente();i++){
		assertEquals(test[i],arrayList.get(i));
		}
	}
	
	@Test
	public void testEntferneElementAnIndex(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufuegen(4);
		arrayList.hinzufuegen(6);
		arrayList.hinzufuegen(4);
		arrayList.hinzufuegen(7);
		
		arrayList.entferneElementAnIndex(2);
		
		
		Integer test[] = {4,6,7};
		for(int i =0; i< arrayList.getAnzahlElemente();i++){
		assertEquals(test[i],arrayList.get(i));
		}
	}
	
	@Test
	public void testGetAnzahlElemente(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufuegen(1);
		arrayList.hinzufuegen(2);
		arrayList.hinzufuegen(3);
		arrayList.hinzufuegen(4);
		int test = 4;
		assertEquals(test,arrayList.getAnzahlElemente());
	}
	
	@Test
	public void testGetKleinstesElement(){
		ArrayListe<Integer> arrayList = new ArrayListe<Integer>();
		arrayList.hinzufuegen(16);
		arrayList.hinzufuegen(10);
		arrayList.hinzufuegen(5);
		arrayList.hinzufuegen(8);
		
		Integer test = 5;
		assertEquals(test,arrayList.getKleinstesElement());
	}
	
	@Test
	public void testStaticTest(){
		ArrayListe<Integer> arrayList1 = new ArrayListe<Integer>();
		ArrayListe<String> arrayList2 = new ArrayListe<String>();
		arrayList1.hinzufuegen(100);
		arrayList1.hinzufuegen(18);
		arrayList2.hinzufuegen("Text");
		arrayList2.hinzufuegen("weiterer Text");
		assertFalse(ErsteElementNummer.ersteElementNummer(arrayList2));
		assertTrue(ErsteElementNummer.ersteElementNummer(arrayList1));
	}
	
}

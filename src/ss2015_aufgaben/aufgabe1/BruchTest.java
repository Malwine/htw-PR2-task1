package ss2015_aufgaben.aufgabe1;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import ss2015_aufgaben.aufgabe1.Bruch;

public class BruchTest {

	private static Bruch bruch1;
	private static Bruch bruch2;
	private static Bruch ergebnisbruch;
	private static Boolean status;
	
	@BeforeClass
	public static void erstelleBrueche() {		  
		System.out.println("Brueche erstellen...");	  
		bruch1 = new Bruch(4,16);	
		bruch2 = new Bruch(3,4);
		System.out.println("Brueche erstellt...");
		System.out.println();
	}
	
	@Before
	public void bruecheAusgeben() {	
		System.out.println("==========================");
		System.out.println("Ausgangs Brueche:");	
		bruch1.print();	
		bruch2.print();	  
		System.out.println("===");	
		System.out.println();
	}	
	
	@Test
	public void test_kuerzen() {
		System.out.println("TEST KUERZEN");
		System.out.println();
		System.out.print("4/16 gekuerzt: ");
		bruch1.kuerzen().print();
		assertTrue("4/16 gekuerzt: " + bruch1.kuerzen().zaehler, bruch1.kuerzen().zaehler == 1);
		assertTrue("4/16 gekuerzt: " + bruch1.kuerzen().nenner, bruch1.kuerzen().nenner == 4);
		
		System.out.print("3/4 gekuerzt: ");
		bruch2.kuerzen().print();
		assertTrue("3/4 gekuerzt: " + bruch2.kuerzen().zaehler, bruch2.kuerzen().zaehler == 3);
	}
	
	@Test
	public void test_plus() {
		System.out.println("TEST PLUS");
		System.out.println();
		ergebnisbruch = bruch1.plus(bruch2);
		System.out.print("Sollte Bruch(1/1) ergeben: ");
		ergebnisbruch.print();
		assertTrue("Sollte Bruch(1/1) ergeben", Bruch.sindGleich(ergebnisbruch, new Bruch(1,1)));
	}
	
	@Test
	public void test_minus() {
		System.out.println("TEST MINUS");
		System.out.println();
		ergebnisbruch = bruch2.minus(bruch1);
		System.out.print("Sollte Bruch(1/2) ergeben: ");
		ergebnisbruch.print();
		assertTrue("Sollte Bruch(1/2) ergeben", Bruch.sindGleich(ergebnisbruch, new Bruch(1,2)));
	}
	
	
	@Test
	public void test_mal() {
		System.out.println("TEST MAL");
		System.out.println();
		ergebnisbruch = bruch2.mal(bruch1);
		System.out.print("Sollte Bruch(3/16) ergeben: ");
		ergebnisbruch.print();
		assertTrue("Sollte Bruch(3/16) ergeben", Bruch.sindGleich(ergebnisbruch, new Bruch(3,16)));
	}
	
	
	@Test
	public void test_geteilt() {
		System.out.println("TEST GETEILT");
		System.out.println();
		ergebnisbruch = bruch1.geteilt(bruch2);
		System.out.print("Sollte Bruch(1/3) ergeben: ");
		ergebnisbruch.print();
		assertTrue("Sollte Bruch(1/3) ergeben", Bruch.sindGleich(ergebnisbruch, new Bruch(1,3)));
	}
	
	/* Test nicht moeglich.
	@Test
	public void test_print() {
	}
	*/
	
	@Test
	public void test_istGroesser() {
		System.out.println("TEST IST_GROESSER");
		System.out.println();
		status = Bruch.istGroesser(bruch2, bruch1);
		System.out.print("Sollte true ergeben: ");
		System.out.println(status);
		assertTrue("Sollte true ergeben:", status == true);
	}
	
	@Test
	public void test_istKleiner() {
		System.out.println("TEST IST_KLEINER");
		System.out.println();
		status = Bruch.istKleiner(bruch1, bruch2);
		System.out.print("Sollte true ergeben: ");
		System.out.println(status);
		assertTrue("Sollte true ergeben:", status == true);
	}
	
	@Test
	public void test_sindGleich() {
		System.out.println("TEST SIND_GLEICH");
		System.out.println();
		status = Bruch.sindGleich(bruch1, bruch2);
		System.out.print("Sollte false ergeben: ");
		System.out.println(status);
		assertTrue("Sollte false ergeben:", status == false);
	}
}

package ss2015_aufgaben.aufgabe1;

/**
 * @author Malwine
 * @version 2.0
 */

public class Bruch {
	
	int zaehler;
	int nenner;
	
	/**
	 * Konstruktor ohne Parameter.
	 */
	public Bruch() {
		this.zaehler = 1;
		this.nenner  = 1;
	}
	
	/**
	 * Konstruktor mit Parametern.
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner  = nenner;
	}
	
	/**
	 * Kuerzt den Bruch. 
	 * @return den gekuerzten Bruch
	 */
	public Bruch kuerzen(){
		
		Bruch result = new Bruch();
		int z = this.zaehler;
		int n = this.nenner;
		
		while (n != 0) {
			if (z > n) {
				z = z - n;
			} else {
				n = n - z;
			}
		}
		if (z > 0) {
			result.zaehler = this.zaehler/z;
			result.nenner = this.nenner/z;
		}
		return result;
	}

	/**
	 * Macht den aktuellen Bruch gleichnahmig mit dem uebergebenen Bruch. 
	 * @param b
	 * @return den aktuellen Bruch mit gleichem Nenner und angepasten Zaehler.
	 */
	public Bruch gleichnahmig(Bruch b){
		int temp_z1 = this.zaehler * b.nenner;
		int temp_z2 = b.zaehler * this.nenner;
		
		int temp_n = b.nenner * this.nenner;
		
		this.zaehler = temp_z1;
		this.nenner = temp_n;
		
		b.zaehler = temp_z2;
		b.nenner = temp_n;
		
		return this;
	}
	
	/**
	 * Addiert den aktuellen Bruch mit dem uebergebenen Bruch.
	 * @param b
	 * @return die Summe der Brueche als ein neues Bruch Objekt.
	 */
	public Bruch plus(Bruch b){
		Bruch result = new Bruch();
		result.zaehler = this.zaehler;
		result.nenner = this.nenner;
		
		if (this.nenner == b.nenner) {
			result.zaehler = this.zaehler + b.zaehler;
		}
		else {
			int temp_z1 = this.zaehler * b.nenner;
			int temp_z2 = b.zaehler * this.nenner;
			
			int temp_n = b.nenner * this.nenner;
			
			result.zaehler = temp_z1 + temp_z2;
			result.nenner = temp_n;
		}
		return result.kuerzen();
	}
	
	/**
	 * Subtrahiert den aktuellen Bruch mit dem uebergebenen Bruch.
	 * @param b
	 * @return die Differenz der Brueche als ein neues Bruch Objekt.
	 */
	public Bruch minus(Bruch b){
		Bruch result = new Bruch();
		result.zaehler = this.zaehler;
		result.nenner = this.nenner;
		
		if (this.nenner == b.nenner) {
			result.zaehler = this.zaehler - b.zaehler;
		}
		else {
			int temp_z1 = this.zaehler * b.nenner;
			int temp_z2 = b.zaehler * this.nenner;
			
			int temp_n = b.nenner * this.nenner;
			
			result.zaehler = temp_z1 - temp_z2;
			result.nenner = temp_n;
		}
		return result.kuerzen();
	}
	
	/**
	 * Multipliziert den aktuellen Bruch mit dem uebergebenen Bruch.
	 * @param b
	 * @return das Produkt der Brueche als ein neues Bruch Objekt.
	 */
	public Bruch mal(Bruch b){
		Bruch result = new Bruch();
		result.zaehler = this.zaehler;
		result.nenner = this.nenner;
		
		result.zaehler = this.zaehler * b.zaehler;
		result.nenner = this.nenner * b.nenner;
		return result.kuerzen();
	}
	
	/**
	 * Dividiert den aktuellen Bruch mit dem uebergebenen Bruch.
	 * @param b
	 * @return den Quotient der Brueche als ein neues Bruch Objekt.
	 */
	public Bruch geteilt(Bruch b){
		Bruch result = new Bruch();
		result.zaehler = this.zaehler;
		result.nenner = this.nenner;
		
		result.zaehler = this.zaehler * b.nenner;
		result.nenner = this.nenner * b.zaehler;
		return result.kuerzen();
	}
	
	/**
	 * Printed the aktuellen Bruch.
	 */
	public void print() {
		System.out.printf("%d / %d%n", this.zaehler, this.nenner);
	}
	
	/**
	 * Vergleicht die uebergebenen Brueche nach Groesse, ob der erste Bruch groesser ist.
	 * @param b1
	 * @param b2
	 * @return true wenn der erste Bruch groesser war
	 */
	public static boolean istGroesser(Bruch b1, Bruch b2) {
		Bruch b11 = new Bruch(b1.zaehler,b1.nenner);
		Bruch b22 = new Bruch(b2.zaehler,b2.nenner);
		
		b11.gleichnahmig(b22);
		if ( (b11.zaehler > b22.zaehler) && (b11.nenner == b22.nenner)){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Vergleicht die uebergebenen Brueche nach Groesse, ob der erste Bruch kleiner ist.
	 * @param b1
	 * @param b2
	 * @return true wenn der erste Bruch kleiner war
	 */
	public static boolean istKleiner(Bruch b1, Bruch b2) {
		Bruch b11 = new Bruch(b1.zaehler,b1.nenner);
		Bruch b22 = new Bruch(b2.zaehler,b2.nenner);
		b11.gleichnahmig(b22);
		
		if ( (b11.zaehler < b22.zaehler) && (b11.nenner == b22.nenner)){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Vergleicht die uebergebenen Brueche, ob sie gleich sind.
	 * @param b1
	 * @param b2
	 * @return true wenn die Brueche gleich gross sind
	 */
	public static boolean sindGleich(Bruch b1, Bruch b2) {
		Bruch b11 = new Bruch(b1.zaehler,b1.nenner);
		Bruch b22 = new Bruch(b2.zaehler,b2.nenner);
		b11.gleichnahmig(b22);
		if ( (b11.zaehler == b22.zaehler) && (b11.nenner == b22.nenner)){
			
			return true;
		}
		else {
			return false;
		}
	}
	
}

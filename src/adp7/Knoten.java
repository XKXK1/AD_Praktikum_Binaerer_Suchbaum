package adp7;

/**
 * 
 * @author Derya Uyargil
 * 
 *         Die generische Klasse Knoten, bietet Elemente(Knoten) zum einfuegen
 *         in einen Baum. Beim erstellen des Baums wird der Typ festgelegt.
 *         Jeder Knoten kann einen Inhalt des jeweilig festgelegten Typen haben.
 *
 */
public class Knoten<T extends Comparable<T>> {
	private T inhalt;
	
    private int sum;


	private Knoten<T> links;
	private Knoten<T> rechts;
	private Knoten<T> vater;

	public Knoten(T inhalt) {
		sum =(int) inhalt;
		this.links = null;
		this.rechts = null;
		this.inhalt = inhalt;

	}
	
	 public void addToSum(int value) {
	        sum += value;
	    }
	 
	 public int getSum() {
	        return sum;
	    }
	 

	public T getInhalt() {
		return inhalt;
	}

	public Knoten<T> getLinks() {
		return links;
	}

	public void setLinks(Knoten<T> links) {
		this.links = links;
	}

	public Knoten<T> getRechts() {
		return rechts;
	}

	public void setRechts(Knoten<T> rechts) {
		this.rechts = rechts;
	}

	public Knoten<T> getVater() {
		return vater;
	}

	public void setVater(Knoten<T> vaterinc) {
		vater = vaterinc;
	}





}

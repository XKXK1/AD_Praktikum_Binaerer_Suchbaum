package adp7;

/**
 * 
 * @author Derya Uyargil  Andre Radtke
 * 
 *         Generische Schnittstelle zum erstellen einer Klasse eines Binaeren
 *         Baums. Die Schnittstelle verfuegt ueber zwei Methoden.
 *
 */
public interface Baum<T>  {
	/**
	 * 
	 * Die Methode knotenAusgeben erwartet ein Argument vom Enum Reihenfolge. Es
	 * ist zu empfehlen, diese mit switch: case umzusetzen. Um je nach
	 * "Reihenfolge" eine Umsetzung fuer den jeweiligen Baum umzusetzen.
	 * 
	 * @param reihenfolge
	 *            Variable die den Typen der Reihenfolge uebergibt.
	 */
	void knotenAusgeben(Reihenfolge reihenfolge);

	/**
	 * Die Methode knotenEinfuegen, erwartet eine Variable des generischen
	 * Wertes "T". In der dann umzusetzenden Methode des jeweiligen Baumes gilt
	 * es diese generische Variable in den naechsten freien Knoten des Baumes
	 * einzufuegen.
	 * 
	 * @param value
	 *            Generische Variable die den Inhalt des Knotens repraesentiert.
	 */
	void knotenEinfuegen(T value);
	
	
	/**
	 * Diese Methode gibt die Summe von allen Zahlen zwischen zwei Werten in
	 * einem Binaerbaum aus. Die zwei Werte kann der Anwender selbst angeben.
	 * 
	 * @param wurzel Die wurzel des Baums wird uebergeben.
	 * @param min Die minimale Grenze zum berechnen der Summe.
	 * @param max Die maximale Grenze zum berechnen der Summe.
	 * @return
	 */
	int summeZwischenMinMax(int min, int max);

}

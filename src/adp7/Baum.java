package adp7;

/**
 * 
 * @author Derya Uyargil
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

}

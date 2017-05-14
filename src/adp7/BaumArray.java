package adp7;

/**
 * 
 * @author Derya Uyargil
 * 
 *         Die generische Klasse BaumArray bietet die Umsetzung eines
 *         BinaerBaums, welcher seine Knoten in einem Array abspeichert. Die
 *         Klasse implementiert die Methoden des generischen Interfaces Baum. Es
 *         dadurch ermöglicht, neue Knoten an der naechsten Leeren stelle des
 *         Baumes einzufuegen und alle Knoten in einer vom Enum "Reihenfolge"
 *         gegebenen reihenfolgen auszugeben.
 *
 */
public class BaumArray<T> implements Baum<T> {

	private Object[] array;
	private int baumGroesse;
	private int arrayLaenge;

	/**
	 * Der Konstruktor dieser Klasse erstellt einen Baum, welcher zunaechst
	 * Platz fuer einen Wurzelknoten und zwei Soehne hat(3 Knoten).
	 */
	public BaumArray() {
		array = new Object[3];
		arrayLaenge = 3;
		baumGroesse = 1;
	}

	@Override
	public void knotenAusgeben(Reihenfolge reihenfolge) {

		if (reihenfolge == Reihenfolge.INORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Inorder solution:");
			printInorder(1);

		} else if (reihenfolge == Reihenfolge.PREORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Preorder solution:");
			printPreorder(1);

		} else if (reihenfolge == Reihenfolge.POSTORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Postorder solution:");
			printPostorder(1);

		}

	}

	/**
	 * Hilfsmethode zum ausgeben aller Knoten des Baumes in folgender rekursiven
	 * Reihenfolge(Inorder): Sohn-Links , Vater, Sohn-Rechts.
	 * 
	 * @param index
	 *            Diese Methode kriegt als Argument den Index 1 mitgegeben. Dies
	 *            gilt als Startpunkt fuer diese Methode.
	 */
	private void printInorder(int index) {
		if (index * 2 < arrayLaenge && array[index * 2] != null) {
			printInorder(index * 2);
		}
		System.out.print("  " + ((Knoten<T>) array[index]).getInhalt());
		if (index * 2 + 1 < arrayLaenge && array[index * 2 + 1] != null) {
			printInorder(index * 2 + 1);
		}

	}

	/**
	 * Hilfsmethode zum ausgeben aller Knoten des Baumes in folgender rekursiven
	 * Reihenfolge(Preorder): Vater, Sohn-Links, Sohn-Rechts.
	 * 
	 * @param index
	 *            Diese Methode kriegt als Argument den Index 1 mitgegeben. Dies
	 *            gilt als Startpunkt fuer diese Methode.
	 */
	private void printPreorder(int index) {
		System.out.print("  " + ((Knoten<T>) array[index]).getInhalt());
		if (index * 2 < arrayLaenge && array[index * 2] != null) {
			printInorder(index * 2);
		}

		if (index * 2 + 1 < arrayLaenge && array[index * 2 + 1] != null) {
			printInorder(index * 2 + 1);
		}

	}

	/**
	 * Hilfsmethode zum ausgeben aller Knoten des Baumes in folgender rekursiven
	 * Reihenfolge(Preorder): Sohn-Links, Sohn-Rechts, Vater.
	 * 
	 * @param index
	 *            Diese Methode kriegt als Argument den Index 1 mitgegeben. Dies
	 *            gilt als Startpunkt fuer diese Methode.
	 */
	private void printPostorder(int index) {

		if (index * 2 < arrayLaenge && array[index * 2] != null) {
			printInorder(index * 2);
		}

		if (index * 2 + 1 < arrayLaenge && array[index * 2 + 1] != null) {
			printInorder(index * 2 + 1);
		}
		System.out.print("  " + ((Knoten<T>) array[index]).getInhalt());

	}

	@Override
	public void knotenEinfuegen(T value) {
		new Knoten<T>(value);

		// test
		if (baumGroesse + 1 == arrayLaenge) {
			Object[] temp = new Object[arrayLaenge * 2];
			System.arraycopy(array, 0, temp, 0, arrayLaenge);
			array = temp;
			arrayLaenge = arrayLaenge * 2;
		}
		array[baumGroesse] = new Knoten<T>(value);
		baumGroesse++;
	}

	public static void main(String[] args) {

		BaumArray<Integer> baum1 = new BaumArray<Integer>();
		baum1.knotenEinfuegen(5);
		baum1.knotenEinfuegen(10);
		baum1.knotenEinfuegen(15);
		baum1.knotenEinfuegen(20);
		baum1.knotenEinfuegen(25);
		baum1.knotenEinfuegen(30);
		baum1.knotenEinfuegen(35);
		baum1.knotenAusgeben(Reihenfolge.INORDER);

	}

}

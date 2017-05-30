package adp7;

/**
 * 
 * @author Derya Uyargil  Andre Radtke
 * 
 *         Die generische Klasse BaumArray bietet die Umsetzung eines
 *         BinaerBaums, welcher seine Knoten in einem Array abspeichert. Die
 *         Klasse implementiert die Methoden des generischen Interfaces Baum. Es
 *         dadurch ermöglicht, neue Knoten an der naechsten Leeren stelle des
 *         Baumes einzufuegen und alle Knoten in einer vom Enum "Reihenfolge"
 *         gegebenen reihenfolgen auszugeben.
 *
 */
public class BaumArray<T extends Comparable<T>> implements Baum<T> {

	private Object[] array;
	private int baumGroesse;
	private int arrayLaenge;

	/**
	 * Der Konstruktor dieser Klasse erstellt einen Baum, welcher zunaechst
	 * Platz fuer einen Wurzelknoten und zwei Soehne hat(3 Knoten).
	 */
	public BaumArray() {
		array = new Object[4];
		arrayLaenge = 4;
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
		Knoten<T> knoten = new Knoten<T>(value);

		if (array[1] == null) {
			array[1] = knoten;
			baumGroesse++;
		} else {
			knotenEinfuegen2(value, 1);
		}
	}

	private void knotenEinfuegen2(T value, int i) {
		if (i * 2 + 1 > arrayLaenge) {
			Object[] swap = new Object[arrayLaenge * 2];
			System.arraycopy(array, 0, swap, 0, arrayLaenge);
			array = swap;
			arrayLaenge = arrayLaenge * 2;
		}

		if (value.compareTo(((Knoten<T>) array[i]).getInhalt()) == -1) {
			if (array[2 * i] == null) {
				Knoten<T> knoten = new Knoten<T>(value);
				array[2 * i] = knoten;
				baumGroesse++;
			} else {
				knotenEinfuegen2(value, 2 * i);

			}
		} else if (value.compareTo(((Knoten<T>) array[i]).getInhalt()) == 1) {
			if (array[2 * i + 1] == null) {
				Knoten<T> knoten = new Knoten<T>(value);
				array[2 * i + 1] = knoten;
				baumGroesse++;
			} else {
				knotenEinfuegen2(value, 2 * i + 1);

			}
		} else {
			System.out.println("Value existiert bereits");
		}
		
		((Knoten<T>)array[i]).addToSum((int)value);

	}

	@Override
	public int summeZwischenMinMax(int min, int max) {
		// Wenn die Zahlen falschherum eingetragen wurden, werden sie getauscht
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return ((Knoten<T>) array[1]).getSum() - getSummeGroesserAlsMax(1, max) - getSummeKleinerAlsMin(1, min);

	}

	private int getSummeKleinerAlsMin(int index, int MinLimit) {

		if (array[index] == null) {
			return 0;
		}
		// alles was kleiner ist muss subtrahiert werden
		if (((Knoten<Integer>) array[index]).getInhalt() == MinLimit) {
			if (array[2*index] != null) {
				return ((Knoten<Integer>) array[2*index]).getSum();
			} else {
				return 0;
			}
			// Zahl noch nicht bei minimum angekommen (von 0)
		} else if (((Knoten<Integer>) array[index]).getInhalt() > MinLimit) {
			return getSummeKleinerAlsMin(2*index, MinLimit);
		} else {
			// Falls das min noch nicht erreicht ist, aber nach rechts gegangen
			// werden muss weil min nicht links liegt muessen alle Zahlen die
			// bis zum erreich von min kommen mit abgezogen werden weil diese
			// ausserhalb des bereiches der gewünschten summe liegen
			int subtraktionsAkkumulation = ((Knoten<Integer>) array[index]).getInhalt();
			if (array[2*index] != null) {
				subtraktionsAkkumulation += ((Knoten<Integer>) array[2*index]).getSum();
			}
			// Naechster Aufruf mit subtraktionszusatz da min noch nicht
			// erreicht wurde von unten gesehen
			return subtraktionsAkkumulation + getSummeKleinerAlsMin(2*index+1, MinLimit);
		}

	}

	private int getSummeGroesserAlsMax(int index, int maxLimit) {

		if (array[index] == null) {
			return 0;
		}
		// alles was groesser ist muss subtrahiert werden
		if (((Knoten<Integer>) array[index]).getInhalt() == maxLimit) {
			if (array[2*index+1] != null) {
				return ((Knoten<Integer>) array[2*index+1]).getSum();
			} else {
				return 0;
			}

			// Zahl noch nicht bei maximum angekommen (von 0)
		} else if (((Knoten<Integer>) array[index]).getInhalt() < maxLimit) {
			return getSummeGroesserAlsMax(2*index+1, maxLimit);
		} else {
			// Falls das max noch nicht erreicht ist, aber nach links gegangen
			// werden muss weil max nicht rechts liegt muessen alle Zahlen die
			// bis zum erreich von max kommen mit abgezogen werden weil diese
			// ausserhalb des bereiches der gewünschten summe liegen
			int subtraktionsAkkumulation = ((Knoten<Integer>) array[index]).getInhalt();
			if ((array[2*index+1] != null)) {
				subtraktionsAkkumulation += ((Knoten<Integer>) array[(2*index)+1]).getSum();
			}
			return subtraktionsAkkumulation + getSummeGroesserAlsMax(2*index, maxLimit);
		}
	}


}

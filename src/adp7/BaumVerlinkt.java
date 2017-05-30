package adp7;

/**
 * 
 * @author Derya Uyargil   Andre Radtke
 * 
 *         Die generische Klasse BaumVerlinkt bietet die Umsetzung eines
 *         BinaerBaums, welcher seine Knoten mit Zeigern zum Vater, linken Sohn
 *         und rechten Sohn abspeichert. Die Klasse implementiert die Methoden
 *         des generischen Interfaces Baum. Es dadurch ermöglicht, neue Knoten
 *         an der naechsten Leeren stelle des Baumes einzufuegen und alle Knoten
 *         in einer vom Enum "Reihenfolge" gegebenen reihenfolgen auszugeben.
 *
 */
public class BaumVerlinkt<T extends Comparable<T>> implements Baum<T> {
	private Knoten<T> wurzel;

	@Override
	public void knotenAusgeben(Reihenfolge reihenfolge) {
		if (reihenfolge == Reihenfolge.INORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Inorder solution:");
			printInorder(wurzel);

		} else if (reihenfolge == Reihenfolge.PREORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Preorder solution:");
			printPreorder(wurzel);

		} else if (reihenfolge == Reihenfolge.POSTORDER) {
			System.out.println("\n-------------------------");
			System.out.println("Using Postorder solution:");
			printPostorder(wurzel);

		}

	}

	public void knotenEinfuegen(T value) {
		Knoten<T> node = new Knoten<T>(value);
		if (wurzel == null) {
			wurzel = node;
		} else {
			knotenEinfuegen2(wurzel, value);
		}
	}

	private void knotenEinfuegen2(Knoten<T> node, T value) {
		Knoten<T> knoten = new Knoten<T>(value);

		if (value.compareTo(node.getInhalt()) == -1) {
			if (node.getLinks() == null) {
				node.setLinks(knoten);
				node.getLinks().setVater(node);
			} else {
				knotenEinfuegen2(node.getLinks(), value);
			}

		} else if (value.compareTo(node.getInhalt()) == 1) {
			if (node.getRechts() == null) {
				node.setRechts(knoten);
				node.getRechts().setVater(node);
			} else {
				knotenEinfuegen2(node.getRechts(), value);
			}

		} else {
			System.out.println("Value existiert bereits!");
		}

		node.addToSum((int) value);

	}

	/**
	 * Hilfsmethode zum ausgeben aller Knoten des Baumes in folgender rekursiven
	 * Reihenfolge(Inorder): Sohn-Links , Vater, Sohn-Rechts.
	 * 
	 * @param index
	 *            Diese Methode kriegt als Argument den Index 1 mitgegeben. Dies
	 *            gilt als Startpunkt fuer diese Methode.
	 */
	private void printInorder(Knoten<T> knoten) {

		if (knoten.getLinks() != null) {
			printInorder(knoten.getLinks());

		}
		System.out.print("  " + knoten.getInhalt());

		if (knoten.getRechts() != null) {
			printInorder(knoten.getRechts());
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
	private void printPreorder(Knoten<T> knoten) {
		System.out.print("  " + knoten.getInhalt());
		if (knoten.getLinks() != null) {
			printPreorder(knoten.getLinks());

		}
		if (knoten.getRechts() != null) {
			printPreorder(knoten.getRechts());
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
	private void printPostorder(Knoten<T> knoten) {
		if (knoten.getLinks() != null) {
			printPostorder(knoten.getLinks());
		}
		if (knoten.getRechts() != null) {
			printPostorder(knoten.getRechts());
		}
		System.out.print("  " + knoten.getInhalt());
	}

	@Override
	public int summeZwischenMinMax(int min, int max) {
		// Wenn die Zahlen falschherum eingetragen wurden, werden sie getauscht
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return wurzel.getSum() - getSummeGroesserAlsMax((Knoten<Integer>) wurzel, max)
				- getSummeKleinerAlsMin((Knoten<Integer>) wurzel, min);
	}
	
	private int getSummeKleinerAlsMin(Knoten<Integer> current, int MinLimit) {
		
		if (current == null) {
			return 0;
		}
		// alles was kleiner ist muss subtrahiert werden
		if (current.getInhalt() == MinLimit) {
			if (current.getLinks() != null) {
				return current.getLinks().getSum();
			} else {
				return 0;
			}
			// Zahl noch nicht bei minimum angekommen (von 0)
		} else if (current.getInhalt() > MinLimit) {
			return getSummeKleinerAlsMin(current.getLinks(), MinLimit);
		} else {
			// Falls das min noch nicht erreicht ist, aber nach rechts gegangen
			// werden muss weil min nicht links liegt muessen alle Zahlen die
			// bis zum erreich von min kommen mit abgezogen werden weil diese
			// ausserhalb des bereiches der gewünschten summe liegen
			int subtraktionsAkkumulation = current.getInhalt();
			if (current.getLinks() != null) {
				subtraktionsAkkumulation += current.getLinks().getSum();
			}
			// Naechster Aufruf mit subtraktionszusatz da min noch nicht
			// erreicht wurde von unten gesehen
			return subtraktionsAkkumulation + getSummeKleinerAlsMin(current.getRechts(), MinLimit);
		}
		
	}

	private int getSummeGroesserAlsMax(Knoten<Integer> current, int maxLimit) {
		
		if (current == null) {
			return 0;
		}
		// alles was groesser ist muss subtrahiert werden
		if (current.getInhalt() == maxLimit) {
			if (current.getRechts() != null) {
				return current.getRechts().getSum();
			} else {
				return 0;
			}

			// Zahl noch nicht bei maximum angekommen (von 0)
		} else if (current.getInhalt() < maxLimit) {
			return getSummeGroesserAlsMax(current.getRechts(), maxLimit);
		} else {
			// Falls das max noch nicht erreicht ist, aber nach links gegangen
			// werden muss weil max nicht rechts liegt muessen alle Zahlen die
			// bis zum erreich von max kommen mit abgezogen werden weil diese
			// ausserhalb des bereiches der gewünschten summe liegen
			int subtraktionsAkkumulation = current.getInhalt();
			if (current.getRechts() != null) {
				subtraktionsAkkumulation += current.getRechts().getSum();
			}
			return subtraktionsAkkumulation + getSummeGroesserAlsMax(current.getLinks(), maxLimit);
		}
	}



}

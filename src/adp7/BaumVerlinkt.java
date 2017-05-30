package adp7;

/**
 * 
 * @author Derya Uyargil
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
	Knoten<T> wurzel;
	boolean insertSucces = false;
	int position = 0;

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



}

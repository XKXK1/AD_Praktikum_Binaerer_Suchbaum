package adp7;

public class SumBetweenTwo {
	private long counter = 0;

	/**
	 * Diese Methode gibt die Summe von allen Zahlen zwischen zwei Werten in
	 * einem Binaerbaum aus. Die zwei Werte kann der Anwender selbst angeben.
	 * 
	 * @param wurzel Die wurzel des Baums wird uebergeben.
	 * @param min Die minimale Grenze zum berechnen der Summe.
	 * @param max Die maximale Grenze zum berechnen der Summe.
	 * @return
	 */
	public int sumBetweenMinMax(Knoten<Integer> wurzel, int min, int max) {
		// Wenn die Zahlen falschherum eingetragen wurden, werden sie getauscht
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return wurzel.getSum() - getMaxRightside((Knoten<Integer>) wurzel, max)
				- getMinLeftside((Knoten<Integer>) wurzel, min);
	}


	private int getMinLeftside(Knoten<Integer> current, int MinLimit) {
		counter++;
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
			return getMinLeftside(current.getLinks(), MinLimit);
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
			return subtraktionsAkkumulation + getMinLeftside(current.getRechts(), MinLimit);
		}
		
	}

	private int getMaxRightside(Knoten<Integer> current, int maxLimit) {
		counter++;
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
			return getMaxRightside(current.getRechts(), maxLimit);
		} else {
			// Falls das max noch nicht erreicht ist, aber nach links gegangen
			// werden muss weil max nicht rechts liegt muessen alle Zahlen die
			// bis zum erreich von max kommen mit abgezogen werden weil diese
			// ausserhalb des bereiches der gewünschten summe liegen
			int subtraktionsAkkumulation = current.getInhalt();
			if (current.getRechts() != null) {
				subtraktionsAkkumulation += current.getRechts().getSum();
			}
			return subtraktionsAkkumulation + getMaxRightside(current.getLinks(), maxLimit);
		}
	}


	public long getCounter() {
		return counter;
	}

}

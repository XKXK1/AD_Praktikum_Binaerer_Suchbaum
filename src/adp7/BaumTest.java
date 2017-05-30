package adp7;

public class BaumTest {

	public static void main(String[] args) {

		BaumVerlinkt<Integer> baumlinked = new BaumVerlinkt<Integer>();
		SumBetweenTwo sum = new SumBetweenTwo();
		baumlinked.knotenEinfuegen(10);
		baumlinked.knotenEinfuegen(8);
		baumlinked.knotenEinfuegen(13);
		baumlinked.knotenEinfuegen(6);
		baumlinked.knotenEinfuegen(9);
		baumlinked.knotenEinfuegen(7);
		baumlinked.knotenEinfuegen(12);
		baumlinked.knotenEinfuegen(14);
		baumlinked.knotenEinfuegen(11);
		baumlinked.knotenAusgeben(Reihenfolge.POSTORDER);
		
		System.out.println(sum.sumBetweenMinMax(baumlinked.wurzel, 8,13));
		System.out.println(sum.getCounter());
		
		BaumArray<Integer> baumArray = new BaumArray<Integer>();
		baumArray.knotenEinfuegen(50);
		baumArray.knotenEinfuegen(10);
		baumArray.knotenEinfuegen(25);
		baumArray.knotenEinfuegen(5);
		baumArray.knotenEinfuegen(25);
		baumArray.knotenEinfuegen(30);
		baumArray.knotenEinfuegen(35);
		baumArray.knotenAusgeben(Reihenfolge.POSTORDER);

	}

}

package adp7;

public class BaumTest {

	public static void main(String[] args) {

		BaumVerlinkt<Integer> baumlinked = new BaumVerlinkt<Integer>();

		baumlinked.knotenEinfuegen(10);
		baumlinked.knotenEinfuegen(8);
		baumlinked.knotenEinfuegen(13);
		baumlinked.knotenEinfuegen(6);
		baumlinked.knotenEinfuegen(9);
		baumlinked.knotenEinfuegen(7);
		baumlinked.knotenEinfuegen(12);
		baumlinked.knotenEinfuegen(14);
		baumlinked.knotenEinfuegen(11);
		
		System.out.println(baumlinked.summeZwischenMinMax(8,13));

		
		BaumArray<Integer> baumArray = new BaumArray<Integer>();
		baumArray.knotenEinfuegen(10);
		baumArray.knotenEinfuegen(8);
		baumArray.knotenEinfuegen(13);
		baumArray.knotenEinfuegen(6);
		baumArray.knotenEinfuegen(9);
		baumArray.knotenEinfuegen(7);
		baumArray.knotenEinfuegen(12);
		baumArray.knotenEinfuegen(14);
		baumArray.knotenEinfuegen(11);
		//baumArray.knotenAusgeben(Reihenfolge.POSTORDER);
		System.out.println(baumArray.summeZwischenMinMax(8, 13));

	}

}

package adp7;

import static org.junit.Assert.*;

import org.junit.Test;


public class BaumTest {
	
	@Test
	public void summeZwischenZweiWertenNormal(){
		BaumVerlinkt<Integer> baumlinked = new BaumVerlinkt<Integer>();
		BaumVerlinkt<Integer> baumlinkedReversed = new BaumVerlinkt<Integer>();

		baumlinked.knotenEinfuegen(10);
		baumlinked.knotenEinfuegen(8);
		baumlinked.knotenEinfuegen(13);
		baumlinked.knotenEinfuegen(6);
		baumlinked.knotenEinfuegen(9);
		baumlinked.knotenEinfuegen(7);
		baumlinked.knotenEinfuegen(12);
		baumlinked.knotenEinfuegen(14);
		baumlinked.knotenEinfuegen(11);

		
		int expectecBetween8and13 = 63;		
		assertEquals(expectecBetween8and13, baumlinked.summeZwischenMinMax(8, 13));
		
		int expectecBetween1and20 = 90;		
		assertEquals(expectecBetween1and20, baumlinked.summeZwischenMinMax(1, 20));	
		
		baumlinkedReversed.knotenEinfuegen(11);
		baumlinkedReversed.knotenEinfuegen(14);
		baumlinkedReversed.knotenEinfuegen(12);
		baumlinkedReversed.knotenEinfuegen(7);
		baumlinkedReversed.knotenEinfuegen(9);
		baumlinkedReversed.knotenEinfuegen(6);
		baumlinkedReversed.knotenEinfuegen(13);
		baumlinkedReversed.knotenEinfuegen(8);
		baumlinkedReversed.knotenEinfuegen(10);
			
		assertEquals(expectecBetween8and13, baumlinkedReversed.summeZwischenMinMax(8, 13));
		
		assertEquals(expectecBetween1and20, baumlinkedReversed.summeZwischenMinMax(1, 20));	
		
	}
	
	@Test
	public void SummeZwischenZweiWertenEinseitig(){
		BaumVerlinkt<Integer> baumlinked = new BaumVerlinkt<Integer>();
		BaumVerlinkt<Integer> baumlinkedReversed = new BaumVerlinkt<Integer>();

		baumlinked.knotenEinfuegen(1);
		baumlinked.knotenEinfuegen(2);
		baumlinked.knotenEinfuegen(3);
		baumlinked.knotenEinfuegen(4);
		baumlinked.knotenEinfuegen(5);
	
		int expectecBetween3and5 = 12;		
		assertEquals(expectecBetween3and5, baumlinked.summeZwischenMinMax(3, 5));
		
		int expectecBetween1and20 = 15;		
		assertEquals(expectecBetween1and20, baumlinked.summeZwischenMinMax(1, 20));	
		
		baumlinkedReversed.knotenEinfuegen(5);
		baumlinkedReversed.knotenEinfuegen(4);
		baumlinkedReversed.knotenEinfuegen(3);
		baumlinkedReversed.knotenEinfuegen(2);
		baumlinkedReversed.knotenEinfuegen(1);
		

		assertEquals(expectecBetween3and5, baumlinkedReversed.summeZwischenMinMax(3, 5));
			
		assertEquals(expectecBetween1and20, baumlinkedReversed.summeZwischenMinMax(1, 20));	
		
	}
	
	@Test
	public void baumVerlinked(){
		BaumVerlinkt<Integer> baumlinked = new BaumVerlinkt<Integer>();
		
		baumlinked.knotenEinfuegen(1);
		baumlinked.knotenEinfuegen(2);
		baumlinked.knotenEinfuegen(3);
		baumlinked.knotenEinfuegen(4);
		baumlinked.knotenEinfuegen(5);
		
		//1 2 3 4 5
		baumlinked.knotenAusgeben(Reihenfolge.INORDER);
		//1 2 3 4 5
		baumlinked.knotenAusgeben(Reihenfolge.PREORDER);
		//5 4 3 2 1 
		baumlinked.knotenAusgeben(Reihenfolge.POSTORDER);
	
		
		
	}
	
	
}

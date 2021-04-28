package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import arvore_binaria.ArrayListCompleteBT;
class ArrayListCompleteBTTest {

	@Test
	void teste() {
		ArrayListCompleteBT<Integer> T = new ArrayListCompleteBT<Integer>();
	
		T.add(4);
		assertEquals(1, T.size());
		T.add(5);
		T.add(6);
		T.add(15);
		T.add(9);
		assertEquals(5, T.size());
		T.add(7);
		T.add(20);
		T.add(16);
		T.add(25);
		T.add(14);
		assertEquals(10, T.size());
		T.add(12);
		T.add(11);
		T.add(8);
	
		assertEquals("[null, [4, 1], [5, 2], [6, 3], [15, 4], [9, 5], [7, 6], [20, 7], [16, 8], [25, 9], [14, 10], [12, 11], [11, 12], [8, 13]]", T.toString());
		assertEquals(13, T.size());
	}
}

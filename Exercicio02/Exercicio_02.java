package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import source.SortedListPriorityQueue;

class Exercicio02 {
	@Test
	void test() {
		SortedListPriorityQueue<Integer, String> N = new SortedListPriorityQueue<Integer, String>();
		N.insert(5, "A");
		N.insert(4, "B");
		N.insert(7, "I");
		N.insert(1, "D");
		N.removeMin();
		N.insert(3, "J");
		N.insert(6, "L");
		N.removeMin();
		N.removeMin();
		N.insert(8, "G");
		N.removeMin();
		N.insert(2, "H");
		N.removeMin();
		N.removeMin();
		
		assertEquals("[(7,I), (8,G)]", N.toString());
	}
}

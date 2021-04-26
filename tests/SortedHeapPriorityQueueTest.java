package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import heap_fila_prioridade.HeapPriorityQueue;
import heap_fila_prioridade.SortedHeapPriorityQueue;

class SortedHeapPriorityQueueTest {

	@Test
	void test() {
		HeapPriorityQueue<Integer, String> P = new HeapPriorityQueue<Integer, String>();
		SortedHeapPriorityQueue S = new SortedHeapPriorityQueue();
		
		int t1[] = {22, 6, 65, 21, 9, 1};
		int r1[] = S.sort(t1);
		assertEquals("[1, 6, 9, 21, 22, 65]", Arrays.toString(r1));
		
		int t2[] = {100, 67, 12, 87, 3, 0};
		int r2[] = S.sort(t2);
		assertEquals("[0, 3, 12, 67, 87, 100]", Arrays.toString(r2));
		
		int t3[] = {56, 32, 67, 1, 89, 43, 69, 5, 0, 21};
		int r3[] = S.sort(t3);
		assertEquals("[0, 1, 5, 21, 32, 43, 56, 67, 69, 89]", Arrays.toString(r3));
		
		int t4[] = {3, 2, 1};
		int r4[] = S.sort(t4);
		assertEquals("[1, 2, 3]", Arrays.toString(r4));
	}

}

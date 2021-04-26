package heap_fila_prioridade;
import java.util.Arrays;

public class SortedHeapPriorityQueue {
	
	public static int[] sort(int v[]) {
		HeapPriorityQueue<Integer, Integer> q = new HeapPriorityQueue<Integer, Integer>();
		for (int i=0; i < v.length; i++) {
			q.insert(v[i], v[i]);
		}		
		v = new int [v.length];		
		for (int i=0; i < v.length; i++) {
			v[i] = q.removeMin().getValue();
		}	
		return v;
	}
	
	public static void main(String[] args) {
		int v[] = {22, 6, 65, 21, 9, 1, 67, 99, 100, 32};
		int vSorted[] = sort(v);
		System.out.println(Arrays.toString(vSorted));
	}
}

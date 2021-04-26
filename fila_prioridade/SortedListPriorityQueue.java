package fila_prioridade;
import java.util.Comparator;
import exceptions.EmptyPriorityQueueException;
import exceptions.InvalidKeyException;
import lista_nodos.NodePositionList;
import lista_nodos.PositionList;
import lista_nodos.Position;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
	protected PositionList<Entry<K, V>> entries;
	protected Comparator<K> compa;
	protected Position<Entry<K, V>> actionPos;
	
	protected static class MyEntry<K, V> implements Entry<K, V> {
		protected K k;
		protected V v;
		public MyEntry(K key, V value) {
			k = key;
			v = value;
		}
		
		public K getKey() {return k;}
		public V getValue() {return v;}
		public String toString() {return "(" + k + "," + v + ")"; }
	}
	// Cria fila de prioridade com comparador padrao
	public SortedListPriorityQueue() {
		entries = new NodePositionList<Entry<K, V>>();
		compa = new DefaultComparator<K>();
	}
	// Cria a fila de prioridades com um comparador declarado
	public SortedListPriorityQueue(Comparator<K> comp) {
		entries = new NodePositionList<Entry<K, V>>();
		compa = comp;
	}
	// Cria a fila de prioridade com um comparador informado e lista
	public SortedListPriorityQueue(PositionList<Entry<K, V>> list, Comparator<K> comp) {
		entries = list;
		compa = comp;
	}
	// Configura o comparador para a fila de prioridade
	public void setComparator(Comparator<K> comp) throws IllegalStateException {
		if (!isEmpty()) throw new IllegalStateException("Lista de prioridade não está vazia!");
		compa = comp;
	}
	// Retorna o número de elementos da fila de propridade
	public int size() { return entries.size(); }
	// Retorna se a fila de prioridade esttiver vazia
	public boolean isEmpty() { return entries.isEmpty(); }
	// Retorna mas nao remove uma entrada com a chave minima
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (entries.isEmpty()) throw new EmptyPriorityQueueException("Lista de priridades está vazia!");
		else return entries.first().element();
	}
	// Insere um par chave-valor e retorna a entrada criada
	public Entry<K, V> insert(K k, V v) throws InvalidKeyException {
	checkKey(k); 
	Entry<K, V> entry = new MyEntry<K, V>(k, v);
	insertEntry(entry);
	return entry;
	}
	// Metodo auxiliar usado para insercao
	protected void insertEntry(Entry<K, V> e) {
		if (entries.isEmpty()) {
			entries.addFirst(e); 
			actionPos = entries.first();
		} 
		else if (compa.compare(e.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(e); 
			actionPos = entries.last();
		} 
		else {
			Position<Entry<K, V>> curr = entries.first();
			while (compa.compare(e.getKey(), curr.element().getKey()) > 0) {
				curr = entries.next(curr); 
			}
			entries.addBefore(curr, e);
			actionPos = entries.prev(curr); 
		}
	}
	// Remove e retorna uma entrada com a a menor chave
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if (entries.isEmpty()) throw new EmptyPriorityQueueException("Lista de prioridade vazia");
		else return entries.remove(entries.first());
	}
	protected boolean checkKey(K key) throws InvalidKeyException {
		boolean result;
		try { 
			result = (compa.compare(key, key) == 0);
		} catch (ClassCastException e) {
			throw new InvalidKeyException("A chave não pode ser comparada.");
		}
		return result;
	}
	public String toString() throws EmptyPriorityQueueException{
		return entries.toString();
	}
}

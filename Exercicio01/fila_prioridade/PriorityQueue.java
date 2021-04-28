package fila_prioridade;
import exceptions.EmptyPriorityQueueException;
import exceptions.InvalidKeyException;

// Interface da TAD Fila de Prioridade
public interface PriorityQueue<K, V> {
	// Retorna a quantidade de itens que estao na fila de prioridade
	public int size();
	// Retorna se a fila de prioridade esta vazia
	public boolean isEmpty();
	// Retorna mas nao remove uma entrada com chave minima
	public Entry<K,V> min() throws EmptyPriorityQueueException;
	// Insere par chave-valor e retorna a entrada criada
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException;
	// Remove e retorna um entrada com chave minima
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException;
}

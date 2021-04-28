package fila_prioridade;

// Interface que recebe os pares de Chave e Valor.

public interface Entry<K, V> {
	// Retorna o valor da chave
	public K getKey();
	// Retorna o Valor do par chave
	public V getValue();
}

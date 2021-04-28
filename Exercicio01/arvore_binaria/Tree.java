package arvore_binaria;
import java.util.Iterator;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import position.Position;

public interface Tree<E> extends Iterable<E> {
	public int size();
	// Retorna se a árvore esta vazia
	public boolean isEmpty();
	// Retorna um iterador sobre os elementos armazenados na arvore
	public Iterator<E> iterator();
	// Retorna uma colecao iteravel dos nodos
	public Iterable<Position<E>> positions();
	// Substitui o elemento armazenado em um dado nodo
	public E replace(Position<E> v, E e) throws InvalidPositionException;
	// Retorna a raiz da arvore
	public Position<E> root() throws EmptyTreeException;
	// Retorna o pai de um dado nodo
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	// Retorna uma colecao iteravel dos filhos de um dado nodo
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	// Retorna se um dado nodo e interno
	public boolean isInternal(Position<E> v) throws InvalidPositionException;
	// Retorna se um dado nodo e externo
	public boolean isExternal(Position<E> v) throws InvalidPositionException;
	// Retorna se um dado nodo e a raiz da arvore
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
}

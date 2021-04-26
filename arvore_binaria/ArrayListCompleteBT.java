package arvore_binaria;

import java.util.ArrayList;
import java.util.Iterator;
import exceptions.InvalidPositionException;
import lista_nodos.NodePositionList;
import position.Position;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;

public class ArrayListCompleteBT<E> implements CompleteBinaryTree<E> {
	protected ArrayList<Position<E>> tree;  
	
	public ArrayListCompleteBT() {
		tree = new ArrayList<Position<E>>();  
		tree.add(0, null);  
	}
	
	protected static class BTPosition<E> implements Position<E> {
		protected E element;  
		protected int index;     
		
		public int index() {
			return index;
		}
		
		public BTPosition(E element, int index) {
			this.element = element;
			this.index = index;
		}
		
		public E element() {
			return element;
		}
		
		public String toString() {
			return "[" + element + ", " + index + "]";
		}
		
		public E setElement(E newElement) {
			E toReturn = element;
			element = newElement;
			return toReturn;
		}
		
	}
	
	public int size() {
		return tree.size() - 1;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean isExternal(Position<E> node) throws InvalidPositionException {
		return ! isInternal(node);
	}
		
	public boolean isInternal(Position<E> node) throws InvalidPositionException {
		return hasLeft(node);  
	}
	
	public boolean isRoot(Position<E> node) throws InvalidPositionException {
		BTPosition<E> point = checkPosition(node);
		return point.index() == 1;
	}
	
	public boolean hasRight(Position<E> node) throws InvalidPositionException {
		BTPosition<E> point = checkPosition(node);
		return (2 * point.index() + 1) <= size();  
	}
	
	public boolean hasLeft(Position<E> node) throws InvalidPositionException {
		BTPosition<E> point = checkPosition(node);
		return 2 * point.index() <= size();  
	}
	
	public Position<E> root() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException("A árvore está vazia");
		
		return tree.get(1);
	}
	
	public Position<E> left(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("O nodo não tem filho a esquerda");
		
		BTPosition<E> point = checkPosition(node);
		return tree.get(2 * point.index());
	}
	
	public Position<E> right(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
		if (! hasLeft(node))
			throw new BoundaryViolationException("O nodo não tem filho a direita");
		
		BTPosition<E> point = checkPosition(node);
		return tree.get(2 * point.index() + 1);
	}
	
	public Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
		if (isRoot(node))
			throw new BoundaryViolationException("O nodo não tem parente");
		
		BTPosition<E> point = checkPosition(node);
		return tree.get(point.index() / 2);
	}
	
	public Iterable<Position<E>> children(Position<E> node) throws InvalidPositionException {
		NodePositionList<Position<E>> children = new NodePositionList<Position<E>>();
		
		if (hasLeft(node))
			children.addLast(left(node));
		
		if (hasRight(node))
			children.addLast(right(node));
		
		return children;
	}
	
	public E replace(Position<E> node, E newElement) throws InvalidPositionException {
		BTPosition<E> point = checkPosition(node);
		return point.setElement(newElement);
	}
	
	public Position<E> add(E element) {
		int index = size() + 1;  // Indice do elemento depois do ultimo.
		BTPosition<E> newElement = new BTPosition<E>(element, index);
		tree.add(index, newElement);
		
		return newElement;
	}
	
	public E remove() throws EmptyTreeException {
		if (isEmpty())
			throw new EmptyTreeException("Árvore vazia");
		
		return tree.remove(size()).element();
	}
	
	
	public Position<E> sibling(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
		try {
			Position<E> parentNode = parent(node);
			Position<E> leftNode = left(parentNode);
			
			if (node == leftNode)
				return right(node);
			
			return leftNode;
		}
		catch (BoundaryViolationException error) {
			throw new BoundaryViolationException("O nodo nao tem irmao");
		}
	}
	
	public void swapElements(Position<E> nodeW, Position<E> nodeZ) throws InvalidPositionException {
		BTPosition<E> w = checkPosition(nodeW);
		BTPosition<E> z = checkPosition(nodeZ);
		
		E temp = w.element();
		
		w.setElement(z.element());
		z.setElement(temp);
	}
	
	
	public Iterable<Position<E>> positions() {
		ArrayList<Position<E>> array = new ArrayList<Position<E>>(); 
		
		for (int i=1; i < size(); i++) {
			array.add(tree.get(i));
		}
		return array;
	}
	
	public Iterator<E> iterator() {
		ArrayList<E> array = new ArrayList<E>(); 
		
		for (int i=1; i < size(); i++) {
			array.add(tree.get(i).element());
		}			
		return array.iterator();
	}
	
	protected BTPosition<E> checkPosition(Position<E> node) throws InvalidPositionException {
		if (node == null || ! (node instanceof BTPosition))
			throw new InvalidPositionException("O nodo é invalido");
		
		return (BTPosition<E>) node;
	}
	
	public String toString() {
		return tree.toString();
	}
}
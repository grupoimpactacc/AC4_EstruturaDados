package arvore_binaria;

import exceptions.EmptyTreeException;
import position.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
	public Position<E> add(E e);
	public E remove() throws EmptyTreeException;
}
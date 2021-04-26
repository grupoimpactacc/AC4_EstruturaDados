package arvore_binaria;

public class BTNode<E> implements BTPosition<E> {
	private E element; 
	private BTPosition<E> left, right, parent;
	
	// Construtor principal
	public BTNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	
	// Retorna o elemento armazenado nesta posicao
	public E element() { return element; }
	// Define o elemento armazenado nesta posicao
	public void setElement(E o) { element = o; }
	// Retorna o filho da esquerda desta posicao
	public BTPosition<E> getLeft() { return left; }
	// Define o filho da esquerda desta posicao
	public void setLeft(BTPosition<E> v) { left = v; }
	// Retorna o filho da direita desta posicao
	public BTPosition<E> getRight() { return right; }
	// Define o filho da direita desta posicao
	public void setRight(BTPosition<E> v) { right = v; }
	// Retorna o pai desta posicao
	public BTPosition<E> getParent() { return parent; }
	// Define o pai desta posicao
	public void setParent(BTPosition<E> v) { parent = v; }
}

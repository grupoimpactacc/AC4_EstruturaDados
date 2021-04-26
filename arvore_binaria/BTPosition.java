package arvore_binaria;
import position.Position;

public interface BTPosition<E> extends Position<E> {
	public E element();
	// Define o elemento armazenado nesta posicao
	public void setElement(E o);
	// Retorna o filho da esquerda desta posicao
	public BTPosition<E> getLeft();
	// Define o filho da esquerda desta posicao
	public void setLeft(BTPosition<E> v);
	// Retorna o filho da direita desta posicao
	public BTPosition<E> getRight();
	// Define o filho da direita desta posicao
	public void setRight(BTPosition<E> v);
	// Retorna o pai desta posicao
	public BTPosition<E> getParent();
	// Define o pai desta posicao
	public void setParent(BTPosition<E> v);
}

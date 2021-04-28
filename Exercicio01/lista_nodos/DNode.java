package lista_nodos;

public class DNode<Type> implements Position<Type> {
	private DNode<Type> prev, next;
	private Type element;
	
	public DNode(DNode<Type> newPrev, DNode<Type> newNext, Type elem) {
		prev = newPrev;
		next = newNext;
		element = elem;
	}
	
	public Type element() throws InvalidPositionException{
		if ((prev == null) && (next == null))
			throw new InvalidPositionException("Posição não está na lista");
		return element;
	}
	
	public DNode<Type> getNext() { return next;}
	public DNode<Type> getPrev() {return prev;}
	public Type getElement() { return element;}
	public void setNext(DNode<Type> newNext) {next = newNext;}
	public void setPrev(DNode<Type> newPrev) {prev = newPrev;}
	public void setElement(Type newElement) {element = newElement;}
	
}
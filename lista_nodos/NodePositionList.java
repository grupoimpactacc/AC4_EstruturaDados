package lista_nodos;

import java.util.Iterator;

public class NodePositionList<Type> implements PositionList<Type> {
	protected int numElts;
	protected DNode<Type> header, trailer;
	
	public NodePositionList() {
		header = new DNode<Type>(null, null, null);
		trailer = new DNode<Type>(header, null, null);
		header.setNext(trailer);
		numElts = 0;
	}
	
	protected DNode<Type> checkPosition(Position<Type> p) throws InvalidPositionException{
		if (p == null) throw new InvalidPositionException("Null position passed to NodeList");
		if (p == header) throw new InvalidPositionException("The header node is not a valid position");
		if (p == trailer) throw new InvalidPositionException("The trailer node is not a valid position");
		try {
			DNode<Type> temp = (DNode<Type>) p;
			if ((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return temp;	
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}
	
	public int size() {return numElts;}
	public boolean isEmpty() {return (numElts == 0);}
	public Position<Type> first() throws EmptyListException {
		if (isEmpty()) throw new EmptyListException("List is empty");
		return header.getNext();
	}
	
	public Position<Type> prev(Position<Type> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<Type> v = checkPosition(p);
		DNode<Type> prev = v.getPrev();
		if (prev == header) throw new BoundaryViolationException("Cannot advance past the beginning of the list");
		return prev;		
	}
	
	public void addBefore(Position<Type> p, Type element) throws InvalidPositionException{
		DNode<Type> v = checkPosition(p);
		numElts++;
		DNode<Type> newNode = new DNode<Type>(v.getPrev(), v, element);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}
	
	public void addFirst(Type element) {
		numElts++;
		DNode<Type> newNode = new DNode<Type>(header, header.getNext(), element);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
	}
	
	public Type remove(Position<Type> p) throws InvalidPositionException{
		DNode<Type> v = checkPosition(p);
		numElts++;
		DNode<Type> vPrev = v.getPrev();
		DNode<Type> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		Type vElem = v.element();
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}
	
	public Type set(Position<Type> p, Type element) throws InvalidPositionException{
		DNode<Type> v = checkPosition(p);
		Type oldElt = v.element();
		v.setElement(element);
		return oldElt;
	}
	
	public void makeFirst(Position<Type> p) throws InvalidPositionException{
		DNode<Type> v = checkPosition(p);
		DNode<Type> vPrev = v.getPrev();
		DNode<Type> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		header.getNext().setPrev(v);
		v.setNext(header.getNext());
		header.setNext(v);
		v.setPrev(header);
	}
	
	public Position<Type> last(){
		if (isEmpty()) throw new EmptyListException("List is empty");
		return trailer.getPrev();
	}
	
	public Position<Type> next(Position<Type> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<Type> v = checkPosition(p);
		DNode<Type> next = v.getNext();
		if (next == trailer) throw new BoundaryViolationException("Cannot....");
		return next;
	}
	
	public void addLast(Type element) {
		numElts++;
		DNode<Type> newNode = new DNode<Type>(trailer.getPrev(), trailer, element);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}
	
	public void addAfter(Position<Type> p, Type element) throws InvalidPositionException{
		DNode<Type> v = checkPosition(p);
		numElts++;
		DNode<Type> newNode = new DNode<Type>(v, v.getNext(), element);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
	}

	public static <Type> String toString(PositionList<Type> l) {
		String s = "";
		for (Type i: l) { s += ", " + i; }
		s = (s.length() == 0 ? s : s.substring(2));
		return "[" + s + "]";
	}
	public Iterator<Type> iterator() { return new ElementIterator<Type>(this); }
	public String toString() { return toString(this); }
	
	
}


package lista_nodos;
import java.util.Iterator;

public interface PositionList<Type> extends Iterable<Type> {
	public int size();
	public boolean isEmpty();
	public Position<Type> first();
	public Position<Type> last();
	public Position<Type> next(Position<Type> p) throws InvalidPositionException, BoundaryViolationException;
	public Position<Type> prev(Position<Type> p) throws InvalidPositionException, BoundaryViolationException;
	public void addFirst(Type element); 	
	public void addLast(Type element);
	public void addAfter(Position<Type> p, Type element) throws InvalidPositionException;
	public void addBefore(Position<Type> p, Type element) throws InvalidPositionException;
	public Type remove(Position<Type> p) throws InvalidPositionException;
	public Type set(Position<Type> p, Type newElement) throws InvalidPositionException;
	public Iterator<Type> iterator();
	public void makeFirst(Position<Type> p) throws InvalidPositionException;
}
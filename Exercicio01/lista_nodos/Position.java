package lista_nodos;

public interface Position<Type> {
	public Type element() throws InvalidPositionException;
}

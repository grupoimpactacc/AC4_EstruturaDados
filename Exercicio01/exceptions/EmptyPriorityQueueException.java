package exceptions;

// Sera utilizada quando a fila de prioridade estiver vazia
@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException {
	public EmptyPriorityQueueException(String error) {
		super(error);
	}
}

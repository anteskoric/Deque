package deque;

/**
 * @author Ante Skoric, Timo Quednau
 * This class is a RunTime exception used in the class deque.
 */
public class DequeueEmptyException extends RuntimeException{
    public DequeueEmptyException(){ super(); }
    public DequeueEmptyException(String s){ super(s); }
}

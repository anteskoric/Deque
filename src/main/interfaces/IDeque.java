package interfaces;

import java.util.NoSuchElementException;
/**
 * An interface for a simple Deque with fewer Methods than
 * {@link java.util.Deque}.
 * @author Bernd Kahlbrandt
 *
 * @param <E>
 */
public interface IDeque<E> {
    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param e the element to add
     */
    void addFirst(E e);

    /**
     * Inserts the specified element at the end of this deque.
     *
     */
    void addLast(E e);
    /**
     * Retrieves and removes the first element of this deque.     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeFirst() throws NoSuchElementException;

    /**
     * Retrieves and removes the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeLast();
    /**
     * Retrieves, but does not remove, the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getFirst();

    /**
     * Retrieves, but does not remove, the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getLast();
    /**
     * Checks if this deque is empty.
     * @return true, if this deque is empty, false otherwise.
     */
    boolean isEmpty();
}

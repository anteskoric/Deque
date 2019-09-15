package deque;

import interfaces.IDeque;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Ante Skoric, Timo Quednau
 * This class represents a deque.
 */
public class Deque<E> implements IDeque<E> {
    /**
     * Represents the first element of the deque(the head).
     */
    private Node<E> head;
    /**
     * Represents the size of the deque.
     */
    private int size;

    /**
     * Class Node used in the class Deque, only the class Deque can access the class.
     */
    private static class Node<E> {
        /**
         * The value of the node.
         */
        private E element;
        /**
         * The previous node.
         */
        private Node<E> previous;
        /**
         * The next node.
         */
        private Node<E> next;

        private Node(Node<E> previous, E element, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(element, node.element) &&
                    Objects.equals(previous.element, node.previous.element) &&
                    Objects.equals(next.element, node.next.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, previous.element, next.element);
        }
    }

    /**
     * Adds element on the head position of the deque.
     *
     * @param element is the head of the typ E.
     */
    @Override
    public void addFirst(E element) {
        Node<E> firstNode = new Node<>(null, element, null);
        if (this.head == null) {
            this.head = firstNode;
            this.head.next = firstNode;
            this.head.previous = firstNode;
        } else {
            Node<E> newFirstNode = new Node<>(this.head.previous, element, this.head);
            this.head.previous.next = newFirstNode;
            this.head.previous = newFirstNode;
            this.head = newFirstNode;
        }
        size++;
    }

    /**
     * Adds element on the last position of the deque.
     *
     * @param element is the head of the typ E.
     */
    @Override
    public void addLast(E element) {
        Node<E> lastNode = new Node<>(null, element, null);
        if (this.head == null) {
            this.head = lastNode;
            this.head.next = lastNode;
            this.head.previous = lastNode;
        } else {
            Node<E> newLastNode = new Node<>(this.head.previous, element, this.head);
            this.head.previous.next = newLastNode;
            this.head.previous = newLastNode;
        }
        size++;
    }

    /**
     * Removes and retrieves the head of the deque.
     *
     * @return the head of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        final E first = this.head.element;
        this.head = new Node<>(this.head.previous, this.head.next.element, this.head.next.next);
        size--;
        return first;
    }

    /**
     * Removes and retrieves the last element of the deque.
     *
     * @return the last element of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeLast() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        final E last = this.head.previous.element;
        this.head.previous = new Node<>(this.head.previous.previous.previous, this.head.previous.previous.element, this.head);
        size--;
        return last;
    }

    /**
     * Retrieves the first element of the deque, without removing it.
     *
     * @return the head of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        return this.head.element;
    }

    /**
     * Retrieves the last element of the deque, without removing it.
     *
     * @return the last element of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getLast() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        return this.head.previous.element;
    }

    /**
     * Returns the size of the deque.
     *
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the deque contains elements.
     *
     * @return true if the deque is empty.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Iterates all elements of the deque and returns it in a form of string.
     *
     * @return String.
     */
    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        elements.append("[ ");
        for (int i = 0; i < size; i++) {
            elements.append(this.head.element).append(" ");
            this.head = this.head.next;
        }
        elements.append("]");
        return elements.toString();
    }

    /**
     * Return true if the two objects are equal.
     *
     * @param o is the object that we want to compare.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deque)) return false;
        Deque<?> deque = (Deque<?>) o;
        return size == deque.size &&
                Objects.equals(head, deque.head);
    }

    /**
     * Returns the hashCode.
     *
     * @return int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }
}
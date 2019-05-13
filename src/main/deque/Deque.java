package deque;

import interfaces.IDeque;

import java.util.NoSuchElementException;

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

    public Deque() {
    }

    /**
     * Class Node used in the class Deque, only the class Deque can access the class.
     */
    private static class Node<E>{
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

        private Node(Node<E> previous,E element, Node<E> next){
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
    /**
     * Adds head on the head position of the deque.
     * @param element is the head of the typ E.
     */
    @Override
    public void addFirst (E element){
        Node<E> firstNode = new Node<>(null,element,null);
        if(this.head == null){
            this.head = firstNode;
            this.head.next = firstNode;
            this.head.previous = firstNode;
        }else{
            Node<E> newFirstNode = new Node<>(this.head.previous,element,this.head);
            this.head.previous.next = newFirstNode;
            this.head.previous = newFirstNode;
            this.head = newFirstNode;
        }
        size++;
    }

    /**
     * Adds head on the last position of the deque.
     * @param element is the head of the typ E.
     */
    @Override
    public void addLast (E element){
        Node<E> lastNode = new Node<>(null,element,null);
        if(this.head == null){
            this.head = lastNode;
            this.head.next = lastNode;
            this.head.previous = lastNode;
        }else{
            Node<E> newLastNode = new Node<>(this.head.previous,element,this.head);
            this.head.previous.next = newLastNode;
            this.head.previous = newLastNode;
        }
        size++;
    }

    /**
     * Removes and retrieves the head of the deque.
     * @return the head of the deque
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeFirst () throws NoSuchElementException {

        size--;
        return null;
    }

    /**
     * Removes and retrieves the last head of the deque.
     * @return the last head of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeLast () throws NoSuchElementException {
        size--;
        return null;
    }

    /**
     * Retrieves the head head of the deque, without removing it.
     * @return the head head of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    //TODO do i need to check if it is empty?
    public E getFirst () throws NoSuchElementException {
        return this.head.element;
    }

    /**
     * Retrieves the last head of the deque, without removing it.
     * @return the last head of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    //TODO do i need to check if it is empty?
    @Override
    public E getLast ()throws NoSuchElementException {
        return this.head.previous.element;
    }

    /**
     * Checks if the deque contains elements.
     * @return true if the deque is empty.
     */
    @Override
    public String toString(){
        String elements = this.head + "";
        return elements;
    }

    /**
     * Returns the size of the deque.
     * @return size.
     */
    public int size(){
        return size;
    }

    /**
     * Check if the deque is empty.
     * @return boolean.
     */
    @Override
    public boolean isEmpty () {
        return this.head == null;
    }
}

package deque;

import interfaces.IDeque;

import java.util.NoSuchElementException;

/**
 * @author Ante Skoric, Timo Quednau
 * This class represents a deque.
 */
public class Deque<E> implements IDeque<E> {

    private Node<E> first;
    private int size;

    public Deque() {
    }

    static private class Node<E>{
        private E element;
        private Node<E> previous;
        private Node<E> next;

        private Node(Node<E> previous,E element, Node<E> next){
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
    /**
     * Adds first on the first position of the deque.
     * @param element is the first of the typ E.
     */
    @Override
    public void addFirst (E element){
        Node<E> node = new Node<>(null,element,this.first);
        if(this.first != null){
            this.first.previous = node;
        }
        this.first = node;
        size++;
    }

    /**
     * Adds first on the last position of the deque.
     * @param element is the first of the typ E.
     */
    @Override
    public void addLast (E element){
        Node<E> node = new Node<>(this.first,element,null);
        if(this.first != null){
            this.first.next = node;
        }
        this.first = node;
        size++;
    }

    /**
     * Removes and retrieves the first first of the deque.
     * @return the head of the deque
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeFirst () throws NoSuchElementException {
        size--;
        return null;
    }

    /**
     * Removes and retrieves the last first of the deque.
     * @return the last first of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E removeLast () throws NoSuchElementException {
        size--;
        return null;
    }

    /**
     * Retrieves the first first of the deque, without removing it.
     * @return the first first of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getFirst () throws NoSuchElementException {
        return this.first.element;
    }

    /**
     * Retrieves the last first of the deque, without removing it.
     * @return the last first of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getLast ()throws NoSuchElementException {
        return null;
    }

    /**
     * Checks if the deque contains elements.
     * @return true if the deque is empty.
     */
    @Override
    public String toString(){
        String elements = this.first + "";
        return elements;
    }
    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }
}

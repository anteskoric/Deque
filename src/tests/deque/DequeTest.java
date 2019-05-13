package deque;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest{
    private Deque<Integer> emptyDeque = new Deque<>();
    private Deque<Integer> dequeOne = new Deque<>();

    /**
     * Tests the method addFirst of the class Deque.
     */
    @Test
    void addFirst() {
        dequeOne.addFirst(1);
        assertEquals(1, dequeOne.getFirst());
        dequeOne.addFirst(2);
        dequeOne.addFirst(3);
        assertEquals(3,dequeOne.getFirst());
    }

    /**
     * Tests the method addLast of the class Deque.
     */
    @Test
    void addLast() {
        assertNull(emptyDeque.getLast());
        dequeOne.addLast(1);
        assertEquals(1,dequeOne.getLast());
        dequeOne.addFirst(2);
        assertEquals(1,dequeOne.getLast());
        dequeOne.addLast(2);
        dequeOne.addLast(3);
        assertEquals(3,dequeOne.getLast());
    }

    /**
     * Tests the method removeFirst of the class Deque.
     */
    @Test
    void removeFirst() {
        dequeOne.addFirst(2);
        dequeOne.addFirst(1);
        dequeOne.addLast(3);
        dequeOne.addLast(4);
        dequeOne.removeFirst();
        assertEquals(2,dequeOne.getFirst());
        assertEquals(2,dequeOne.removeFirst());
        assertThrows(NoSuchElementException.class,()-> emptyDeque.removeFirst());
    }

    /**
     * Tests the method removeLast of the class Deque.
     */
    @Test
    void removeLast() {
        dequeOne.addFirst(1);
        dequeOne.addLast(2);
        dequeOne.addLast(3);
        assertEquals(3,dequeOne.removeLast());
        dequeOne.removeLast();
        assertEquals(1,dequeOne.getLast());
        assertThrows(NoSuchElementException.class,()->emptyDeque.removeLast());
    }

    /**
     * Tests the method getFirst of the class Deque.
     */
    @Test
    void getFirst() {
        assertThrows(NoSuchElementException.class,()->emptyDeque.getFirst());
        dequeOne.addFirst(1);
        assertEquals(1,dequeOne.getFirst());
    }

    /**
     * Tests the method getLast of the class Deque.
     */
    @Test
    void getLast() {
        assertThrows(NoSuchElementException.class,()->emptyDeque.removeLast());
        dequeOne.addLast(1);
        assertEquals(1,dequeOne.getLast());
    }

    /**
     * Tests the method isEmpty of the class Deque.
     */
    @Test
    void isEmpty() {
        dequeOne.addFirst(1);
        assertTrue(emptyDeque.isEmpty());
        assertFalse(dequeOne.isEmpty());
    }
}
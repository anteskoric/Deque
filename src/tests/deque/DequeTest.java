package deque;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ante Skoric, Timo Quednau
 * The test test the class Deque.
 */
class DequeTest{
    private Deque<Integer> emptyDeque = new Deque<>();
    private Deque<Integer> dequeOne = new Deque<>();
    private Deque<Integer> dequeTwo = new Deque<>();

    /**
     * Tests the method addFirst of the class Deque.
     */
    @Test
    void addFirst() {
        dequeOne.addFirst(1);
        assertEquals(1, dequeOne.getFirst());
        dequeOne.addLast(2);
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
        dequeOne.addLast(1);
        assertEquals(1,dequeOne.getLast());
        dequeOne.addFirst(2);
        assertEquals(1,dequeOne.getLast());
        dequeOne.addLast(2);
        dequeOne.addLast(3);
        assertEquals(3,dequeOne.getLast());
    }

    /**
     * Test if the head has a reference on the last element
     */
    @Test
    void referenceLast(){
        dequeOne.addFirst(1);
        assertSame(dequeOne.getFirst(),dequeOne.getLast());
        dequeTwo.addLast(2);
        assertSame(dequeTwo.getFirst(),dequeTwo.getLast());
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
    /**
     * Tests the equals method of the class.
     */
    @Test
    void equals(){
        Deque<Integer> dequeIntOne = new Deque<>();
        dequeIntOne.addFirst(1);
        dequeIntOne.addLast(2);
        dequeIntOne.addFirst(1);
        dequeIntOne.addFirst(3);
        dequeIntOne.addFirst(4);
        Deque<Integer> dequeIntTwo = new Deque<>();
        dequeIntTwo.addFirst(1);
        dequeIntTwo.addLast(2);
        dequeIntTwo.addFirst(1);
        dequeIntTwo.addFirst(3);
        dequeIntTwo.addFirst(4);
        assertTrue(dequeIntOne.equals(dequeIntTwo));
        Deque<Integer> dequeEmptyTwo = new Deque<>();
        assertTrue(emptyDeque.equals(dequeEmptyTwo));
    }
    /**
     * Tests the hashCode of the objects
     */
    @Test
    void testHashCode(){
        Deque<Integer> dequeHashOne = new Deque<>();
        Deque<Integer> dequeHashTwo = new Deque<>();
        dequeHashOne.addFirst(1);
        dequeHashTwo.addFirst(1);
        final int hashCodeOne = dequeHashOne.hashCode();
        final int hashCodeTwo = dequeHashTwo.hashCode();
        assertEquals(hashCodeOne,hashCodeTwo);
    }
    /**
     * Tests the size method of the class.
     */
    @Test
    void size(){
        dequeTwo.addFirst(1);
        assertEquals(1,dequeTwo.size());
        assertEquals(0,emptyDeque.size());
    }
}
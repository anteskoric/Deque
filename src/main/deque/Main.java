package deque;

/**
 * @author Ante Skoric, Timo Quednau
 * This class exicutes the code of the class Deque.
 */
public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println(deque);
        deque.addFirst(1);
        System.out.println(deque);
        deque.addFirst(2);
        System.out.println(deque);
        deque.addFirst(3);
        System.out.println(deque);
        deque.addLast(4);
        System.out.println(deque);
    }
}

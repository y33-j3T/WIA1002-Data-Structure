package labtest3q1;

import java.util.LinkedList;

public class GenericQueue<E> {

    private java.util.LinkedList<E> list = new java.util.LinkedList<>();
    
    public void enqueue(E e) {
        list.addLast(e);
    }
    
    public E dequeueLast() {
        return list.removeLast();
    }

    public E dequeue() {
        return list.removeFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E peek() {
        return list.getFirst();
    }
    
    public E peekLast() {
        return list.getLast();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}

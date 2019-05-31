package l9q1;

import java.util.Arrays;
import java.util.LinkedList;

public class MyQueue<E> {

    private LinkedList<E> list;

    public MyQueue(E[] e) {
        list = new LinkedList<>(Arrays.asList(e));
    }

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MyQueue<String> fruitQ = new MyQueue(new Object[]{"Durian", "Blueberry"});
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        System.out.println(fruitQ);
        System.out.println(fruitQ.peek());
        System.out.println(fruitQ.getSize());
        fruitQ.dequeue();
        System.out.println(fruitQ.getElement(2));
        System.out.println(fruitQ.contains("Cherry"));
        System.out.println(fruitQ.contains("Durian"));
        System.out.println(fruitQ.isEmpty());
    }
}

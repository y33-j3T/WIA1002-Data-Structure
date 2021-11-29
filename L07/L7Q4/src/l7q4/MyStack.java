package l7q4;

import java.util.ArrayList;

public class MyStack<E> {

    private ArrayList<E> list = new ArrayList<>();

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    public boolean search(E o) {
        for (E item : list) {
            if (item.equals(o)) {
                return true;
            }
        }
        return false;
    }
}

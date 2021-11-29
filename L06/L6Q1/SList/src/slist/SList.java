package slist;

public class SList<E> {

    int size = 0;
    SNode<E> head = null;
    SNode<E> tail = null;

    public void appendEnd(E e) {
        if (tail == null) {
            head = tail = new SNode(e);
        } else {
            tail.next = new SNode(e);
            tail = tail.next;
        }
        size++;
    }

    public E removeInitial() {
        if (size == 0) {
            return null;
        } else {
            SNode<E> temp = head;
            head = head.next;
            size--;
            return temp.element;
        }
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void clear() {
        SNode<E> temp;
        while(head != null) {
            temp = head.next;
            head.next = null;
            head = temp;
        }
        size = 0;
        System.out.println("The list is empty");
    }
    
    public void display() {
        SNode<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }
}

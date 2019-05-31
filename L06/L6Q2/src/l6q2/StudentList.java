package l6q2;

public class StudentList<E> {

    int size = 0;
    Node<E> head = null;
    Node<E> tail = null;

    public void add(E e) {
        if (size == 0) {
            head = tail = new Node(e);
            size++;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
            size++;
        }
    }

    public int indexOf(E e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            // store element to delete
            Node<E> temp = head;

            // reset
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            // iterate to element before tail
            Node<E> current = head;
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }

            // store element to delete
            Node<E> temp = tail;

            // set the element before tail as the new tail
            tail = current;

            // reset for next of tail to be null
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = temp.next;
            temp.next = null;
            size--;
            return temp.element;
        }
    }

    public void removeElement(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                remove(i);
            }
            current = current.next;
        }
    }

    public void printList() {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element);
            System.out.print(i == size - 1 ? "." : ", ");
            current = current.next;
        }
        System.out.println();
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                return true;
            }
        }
        return false;
    }

    public void replace(E e, E newE) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                current.element = newE;
                break;
            }
            current = current.next;
        }
    }
}

package l5q1;

public class MyLinkedList<E> {

    int size = 0;
    Node<E> head = null;
    Node<E> tail = null;

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            // no nodes exist
            tail = head;
        }
    }

    public void addLast(E e) {
        if (tail == null) {
            // no node exists
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
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
            current.next = (current.next).next;
            size--;
            return temp.element;
        }
    }

    public void add(E e) {
        if (size == 0) {
            addFirst(e);
        } else {
            addLast(e);
        }
    }

    public boolean contains(E e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E getFirst() {
        return head.element;
    }

    public E getLast() {
        return tail.element;
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

    public int lastIndexOf(E e) {
        int lastIndex = -1;
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                lastIndex = i;
            }
            current = current.next;
        }

        return lastIndex;
    }

    public E set(int index, E e) {
        add(index, e);
        return remove(index + 1);
    }

    public void clear() {
        while (size != 0) {
            removeFirst();
        }
    }

    public void print() {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    public void reverse() {
        Node<E> current = head;
        E[] arr = (E[]) new Object[size];

        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }

        for (int i = size - 1; i > -1; i--) {
            System.out.println(arr[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public E getMiddleValue() {
        return get((size - 1) / 2);
    }
}

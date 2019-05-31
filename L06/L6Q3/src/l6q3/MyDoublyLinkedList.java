package l6q3;

public class MyDoublyLinkedList<E> {

    int size;
    Node<E> head;
    Node<E> tail;

    public MyDoublyLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E element) {
        // create object tmp and set pointer of the new node
        Node<E> tmp = new Node(element, head, null);

        // set head.prev of current head to be linked to the new node
        if (head != null) {
            head.prev = tmp;
        }

        // now tmp becomes head
        head = tmp;

        // if no tail, them tmp set to be tail
        if (tail == null) {
            tail = tmp;
        }

        // increase number of node
        size++;
        System.out.println("adding: " + element);
    }

    public void addLast(E element) {
        // create object tmp and set pointer for the previous node
        Node<E> tmp = new Node(element, null, tail);

        // set tail.next to point to object tmp
        if (tail != null) {
            tail.next = tmp;
        }

        // now tmp becomes tail
        tail = tmp;

        // if no head, them tmp set to be a head
        if (head == null) {
            head = tmp;
        }

        // increase number of node
        size++;
        System.out.println("adding: " + element);
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            System.out.println("Error: Index out of bounds. Can't add.");
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            /* set from head and begin traverse
             * stop at required position */
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            /* create object inser and set pointer of the next pointer
             * to the temp node and also set pointer of the prev pointer 
             * to the temp.prev node */
            Node<E> insert = new Node(element, temp, temp.prev);

            // set pointer 'next' of the node temp.prev to new node insert
            temp.prev.next = insert;

            // set pointer 'prev' of the node temp to new node insert
            temp.prev = insert;
            size++;
            System.out.println("adding: " + insert.element);
        }
    }

    public void iterateForward() {
        System.out.println("iterating forward...");
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void iterateBackward() {
        System.out.println("iterating backward...");
        Node<E> current = tail;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public E removeFirst() {
        if (size == 0) {
            System.out.println("Error: No first node. Nothing to remove.");
            return null;
        }

        // copy head to node tmp
        Node<E> tmp = head;

        // head.next become a head
        head = head.next;

        // set pointer of prev of new head to be null
        head.prev = null;

        // set pointer of next of tmp to be null
        tmp.next = null;

        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    public E removeLast() {
        if (size == 0) {
            System.out.println("Error: No last node. Nothing to remove.");
            return null;
        }

        // copy tail to node tmp
        Node<E> tmp = tail;

        // tail.prev become a tail
        tail = tail.prev;

        // set pointer of prev of tmp to be null
        tmp.prev = null;

        // set pointer of next of tail to be null
        tail.next = null;

        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bounds. Can't remove.");
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.next.prev = current.prev;
            current.prev.next = current.next;
            current.next = null;
            current.prev = null;

            System.out.println("deleted: " + current.element);
            return current.element;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        System.out.println("successfully clear " + this.getSize() + " node(s)");
        Node<E> temp = head;
        while (head != null) {
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        tail = null;
        size = 0;
    }

    public void printSize() {
        System.out.println("size of current Doubly Linked List: " + this.size);
    }
}

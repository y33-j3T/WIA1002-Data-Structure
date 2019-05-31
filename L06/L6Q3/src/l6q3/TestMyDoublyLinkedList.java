package l6q3;

public class TestMyDoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(10);
        list.addLast(100);
        list.add(2, 2);
        list.remove(3);
        System.out.println();
        
        list.iterateForward();
        list.iterateBackward();
        list.printSize();
        list.clear();
        System.out.println();
        
        list.printSize();
    }
    
}

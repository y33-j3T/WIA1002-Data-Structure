package l5q1;

public class TestLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');

        list.print();

        list.reverse();

        System.out.println(list.getSize());

        System.out.println(list.getFirst());

        System.out.println(list.getLast());

        list.remove(list.getSize() / 2);

        System.out.println(list.indexOf('b'));

        System.out.println(list.indexOf('d'));

        System.out.println(list.contains('c'));
    }
}

package l4q5;

public class ArrayBagDemo<T> extends ArrayBag<T> {

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        for (String str : content) {
            aBag.add(str);
        }

        Object[] src = aBag.toArray();
        String[] dest = new String[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);

        System.out.print("Adding ");
        for (String items : dest) {
            System.out.print(items + " ");
        }
        System.out.println();
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows: ");
        Object[] src = aBag.toArray();
        String[] dest = new String[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        for (String items : dest) {
            System.out.print(items + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        System.out.println("bag1: ");
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);

        System.out.println("bag2: ");
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);

        ArrayBag<String> bag3 = (ArrayBag<String>) bag1.union(bag2);
        System.out.println("bag3, test the method union of bag1 and bag2: ");
        displayBag(bag3);

        System.out.println("bag4, test the method intersection of bag1 and bag2: ");
        ArrayBag<String> bag4 = (ArrayBag<String>) bag1.intersection(bag2);
        displayBag(bag4);

        System.out.println("bag5, test the method difference of bag1 and bag2: ");
        ArrayBag<String> bag5 = (ArrayBag<String>) bag1.difference(bag2);
        displayBag(bag5);
    }

}

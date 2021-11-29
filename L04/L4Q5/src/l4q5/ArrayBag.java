package l4q5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArrayBag<T> implements BagInterface<T> {

    private int DEFAULT_CAPACITY = 25;
    private T[] bag = (T[]) new Object[DEFAULT_CAPACITY];
    private int numberOfEntries;

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == 25;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (numberOfEntries < DEFAULT_CAPACITY) {
            numberOfEntries++;
            bag[numberOfEntries - 1] = newEntry;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        if (numberOfEntries != 0) {
            Random r = new Random();
            int selectedIndex = r.nextInt(numberOfEntries);
            T result = bag[selectedIndex];
            bag[selectedIndex] = null;

            for (int i = selectedIndex; i < numberOfEntries; i++) {
                bag[i] = bag[i + 1];
            }

            numberOfEntries--;
            return result;
        }
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        if (numberOfEntries != 0) {
            for (int i = 0; i < numberOfEntries; i++) {
                if (bag[i] == anEntry) {
                    bag[i] = null;

                    for (int j = i; j < numberOfEntries; j++) {
                        bag[j] = bag[j + 1];
                    }

                    numberOfEntries--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(bag, null);
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry == bag[i]) {
                freq++;
            }
        }
        return freq;
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i] == anEntry) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] resultArr = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultArr, 0, numberOfEntries);
        return resultArr;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        ArrayBag<T> newBag = new ArrayBag();
        for (int i = 0; i < this.toArray().length; i++) {
            newBag.add((T) Array.get(this.toArray(), i));
        }
        for (int i = 0; i < anotherBag.toArray().length; i++) {
            newBag.add((T) Array.get(anotherBag.toArray(), i));
        }
        return newBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        BagInterface<T> newBag = new ArrayBag<>();

        BagInterface<T> bag1;
        BagInterface<T> bag2;

        // assign smaller bag to bag1, bigger bag to bag2
        if (this.getCurrentSize() <= anotherBag.getCurrentSize()) {
            bag1 = this;
            bag2 = anotherBag;
        } else {
            bag1 = anotherBag;
            bag2 = this;
        }

        for (int i = 0; i < bag1.getCurrentSize(); i++) {
            if (!newBag.contains(bag1.toArray()[i])) {
                if ((bag1.getFrequencyOf(bag1.toArray()[i])) != 0 && bag2.getFrequencyOf(bag1.toArray()[i]) != 0) {
                    if ((bag1.getFrequencyOf(bag1.toArray()[i])) <= bag2.getFrequencyOf(bag1.toArray()[i])) {
                        for (int j = 0; j < bag1.getFrequencyOf(bag1.toArray()[i]); j++) {
                            newBag.add(bag1.toArray()[i]);
                        }
                    } else {
                        for (int j = 0; j < bag2.getFrequencyOf(bag1.toArray()[i]); j++) {
                            newBag.add(bag1.toArray()[i]);
                        }
                    }
                }
            }
        }

        return newBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        // get intersection of two bags
        T[] commonItems = (T[]) this.intersection(anotherBag).toArray();
        BagInterface<T> newBag = new ArrayBag<>();

        // copy all items from 'this' bag to newBag
        for (int i = 0; i < this.toArray().length; i++) {
            newBag.add(this.toArray()[i]);
        }

        // remove intersect items from new bag
        for (T commonItem : commonItems) {
            newBag.remove(commonItem);
        }

        return newBag;
    }

    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag();
        ArrayBag<String> bag2 = new ArrayBag();

        // test public BagInterface<T> union(BagInterface<T> anotherBag)
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        BagInterface<String> everything = bag1.union(bag2);

        Object[] src = everything.toArray();
        String[] dest = new String[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);

        Arrays.sort(dest);
        System.out.println(Arrays.toString(dest));

        // test BagInterface<T> intersection(BagInterface<T> anotherBag)
        bag1.add("b");
        BagInterface<String> commonItems = bag1.intersection(bag2);

        Object[] src1 = commonItems.toArray();
        String[] dest1 = new String[src1.length];
        System.arraycopy(src1, 0, dest1, 0, src1.length);

        Arrays.sort(dest1);
        System.out.println(Arrays.toString(dest1));

        // test BagInterface<T> difference(BagInterface<T> anotherBag)
        bag1.remove("b");
        BagInterface leftOver1 = bag1.difference(bag2);
        BagInterface leftOver2 = bag2.difference(bag1);

        Object[] src2 = leftOver1.toArray();
        String[] dest2 = new String[src2.length];
        System.arraycopy(src2, 0, dest2, 0, src2.length);

        Object[] src3 = leftOver2.toArray();
        String[] dest3 = new String[src3.length];
        System.arraycopy(src3, 0, dest3, 0, src3.length);

        Arrays.sort(dest2);
        Arrays.sort(dest3);
        System.out.println(Arrays.toString(dest2));
        System.out.println(Arrays.toString(dest3));
    }
}

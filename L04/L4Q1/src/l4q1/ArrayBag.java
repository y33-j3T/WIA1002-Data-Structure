package l4q1;

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

    public static void main(String args[]) {
        ArrayBag<String> a = new ArrayBag();
        a.add("apple");
        a.add("apple");
        a.add("banana");        
        a.remove();
        System.out.println(a.contains("apple"));
        System.out.println(a.getFrequencyOf("apple"));
        System.out.println(Array.get(a.toArray(), 0));
        System.out.println(Arrays.toString(a.toArray()));
    }
}

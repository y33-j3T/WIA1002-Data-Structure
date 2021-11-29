package l3q1;

public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {

    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public boolean equals(StorePairGeneric<T> o){
        return this.first == o.first;
    }
    
    @Override
    public int compareTo(StorePairGeneric<T> o) {
        return this.first.compareTo(o.first);
    }
    
    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }
    
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);
        
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
    }
}

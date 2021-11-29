package l3q1;

public class StorePair {

    private int first, second;

    public StorePair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first + " second = " + second;
    }
    
    public <T extends StorePair> boolean equals(T o){
        return this.first==o.getFirst();
    }
}

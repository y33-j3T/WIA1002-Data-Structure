package l3q3;

public class CompareMax {
    
    public static <T extends Comparable> T maximum(T first, T second, T third){
        if (first.compareTo(second)> 0 && first.compareTo(third) > 0)
            return first;
        else if (second.compareTo(first) > 0 && second.compareTo(third) > 0)
            return second;
        else if (third.compareTo(first)> 0 && third.compareTo(second)> 0)
            return third;
        else
            return null;
    }
    
    public static void main(String[] args) {
        System.out.println(maximum("a", "b", "c"));
    }
    
}

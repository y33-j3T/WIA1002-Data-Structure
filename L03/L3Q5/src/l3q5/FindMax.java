package l3q5;

public class FindMax {
    
    private static class Circle implements Comparable<Circle> {
        
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle o) {
            if(this.radius>o.radius)
                return 1;
            else if (this.radius<o.radius)
                return -1;
            else 
                return 0;
        }
        
        @Override
        public String toString(){
            return Double.toString(this.radius);
        }
        
    }
    
    public static <E extends Comparable<E>> E max (E[] list){
        if(list.length!=0){
            E max = list[0];
            for (E obj : list) {
                if (obj.compareTo(max) > 0) {
                    max = obj;
                }
            }
            return max;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        Circle[] cirArr = {new Circle(3), new Circle(2.9), new Circle(5.9)};
        
        System.out.println(max(intArr));
        System.out.println(max(strArr));
        System.out.println(max(cirArr));
    }
    
}

package l3q4;

public class MinMax {
    
    public static <T extends Comparable> String minmax(T[] arr){
        if (arr.length!=0){
            T min = arr[0];
            T max = arr[0];
            
            for(int i=0 ; i<arr.length ; i++){
                if(arr[i].compareTo(min)<0)
                    min = arr[i];
                else if(arr[i].compareTo(max)>0)
                    max = arr[i];
            }
            
            return "Min = " + min.toString() + "  Max = " + max.toString();
        }
        return null;
    }
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
    
}

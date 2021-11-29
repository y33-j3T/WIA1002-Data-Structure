package l3q6;

import java.util.ArrayList;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list){
        ArrayList<E> array = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j < list[i].length; j++){
                array.add(list[i][j]);
            }
        }
        E min = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(array.get(i).compareTo(min) < 0){
                min = array.get(i);
            }
        }
        return min;
    }
    
    public static <E extends Comparable<E>> E max(E[][] list){
        ArrayList<E> array = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            for(int j = 0;j < list[i].length; j++){
                array.add(list[i][j]);
            }
        }
        E max = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(array.get(i).compareTo(max) >= 0)
                max = array.get(i);
        }
        return max;
    }
    
    public static void main(String[] args) {
        Integer[][] array = {{4, 5, 6}, {1, 2, 3}};
        System.out.println(min(array));
        System.out.println(max(array));
    }
}

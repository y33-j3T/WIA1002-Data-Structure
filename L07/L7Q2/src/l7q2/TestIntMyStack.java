package l7q2;

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MyStack<Integer> s1 = new MyStack<>();
        System.out.print("Enter an integer: ");
        int count = s.nextInt();
        for(int i=1 ; i<=count ; i++) {
            s1.push(i);
        }
        
        System.out.println("Size of stack: " + s1.getSize());
        
        System.out.println("Contents of stack: ");
        for(int i=s1.getSize() ; i>0 ; i--){
            System.out.println(s1.pop());
        }
        
    }
}

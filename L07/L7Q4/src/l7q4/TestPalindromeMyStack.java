package l7q4;

import java.util.Scanner;

public class TestPalindromeMyStack {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MyStack<Character> s1 = new MyStack<>();

        System.out.print("Enter a string: ");
        String str = s.next();
        for (int i = 0; i < str.length(); i++) {
            s1.push(str.charAt(i));
        }

        MyStack<Character> s2 = new MyStack<>();
        for (int i = s1.getSize() / 2; i > 0; i--) {
            s2.push(s1.pop());
        }

        if (str.length() % 2 != 0) {
            s1.pop();
        }

        if (s1.toString().equals(s2.toString())) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }

    }
}

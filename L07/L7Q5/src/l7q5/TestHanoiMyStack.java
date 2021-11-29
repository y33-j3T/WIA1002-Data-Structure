package l7q5;

import java.util.Scanner;

public class TestHanoiMyStack {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of disk(s): ");
        int n = s.nextInt();

        MyStack<Integer> A = new MyStack<>();
        MyStack<Integer> B = new MyStack<>();
        MyStack<Integer> C = new MyStack<>();
        for (int i = n; i > 0; i--) {
            A.push(i);
        }

        int stepsLeft = (int) (Math.pow(2, n) - 1);
        System.out.println(stepsLeft);

        // for even number of disks & for odd number of disks
        if (n % 2 == 0 && n != 0) {
            while(stepsLeft > 0) {
                if (stepsLeft > 0) {
                    // make the legal move between pegs A and B (in either direction)
                    if (A.peek() == null && B.peek() == null) {

                    } else if (A.peek() == null && B.peek() != null) {
                        A.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek() != null && B.peek() == null) {
                        B.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(B.peek()) > 0) {
                        A.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(B.peek()) < 0) {
                        B.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }

                if (stepsLeft > 0) {
                    // make the legal move between pegs A and C (in either direction)
                    if (A.peek() == null && C.peek() == null) {

                    } else if (A.peek() == null && C.peek() != null) {
                        A.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek() != null && C.peek() == null) {
                        C.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(C.peek()) > 0) {
                        A.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(C.peek()) < 0) {
                        C.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }

                if (stepsLeft > 0) {
                    // make the legal move between pegs B and C (in either direction)
                    if (B.peek() == null && C.peek() == null) {

                    } else if (B.peek() == null && C.peek() != null) {
                        B.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek() != null && C.peek() == null) {
                        C.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek().compareTo(C.peek()) > 0) {
                        B.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek().compareTo(C.peek()) < 0) {
                        C.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }
            }
        } else if (n % 2 != 0 && n != 0) {
            while(stepsLeft > 0 ) {
                if (stepsLeft > 0) {
                    // make the legal move between pegs A and C (in either direction)
                    if (A.peek() == null && C.peek() == null) {

                    } else if (A.peek() == null && C.peek() != null) {
                        A.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek() != null && C.peek() == null) {
                        C.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(C.peek()) > 0) {
                        A.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(C.peek()) < 0) {
                        C.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }
                
                if (stepsLeft > 0) {
                    // make the legal move between pegs A and B (in either direction)
                    if (A.peek() == null && B.peek() == null) {

                    } else if (A.peek() == null && B.peek() != null) {
                        A.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek() != null && B.peek() == null) {
                        B.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(B.peek()) > 0) {
                        A.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (A.peek().compareTo(B.peek()) < 0) {
                        B.push(A.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }

                if (stepsLeft > 0) {
                    // make the legal move between pegs B and C (in either direction)
                    if (B.peek() == null && C.peek() == null) {

                    } else if (B.peek() == null && C.peek() != null) {
                        B.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek() != null && C.peek() == null) {
                        C.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek().compareTo(C.peek()) > 0) {
                        B.push(C.pop());
                        display(A, B, C);
                        stepsLeft--;
                    } else if (B.peek().compareTo(C.peek()) < 0) {
                        C.push(B.pop());
                        display(A, B, C);
                        stepsLeft--;
                    }
                }
            }
        }
//        move(A, B, C, n, A, C, B);
    }

    // recursive method
    public static void move(MyStack A, MyStack B, MyStack C, int diskCount, MyStack source, MyStack target, MyStack auxiliary) {
        if (diskCount > 0) {
            move(A, B, C, diskCount - 1, source, auxiliary, target);
            target.push(source.pop());
            System.out.println(A.toString());
            System.out.println(B.toString());
            System.out.println(C.toString());
            System.out.println("###################");
            move(A, B, C, diskCount - 1, auxiliary, target, source);
        }
    }

    // iterative method
    public static void display(MyStack A, MyStack B, MyStack C) {
        System.out.println(A.toString());
        System.out.println(B.toString());
        System.out.println(C.toString());
        System.out.println("###################");
    }
}

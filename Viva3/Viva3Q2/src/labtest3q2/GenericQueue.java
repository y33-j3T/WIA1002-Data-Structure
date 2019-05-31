package labtest3q2;

import java.util.LinkedList;
import java.util.Scanner;

public class GenericQueue<E> {
    
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();
    
    public boolean contains(E e) {
        return list.contains(e);
    }
    
    public void enqueue(E e) {
        list.addLast(e);
    }
    
    public E dequeueLast() {
        return list.removeLast();
    }
    
    public E dequeue() {
        return list.removeFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E peek() {
        return list.getFirst();
    }
    
    public E peekLast() {
        return list.getLast();
    }
    
    public int getSize() {
        return list.size();
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        GenericQueue<String> queue = new GenericQueue<>();
        
        boolean dontWannaExit = true;
        do {
            System.out.println("To order = Press 1 or to exit = Press X:");
            String action = s.nextLine();
            
            if (action.equals("1")) {
                System.out.println("Please enter food");
                String order = s.nextLine();
                queue.enqueue(order);
                dontWannaExit = true;
            } else if (action.equalsIgnoreCase("X")) {
                dontWannaExit = false;
            } else {
                System.out.println("Invalid input. Please try again.");
                dontWannaExit = true;
            }
        } while (dontWannaExit);
        
        System.out.println("Food ordered: ");
        System.out.println(queue);
        
        System.out.println("First food ordered: " + queue.peek());
        
        System.out.println("Number of food ordered: " + queue.getSize());
        
        System.out.println("Deleting the first food: " + queue.dequeue());
        
        System.out.println("Enter the food you want to check from the ordered list: ");
        
        String foodToCheck = "";
        do {
            foodToCheck = s.nextLine();
            if(foodToCheck.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (foodToCheck.isEmpty());
        
        if (queue.contains(foodToCheck)) {
            System.out.println(foodToCheck + " is in the list");
        } else {
            System.out.println(foodToCheck + " is not in the list");
            
        }
    }
}

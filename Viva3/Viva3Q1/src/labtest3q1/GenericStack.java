package labtest3q1;

public class GenericStack<E> {

    private GenericQueue<E> queue = new GenericQueue<>();
    
    public void push(E element) {
        queue.enqueue(element);
    } 
    
    public E pop() {
        return queue.dequeueLast();
    }
    
    public E top() {
        return queue.peekLast();
    }
    
    public static void main(String[] args) {
        GenericStack<Integer> intStack= new GenericStack<>();
        
        System.out.println("Push 10, 20, 30 into the stack");
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        
        System.out.println("Top element is: " + intStack.top());
        
        System.out.println("Execute pop() operation");
        intStack.pop();
        
        System.out.println("Push 40 into the stack");
        intStack.push(40);
        
        System.out.println("Push 50 into the stack");
        intStack.push(50);
        
        System.out.println("Execute pop() operation");
        intStack.pop();
        
        System.out.println("Top element now is: " + intStack.top());
    }
}

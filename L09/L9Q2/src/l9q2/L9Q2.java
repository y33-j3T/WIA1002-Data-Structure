package l9q2;

public class L9Q2 {

    public static boolean isPalindromeQueue(String s) {
        
        // queue to store s
        MyQueue<Character> queue = new MyQueue<>();
        for (char ch : s.toCharArray()) {
            queue.enqueue((Character) ch);
        }
        String first = queue.toString();

        // queue to store reversed s
        MyQueue<Character> queue2 = new MyQueue<>();
        while (!queue.isEmpty()) {
            queue2.enqueue(queue.dequeue());

            if (queue2.getSize() > 1) {
                for (int i = 0; i < queue2.getSize() - 1; i++) {
                    queue2.enqueue(queue2.dequeue());
                }
            }
        }
        String second = queue2.toString();

        return first.equals(second);
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeQueue("java"));
        System.out.println(isPalindromeQueue("racecar"));
    }

}

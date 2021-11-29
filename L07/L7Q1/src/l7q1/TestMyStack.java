package l7q1;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> s = new MyStack<>();
        s.push('a');
        s.push('b');
        s.push('c');
        System.out.println(s.toString());
        System.out.println(s.search('b'));
        System.out.println(s.search('k'));
        
        MyStack<Integer> s1 = new MyStack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.toString());
        System.out.println(s1.search(6));
    }
}

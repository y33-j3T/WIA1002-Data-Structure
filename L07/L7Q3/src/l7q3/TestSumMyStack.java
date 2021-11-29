package l7q3;

public class TestSumMyStack {

    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        for (int i = 1; i <= 100; i++) {
            s.push(i);
        }

        int sum = 0;
        for (int i = s.getSize(); i > 0; i--) {
            sum += s.pop();
        }
        System.out.println(sum);
    }
}

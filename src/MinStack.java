import java.util.ArrayDeque;
import java.util.Deque;

/** Stack that returns its minimum in O(1): keep a second stack of running minimums. */
public class MinStack {
    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> mins = new ArrayDeque<>();

    public void push(int x) {
        values.push(x);
        mins.push(mins.isEmpty() ? x : Math.min(x, mins.peek()));
    }

    public int pop() {
        mins.pop();
        return values.pop();
    }

    public int top() { return values.peek(); }

    public int min() { return mins.peek(); }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(5); s.push(3); s.push(7); s.push(2);
        System.out.println(s.min()); // 2
        s.pop();
        System.out.println(s.min()); // 3
        System.out.println(s.top()); // 7
    }
}

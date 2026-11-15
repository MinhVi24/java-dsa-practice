import java.util.ArrayDeque;
import java.util.Deque;

/** Check whether the brackets ()[]{} in a string are balanced, using a stack. O(n). */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> expected = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': expected.push(')'); break;
                case '[': expected.push(']'); break;
                case '{': expected.push('}'); break;
                case ')': case ']': case '}':
                    if (expected.isEmpty() || expected.pop() != c) return false;
                    break;
                default: // other characters are ignored
            }
        }
        return expected.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[()()]}")); // true
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("(("));       // false
    }
}

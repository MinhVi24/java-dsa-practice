/** Reverse a singly linked list: iterative (O(1) space) and recursive. */
public class ReverseLinkedList {
    static class Node {
        int val;
        Node next;
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static Node of(int... values) {
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) head = new Node(values[i], head);
        return head;
    }

    static String str(Node head) {
        StringBuilder sb = new StringBuilder("[");
        for (Node n = head; n != null; n = n.next) sb.append(n.val).append(n.next != null ? " -> " : "");
        return sb.append(']').toString();
    }

    public static void main(String[] args) {
        System.out.println(str(reverse(of(1, 2, 3, 4, 5))));       // [5 -> 4 -> 3 -> 2 -> 1]
        System.out.println(str(reverseRecursive(of(10, 20, 30)))); // [30 -> 20 -> 10]
    }
}

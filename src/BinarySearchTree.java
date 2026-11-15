import java.util.ArrayList;
import java.util.List;

/** Binary search tree with insert, contains, delete and in-order traversal. */
public class BinarySearchTree {
    private static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private Node root;

    public void insert(int key) { root = insert(root, key); }

    private Node insert(Node n, int key) {
        if (n == null) return new Node(key);
        if (key < n.key) n.left = insert(n.left, key);
        else if (key > n.key) n.right = insert(n.right, key);
        return n;
    }

    public boolean contains(int key) {
        Node n = root;
        while (n != null) {
            if (key == n.key) return true;
            n = key < n.key ? n.left : n.right;
        }
        return false;
    }

    public void delete(int key) { root = delete(root, key); }

    private Node delete(Node n, int key) {
        if (n == null) return null;
        if (key < n.key) n.left = delete(n.left, key);
        else if (key > n.key) n.right = delete(n.right, key);
        else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            Node succ = n.right; // smallest key in the right subtree
            while (succ.left != null) succ = succ.left;
            n.key = succ.key;
            n.right = delete(n.right, succ.key);
        }
        return n;
    }

    public List<Integer> inOrder() {
        List<Integer> out = new ArrayList<>();
        inOrder(root, out);
        return out;
    }

    private void inOrder(Node n, List<Integer> out) {
        if (n == null) return;
        inOrder(n.left, out);
        out.add(n.key);
        inOrder(n.right, out);
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        for (int k : new int[]{50, 30, 70, 20, 40, 60, 80}) t.insert(k);
        System.out.println(t.inOrder());    // [20, 30, 40, 50, 60, 70, 80]
        t.delete(50);
        System.out.println(t.inOrder());    // [20, 30, 40, 60, 70, 80]
        System.out.println(t.contains(60)); // true
    }
}

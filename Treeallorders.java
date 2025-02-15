import java.util.*;

public class Treeallorders {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 10;
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            tree.construct_tree(s.nextInt());
        }

        System.out.println("Inorder Traversal:");
        tree.inordertraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preordertraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postordertraversal(tree.root);

        s.close();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root = null;
    Queue<Node> q = new LinkedList<>();

    void construct_tree(int data) {
        Node nn = new Node(data);
        if (root == null)
            root = nn;
        else {
            if (q.peek().left == null) {
                q.peek().left = nn;
            } else if (q.peek().right == null) {
                q.peek().right = nn;
                q.poll();
            }
        }
        q.offer(nn);
    }

    void inordertraversal(Node root) {
        if (root != null) {
            inordertraversal(root.left);
            System.out.print(root.data + " ");
            inordertraversal(root.right);
        }
    }

    void preordertraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preordertraversal(root.left);
            preordertraversal(root.right);
        }
    }

    void postordertraversal(Node root) {
        if (root != null) {
            postordertraversal(root.left);
            postordertraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    @SuppressWarnings("null")
    void levelordertraversal(int level, Node root) {
        if (root != null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0) {
            levelordertraversal(level - 1, root.left);
            levelordertraversal(level - 1, root.right);
        }
    }
}

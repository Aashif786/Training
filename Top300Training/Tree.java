public class Tree {
    public static void main(String[] args) {
        Btree t = new Btree();
        int a[] = {10,5,15,1,6,13,18};
        t.create(a);
        t.preorder();
        t.inorder();
        t.postorder();
    }
}

class Btree{
    Node root = null;

    void create(int []a){
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    void insert(int n) {
        root = insertFunction(root, n);
    }

    private Node insertFunction(Node current, int n) {
        if (current == null) {
            return new Node(n);
        }

        if (n < current.data) {
            current.left = insertFunction(current.left, n);
        } else if (n > current.data) {
            current.right = insertFunction(current.right, n);
        }
        
        return current; 
    }
    
    void preorder(){
        System.out.println("Pre Order");
        preorder(root);
    }
    
    void postorder(){
        System.out.println("\nPost Order");
        postorder(root);
    }
    
    void inorder(){
        System.out.println("\nIn Order");
        inorder(root);
    }

    void preorder(Node root){
        if (root == null) {
            return;            
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    
    void postorder(Node root){
        if (root == null) {
            return;            
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    
    void inorder(Node root){
        if (root == null) {
            return;            
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right= null;
    }
}

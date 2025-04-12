public class Tree {

    public static void main(String[] args) {
        Btree t = new Btree();
        

        
    }

}
class Btree{
    node root = null;
    void preorder(){
        if (root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void create(){

    }
}

class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data
        next = null;
    }
}
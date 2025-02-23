package DS;

public class Bst {
    public static void main(String[] args) {
        bst b1 = new bst();

        b1.root = b1.insert(45, b1.root);
        b1.root = b1.insert(56, b1.root);
        b1.root = b1.insert(51, b1.root);
        b1.root = b1.insert(69, b1.root);
        b1.root = b1.insert(53, b1.root);
        b1.root = b1.insert(11, b1.root);
        b1.root = b1.insert(19, b1.root);
        b1.root = b1.insert(99, b1.root);
        b1.root = b1.delete(69, b1.root);
        b1.preorder(b1.root);
    }
}

class node {
    int data;
    node left;
    node right;

    node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class bst {
    public node root = null;

    node insert(int d, node troot) {
        node nn = new node(d);
        if (troot == null)
            return nn;
        if (d < troot.data)
            troot.left = insert(d, troot.left);
        else if (d > troot.data)
            troot.right = insert(d, troot.right);
        return troot;
    }

    void preorder(node troot) {
        if (troot != null) {
            System.out.print(troot.data + " ");
            preorder(troot.left);
            preorder(troot.right);
        }
    }

    node delete(int key, node troot) {
        if (key < troot.data)
            troot.left = delete(key, troot.left);
        else if (key > troot.data)
            troot.right = delete(key, troot.right);
        else {
            if (troot.right == null)
                return troot.left;
            else if (troot.left == null)
                return troot.right;
            else {
                node temp = predec(troot.left);
                troot.data = temp.data;
                troot.left = delete(temp.data, troot.left);
            }
        }
        return troot;
    }

    node predec(node troot) {
        while (troot.right != null)
            troot = troot.right;

        return troot;
    }
}

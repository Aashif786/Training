class node {
    int data;
    int h;
    node left, right;

    node(int d) {
        h = 1;
        data = d;
        left = null;
        right = null;
    }
}

class bst {
    node root = null;

    int height(node troot) {
        if (troot == null)
            return 0;
        return troot.h;
    }

    int height_bf(node troot) {
        if (troot == null)
            return 0;
        return height(troot.left) - height(troot.right);
    }

    node left_rotate(node troot) {
        node x = troot.right;
        node y = x.left;

        x.left = troot;
        troot.right = y;

        troot.h = 1 + Math.max(height(troot.left), height(troot.right));
        x.h = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    node right_rotate(node troot) {
        node x = troot.left;
        node y = x.right;

        x.right = troot;
        troot.left = y;

        troot.h = 1 + Math.max(height(troot.left), height(troot.right));
        x.h = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    node insert(int d, node troot) {
        if (troot == null)
            return new node(d);

        if (d < troot.data)
            troot.left = insert(d, troot.left);
        else if (d > troot.data)
            troot.right = insert(d, troot.right);
        else
            return troot;

        troot.h = Math.max(height(troot.left), height(troot.right)) + 1;

        int hbf = height_bf(troot);

        if (hbf > 1 && d < troot.left.data) // Left-Left Case
            return right_rotate(troot);

        if (hbf > 1 && d > troot.left.data) // Left-Right Case
        {
            troot.left = left_rotate(troot.left);
            return right_rotate(troot);
        }

        if (hbf < -1 && d > troot.right.data) // Right-Right Case
            return left_rotate(troot);

        if (hbf < -1 && d < troot.right.data) // Right-Left Case
        {
            troot.right = right_rotate(troot.right);
            return left_rotate(troot);
        }

        return troot;
    }

    node delete(int key, node troot) {
        if (troot == null)
            return null;

        if (key < troot.data)
            troot.left = delete(key, troot.left);
        else if (key > troot.data)
            troot.right = delete(key, troot.right);
        else {
            if (troot.left == null)
                return troot.right;
            else if (troot.right == null)
                return troot.left;
            else {
                node temp = predec(troot.left);
                troot.data = temp.data;
                troot.left = delete(temp.data, troot.left);
            }
        }

        troot.h = 1 + Math.max(height(troot.left), height(troot.right)); // Update height

        int hbf = height_bf(troot);

        if (hbf > 1 && height_bf(troot.left) >= 0) // Left-Left Case
            return right_rotate(troot);

        if (hbf > 1 && height_bf(troot.left) < 0) // Left-Right Case
        {
            troot.left = left_rotate(troot.left);
            return right_rotate(troot);
        }

        if (hbf < -1 && height_bf(troot.right) <= 0) // Right-Right Case
            return left_rotate(troot);

        if (hbf < -1 && height_bf(troot.right) > 0) // Right-Left Case
        {
            troot.right = right_rotate(troot.right);
            return left_rotate(troot);
        }

        return troot;
    }

    node predec(node troot) {
        while (troot.right != null)
            troot = troot.right;
        return troot;
    }

    void preorder(node troot) {
        if (troot != null) {
            System.out.print(troot.data + " ");
            preorder(troot.left);
            preorder(troot.right);
        }
    }
}

public class Avl {
    public static void main(String ar[]) {
        bst b1 = new bst();
        b1.root = b1.insert(45, b1.root);
        b1.root = b1.insert(56, b1.root);
        b1.root = b1.insert(51, b1.root);
        b1.root = b1.insert(69, b1.root);
        b1.root = b1.insert(53, b1.root);
        b1.root = b1.insert(11, b1.root);
        b1.root = b1.insert(19, b1.root);
        b1.root = b1.insert(99, b1.root);
        b1.root = b1.insert(8, b1.root);
        b1.root = b1.insert(52, b1.root); // Removed duplicate insert(51)

        b1.preorder(b1.root);
    }
}

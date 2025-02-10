public class Linktry {
    public static void main(String[] args) {
        linkedlist l1 = new linkedlist();
        l1.display();
        l1.insertbeg(1);
        l1.insertbeg(2);
        l1.insertbeg(3);
        l1.insertend(99);
        l1.insertend(88);
        l1.insertmid(75, 1);
        l1.display();
    }
}

class node {
    int data;
    node next;

    public node(int d) {
        data = d;
        next = null;
    }
}

class linkedlist {
    node head = null;

    void insertbeg(int v) {
        node nn = new node(v);
        if (head == null)
            head = nn;
        else {
            nn.next = head;
            head = nn;
        }
    }

    void insertend(int v) {
        node nn = new node(v);
        if (head == null)
            insertbeg(v);
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
        }
    }

    void insertmid(int v, int pos) {
        node nn = new node(v);
        if (pos == 1)
            insertbeg(v);
        else {
            node temp = head;
            for (int i = 0; i < pos - 2; i++)
                temp = temp.next;
            nn.next = temp.next;
            temp.next = nn;
        }
    }

    void display() {
        if (head == null)
            System.out.println("Empty list");
        else {
            node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("null");
        }
    }
}
package DS;

public class stackds {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.display();
        s.pop();
        s.pop();
        s.display();
        s.pop();
        s.pop();
        s.pop();
        s.display();
        s.push(1);
        s.display();
    }
}

class stack {
    node top = null;

    void push(int data) {
        node nn = new node(data);

        if (top == null)
            top = nn;
        else {
            nn.next = top;
            top = nn;
        }
    }

    void pop() {
        if (top == null)
            System.out.println("Stack underflow");
        else {
            int val = top.data;
            top = top.next;
            System.out.println("Popped value: " + val);
        }
        return;
    }

    void display() {
        node temp = top;
        if (top == null) {
            System.out.println("Stack underflow");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        next = null;
    }
}

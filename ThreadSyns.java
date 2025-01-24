package src;

class Table {
     void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread extends Thread {
    Table t;
    int num;

    MyThread(Table t, int num) {
        this.t = t;
        this.num = num;
    }

    public void run() {
        t.printTable(num);
    }
}
public class ThreadSync {
    public static void main(String args[]) {
        Table obj = new Table();  // One object for both threads
        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 100);
        t1.start();
        t2.start();
    }
}

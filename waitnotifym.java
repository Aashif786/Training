class Table {
    private boolean isThread1Turn = true;

    synchronized void printTable(int n, boolean isThread1) {
        for (int i = 1; i <= 5; i++) {
            while (isThread1 != isThread1Turn) {
                try {
                    wait(); // Wait until it's this thread's turn
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(n * i);
            isThread1Turn = !isThread1Turn;
            notify(); // Notify the other thread to proceed
        }
    }
}

class MyThread extends Thread {
    Table t;
    int num;
    boolean isThread1;

    MyThread(Table t, int num, boolean isThread1) {
        this.t = t;
        this.num = num;
        this.isThread1 = isThread1;
    }

    public void run() {
        t.printTable(num, isThread1);
    }
}

public class waitnotifym {
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread t1 = new MyThread(obj, 5, true); // Thread 1 prints 5's table
        MyThread t2 = new MyThread(obj, 100, false); // Thread 2 prints 100's table
        t1.start();
        t2.start();
    }
}

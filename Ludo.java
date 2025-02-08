
public class Ludo {

    public static void main(String[] args) {
        Table obj = new Table(); // One object for both threads
        MyThread t1 = new MyThread(obj, 4, true);
        MyThread t2 = new MyThread(obj, 5, false);
        t1.start();
        t2.start();
    }
}

class Table {
    private boolean turn = true;

    synchronized void printTable(int n, boolean ist1) {
        for (int i = 1; i <= 4; i++) {
            while (ist1 != turn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            turn = !turn;
            notifyAll();
        }
    }
}

class MyThread extends Thread {
    private Table t;
    private int num;
    private boolean ist1;

    MyThread(Table t, int num, boolean ist1) {
        this.t = t;
        this.num = num;
        this.ist1 = ist1;
    }

    @Override
    public void run() {
        t.printTable(num, ist1);
    }
}

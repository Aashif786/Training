package OOPS;
interface animals {
    final int a = 10;

    void run();

    default void eat(String animal) {
        System.out.println("Everyone had to eat, including " + animal + "s");
    }
}

class Monkey implements animals {
    @Override
    public void run() {
        System.out.println("Monkey can run" + (a + 10));
    }
}

class Snail implements animals {
    @Override
    public void run() {
        System.out.println("Snails can't run" + a);
    }

}

public class Interf {
    public static void main(String[] args) {
        Monkey a = new Monkey();
        Snail b = new Snail();
        a.run();
        b.run();

        a.eat("Monkey");
        b.eat("Snail");
    }

}

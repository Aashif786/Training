
class Ageex extends Exception {
    Ageex(String msg) {
        super(msg);
    }
}

public class Xception {
    public static void main(String[] args) {
        try {
            int x = 9;
            if (x < 20)
                throw new Ageex("Age < 18. Not allowed!");
            System.out.println("Allowed!");
        } catch (Ageex e) {
            System.out.println(e.getMessage());
        }

    }
}

/*
public class Exception1 {
    public static void main(String[] args) {
        try {
            int age = 16;
            if (age < 18) 
                throw new IllegalArgumentException("Age must be 18 or older.");
            System.out.println("Age is valid: " + age);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e);//toString
        }
    }
}
*/

//Userdefined or Custom

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Exception1 {
    public static void main(String[] args) {
        try {
            int age = 16;
            if (age < 18)
                throw new CustomException("Age must be 18 or older.");
            System.out.println("Age is valid: " + age);
        } catch (CustomException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

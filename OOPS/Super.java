package OOPS;

//constructor in inheritance
//class a{ a(){System.out.println("inside a");}}
//class b extends a{ b(){ System.out.println("inside b");}}
//class c extends b{ c(){ System.out.println("inside c");}}

class parent {

    String fruit;

    parent() {
        fruit = "apple";
    }

    String aa() {
        return "inside super class method";
    }
}

class child extends parent {

    child() {
        fruit = super.fruit + " " + "mango";
        System.out.println(fruit);
    }

    String b() {
        System.out.println(super.aa());
        return "Back to sub class method";
    }
}

public class Super {
    public static void main(String[] args) {
        // c x = new c();

        // accessing attributes using super(constructor call)
        child a = new child();

        // methods using super(method overriding)
        System.out.println(a.b());

    }
}

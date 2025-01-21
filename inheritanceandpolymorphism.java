
package inheritanceandpolymorphism;
class Jaggu {
    void banana(){        
        System.out.println("Hello im jaggu ");
    }
    int salary(){
        int sal = 10000;        
        return sal;
    }
    int age(int a){
        return a;
    }
}
class Bheem extends Jaggu{
    void ladoo(){
        System.out.println("Hello im bheem");
    }
    int salary(){
        int sal = 20000;
        return sal;
    }
    double age(double a){
        return a;
    }
}
class Raju extends Bheem{
    String color(){
        return "blue";
    }
}
class Chutki extends Bheem{
    String color(){
        return "pink";
    }
}
public class JavaApplication1{

    public static void main(String[] args) {
        Bheem a  = new Bheem();
        Jaggu b = new Jaggu();
        Raju c = new Raju();
        Chutki d = new Chutki();
                
        //single inheritance
        System.out.println("single inheritance");
        a.ladoo();
        a.banana();
        System.out.println();

        //multilevel inheritance
        System.out.println("multilevel inheritance");
        c.ladoo();
        c.banana();
        System.out.println("Raju's Color: "+c.color()+"\n");

        //hierarchical inheritance
        System.out.println("hierarchical inheritance");        
        System.out.println("Raju: \"Bheem's salary: "+c.salary()+"\nChutki: Bheem's salary: "+d.salary()+"\n");
        
        //hybrid inheritance = above 3
        
        //overriding
        System.out.println("overriding");
        System.out.println("Bheem's salary: "+a.salary()+"\nJaggu's salary: "+b.salary()+"\n");
        
        //overloading
        System.out.println("overloading");
        System.out.println("Bheem's age: "+a.age(2004)+"\nJaggu's age: "+a.age(200)+"\n");
    }
    
}

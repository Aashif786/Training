import java.util.*;
public class priq {
    public static void main(String[] args){
        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.add(1);
        a.add(34);
        a.add(21);
        a.add(0);
        a.add(56);        
      
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        b.add(1);
        b.add(34);
        b.add(21);
        b.add(0);
        b.add(56);
      
        System.out.println("Min heap");
        for(int i=0;i<5;i++){
            System.out.print(a.poll()+" ");
        }System.out.println();
      
        System.out.println("Reverse");
        for(int i=0;i<5;i++){
            System.out.print(b.poll()+" ");
        }
    }
}

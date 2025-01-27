public class Hotpotato {
    public static void main(String[] args){   
            Queue <String> q = new LinkedList<>();
            q.add("A");
            q.add("B");
            q.add("C");
            q.add("D");
            q.add("E");
            int x=3;
            while(q.size()!=1){
                for(int i=0;i<x-1;i++){
                    q.offer(q.poll());
                }
                q.poll();
            }
            System.out.println(q.poll());
    }
}

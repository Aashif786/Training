

import java.util.*;

public class Bookhash {
    @SuppressWarnings("unchecked")
    public static void main(String[]args){
       @SuppressWarnings("rawtypes")
    HashMap m = new HashMap();
        m.put("Bridge to Terabithia",1600);
        m.put("Harry Potter: The Sorcerer's Stone",1200);
        m.put("Harry Potter: Half Blood Prince",1650);
        m.put("Harry Potter: The Prisoner of Azkaban",1880);
        m.put("Harry Potter: Deathly Hallows",2000);
        m.put("Harry Potter: Deathly Hallows-II",2200);
        m.put("Harry Potter: The Cursed Child",1200);
        System.out.println(m);

        @SuppressWarnings("rawtypes")
        Set mm = m.entrySet();
        @SuppressWarnings("rawtypes")
        Iterator it = mm.iterator();
        while(it.hasNext()) System.out.println(it.next());
        while(it.hasNext()){
            @SuppressWarnings("rawtypes")
            Map.Entry mp = (Map.Entry)it.next();
            if(mp.getKey().equals("Bridge to Terabithia")) mp.setValue(2150);
            if(mp.getValue().equals(2000)) mp.setValue(2150);
            Integer val = ((Integer)mp.getValue())+20;
            mp.setValue(val);
        }
        System.out.println(m);
        
        for (@SuppressWarnings("rawtypes")
        Iterator i = mm.iterator(); i.hasNext();) {
			@SuppressWarnings("rawtypes")
            Map.Entry ent = (Map.Entry)i.next();
	        System.out.println(ent);

		}
        System.out.println(m);


    }
}

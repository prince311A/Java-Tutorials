import java.util.LinkedList;

public class JT_46_linkedlist {
    public static void main(String []k){
        LinkedList<Integer> p = new LinkedList<>();
        p.add(1);
        p.add(2);
        p.add(3);
        p.add(0,4);
        p.addFirst(55);// these two are linkedlist method not applicable for arraylist
        p.addLast(99);
        System.out.println(p.get(1));
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i));
        }
    }
}

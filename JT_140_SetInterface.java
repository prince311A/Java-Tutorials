import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class JT_140_SetInterface {
    /*Set InterFace hava 2 classes -:HashSet(unordered) and LinkedHashSet(insertion order preserved)
    * And Have one child interface called SortSet(sorted order) which has one class called as TreeSet
     */
    static void hastSet(){
        HashSet<Integer> hset = new HashSet<>();
        hset.add(1);
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3 only unique
        hset.add(48);
        hset.add(5);
        hset.add(96);
        hset.add(25);
        System.out.println(hset); // pure random unordered
        System.out.println(hset.size());
    }
    static void linkedHashSet(){
        LinkedHashSet<Integer> hset = new LinkedHashSet<>();
        hset.add(1);
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3 only unique
        hset.add(48);
        hset.add(5);
        hset.add(96);
        hset.add(25);
        System.out.println(hset); // insertion order preserved
        System.out.println(hset.size());
    }
    static void treeSet(){
        TreeSet<Integer> hset = new TreeSet<>();
        hset.add(1);
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3
        hset.add(2);
        hset.add(3);
        System.out.println(hset);//1,2,3 only unique
        hset.add(48);
        hset.add(5);
        hset.add(96);
        hset.add(25);
        System.out.println(hset); // returns in sorted order
        System.out.println(hset.size());
    }
    public static void main(String[] args) {
//        hastSet();
//        linkedHashSet();
        treeSet();
    }
}

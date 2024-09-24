import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JT_78_Arraylistquest {
  //  Q1) Reverse an ArrayList
    static void reverseArraty(ArrayList<Integer>p1){
        int i = 0;
        int j = p1.size()-1;
        while(i<j){
            Integer temp = Integer.valueOf(p1.get(i));
            p1.set(i,p1.get(j));
            p1.set(j,temp);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
     ArrayList<Integer> p = new ArrayList<>();
     p.add(0);
     p.add(10);
     p.add(3);
     p.add(5);
     p.add(22);
     p.add(10);
        System.out.println("Original Arrayy "+p);
        reverseArraty(p);
        System.out.println("New Arrayy "+p);

        // EasyPissy Reverse() in Clloections class
         Collections.reverse(p);
        System.out.println("Again same Array "+p);

        // sorting() in collections class
       // Collections.sort(p);// this print in ascending order
        System.out.println("Arraylist in Sorted "+p);

        // If we want to print in sorted decending order then
        Collections.sort(p, Collections.reverseOrder()); // desending order reverse
        System.out.println("Array list in decending sorted "+p);


    }
}
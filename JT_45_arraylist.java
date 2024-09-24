//**************************************************************************
import java.util.*;
public class JT_45_arraylist {
    public static void main(String k[]){
        ArrayList<Integer> p1 = new ArrayList<>(10); // by giving argument here we cen set the capacity of array list
        p1.add(5); //insert the element at the specified position
        p1.add(6);
        p1.add(7);
        p1.add(2);// priority given of recent element
        p1.add(0,25);
        p1.set(4,56);
        // p1.addAll(q); // add two arraylist elements
        // p1.clear(); // remove all the elements from list
//        for(int i =0;i<p1.size();i++){
//          //  1) to check the length of arraylist we use size();
//            System.out.println(p1.get(i));
//            // 2) to access the element of array by use get();
//        }
        System.out.println(p1); // printting arraylist withoutloop

        ArrayList<Integer> p = new ArrayList<>();
        p.add(5);
        p.add(6);
        p.add(7);
        p.add(8);
        //Q1) Add an element to an given index with all the elements inserted before. (index 2,ele 100)
        // p.set(2, 100); // this method overwrite the previous element or called modify ele
        System.out.println(p); // gives changed array 5,6,100,8 after set()
        p.add(2, 100); // correct way without change in array ele.
        System.out.println(p);// [5,6,100,7,8] add element the shift other by one

        //Q2) Remove an element at index (reduce the size of array)
        p.remove(2);//pass index
        System.out.println(p);

//        Q3) Remove element without knowing index
        p.remove(Integer.valueOf(7)); // return type in boolean
        System.out.println(p);

//        Q4) Checking if an element exists or not and return type in boolean
        // System.out.println(p.contains(5)); // not good approch because it takes object
        System.out.println(p.contains(Integer.valueOf(5)));

        //Important ==> ArrayList without any type so we can put any type of element in it
        ArrayList s = new ArrayList();
        s.add(1.1);s.add(1.12);s.add('u');s.add("prince");s.add(0);
        System.out.println(s);

        // indexof and lastindexof
        System.out.println(p.indexOf(Integer.valueOf(6)));
        System.out.println(p.lastIndexOf(Integer.valueOf(6)));
    }
}
/*
* Important Methods of ArrayList*************
* 1)add();
* 2)addAll();
* 3)get();
* 4)size();
* 5)contains();
* 6)indexOf();
* 7)lastIndexOf();
* 8)set();
* 9)remove();
* 10)clear();
* Difference Between set() and add() => set() doesnot change the size of arraylist but add() change the size because it shifts.
* IMP=> ArrayList double its size when elements are filled in given capacity
* */
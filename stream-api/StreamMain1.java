package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamMain1 {
    public static void main(String[] args) {
        //Q1. Create a list and filter all even from list
//        List<Integer>list = new ArrayList<>(); // 1way (mutable)
//        list.add(1);
//        list.add(2);
//        System.out.println(list);

       List<Integer> list1 = List.of(2,4,50,21,22,67); // 2way (immutable)
//       list1.add(45); // error cant do this because here we use List.of() to initialize a list, and it's a immutable
//                          so we cant modify it.
        System.out.println(list1) ;

//       List<Integer>list2 = Arrays.asList(2,4,50,21,22,67); //3way (immutable);
//        System.out.println(list2);

//        filter all even from list1 (without stream api)aamZindagi
        List<Integer>listEven = new ArrayList<>();
        for (Integer i:list1){
            if(i%2==0){
                listEven.add(i);
            }
        }
        System.out.println(listEven);

        // Using Stream Api (mentosZindagi)
       Stream<Integer> stream = list1.stream();
      List<Integer>newList = stream.filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(newList);
    }
}

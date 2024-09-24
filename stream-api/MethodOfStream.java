package work;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodOfStream {
   static int square(int i){
        return i*i;
    }
    public static void main(String[] args) {
        //1. filter(predicate)
        // boolean value function operates when condition is true
        // return true
        // Example
        List<String> name = List.of("Aman","Rahul","Atul","Shiv","Ankit");
        //Quest. Find all the names start with 'A'

//        name.stream().filter(i->i.startsWith("A")).forEach(k->{ // for printing
//            System.out.print(k+" ");
//        });
       List<String>list = name.stream().filter(i->i.startsWith("A")).collect(Collectors.toList()); // store in list
        System.out.println("Start with 'A' :"+list);
//        ---------------------------------------------------------------------------------
        //2. map(function)
        //   each element operation

        List<Integer> numbers = List.of(2,4,5,6,3,7,1);
        //Quest. Square all the elements in list.
//       List<Integer>list1 = numbers.stream().map(i->square(i)).collect(Collectors.toList()); //we can also do this
       List<Integer>list1 = numbers.stream().map(i->i*i).collect(Collectors.toList());
        System.out.println("Square of list :"+list1);

        //Quest. Sort the given list.
        List<Integer>list2 = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List :" +list2);
        //Quest. Find minimum element of the given list.
        Integer i = numbers.stream().min((x,y)-> x.compareTo(y)).get();
        System.out.println("Minimum element is :"+i);
        //Quest. Find maximum element of the given list.
        Integer i1 = numbers.stream().max((x,y)-> x.compareTo(y)).get();
        System.out.println("Maximum element is :"+i1);


    }
}

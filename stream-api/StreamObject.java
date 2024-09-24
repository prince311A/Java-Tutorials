package work;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {
        // Ways to create stream object
        //1 -> creating blank stream
       Stream<Object>stream1 =  Stream.empty();

       //2 using stream.of
        String[] names = {"aman","ritu","ankit","rahul","ravi"};
        Stream<String>stream2 = Stream.of(names);
        stream2.forEach(i->{
            System.out.print(i+" ");
        });

        //3 using stream.builder
        Stream<Object>stream3 = Stream.builder().build();

        //4 for arrays
       IntStream stream4 =  Arrays.stream( new int[] {2,3,4,58,9});
        System.out.println();
       stream4.forEach(i->{
           System.out.print(i+" ");
       });

       //5 best way
        List<Integer> list1 = List.of(2,4,50,21,22,67);
        Stream<Integer> stream5 = list1.stream();
        System.out.println();
        stream5.forEach(i->{
            System.out.print(i+" ");
        });

    }
}

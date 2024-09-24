
import java.time.*;
import java.util.Date;

public class JT_50_dateclass {
    public static void main(String k[]){
        System.out.println(System.currentTimeMillis());
        // System.currentTimeMillis() returns the miliseconds pass from 1 january 1970
        // Date and time class of java returns the result on the base year which is 1990
        // All the classes and methods of time and date belongs to java.time package
//      *******************************************************************************************
      /*  System.out.println(Long.MAX_VALUE); // returns range of the datatype
        System.out.println(Long.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Byte.MAX_VALUE); */
//      ********************************************************************************************
        Date d = new Date();// this is deprecated method which were used before arrival of data package
        System.out.println(d);
        System.out.println(d.getTime()); // returns miliseconds from 1/1/1970
        System.out.println(d.getDate()); // current date
        System.out.println(d.getDay());
        // this deprecated metohds
//        ******************************************QUIZ
        System.out.println("QUIZ");
        System.out.println(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
    }
}

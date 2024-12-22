import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JT_206_BitManipulation_Q1 {
    //    Q1) Swap two Number
    static void swapNumber(int x, int y) {
        System.out.println("Before Swap x :" + x + " y :" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After  Swap x :" + x + "  y :" + y);

    }

    //    Q2) Check if the i-th bit is set or not i.e check whether ith bit from right to left is 1 or not
    static void checkIthBit(int x, int i) {
        // using leftShift
        if ((x & (1 << i)) > 0) {
            System.out.println(true);
        }

        // using rightShift
        if ((1 & (x >> i)) == 1) {
            System.out.println(true);
        }
    }

    //    Q3) Set the ith bit
    static void setIthBit(int x, int i) {
//        left shift 1<<i --> 1<<2 = 100
//        After that Operate OR | with x
        System.out.println(x | (1 << i));
    }

    //Q4) Clear the ith bit
    static void clearIthBit(int x, int i) {
//
//           After take that not of it ~(1<<i)
//        than take &
        System.out.println(x & (~(1 << i)));
    }

    //    Q5 Toogle the ith bit
    static void toggleIthBit(int x, int i) {
//        left shift 1<<i --> 1<<2 = 100
//        take XOR ^ with x
        System.out.println(x ^ (1 << i));
    }
//    Q6) Remove the last set bit(rightmost)
    static void removeLastRightMostBit(int x){
        // perform x & x-1
        // example 1101(13) --> 1100(12)
        System.out.println(x&(x-1));
    }
//    Q7) Check the number is power of 2 or not
    static boolean checkPowerOfTwo(int x){
        // normal approach
        /*
        if(x==0 || x<0)return false;
        boolean flag = true;
        while (flag && x>1){
            int y = x%2;
            if(y!=0){
                flag = false;
            }
            x = x/2;
        }
        System.out.println(flag);
        return flag;
        */
        // Using bit manipulation
        if(x<=0)return false;
        // find x & x-1 if result 0 true else false
        return (x& (x-1))==0;
    }
//    Q8) Count number of set bit
    static void countSetBit(int x){
        int count = 0;
        while (x>0){
            int y = x%2;
            count+=y;
            x = x>>1; // more efficient
//            x = x/2;
        }
        System.out.println(count);
    }
//    Q9) Check number is even or not
    static boolean checkEven(int x){
        return (x &1)==0;
    }
    public static void main(String[] args) {
//        swapNumber(21, 3);
//        checkIthBit(13, 1);
//        setIthBit(9, 2);//13
//        clearIthBit(13, 2);//9
//        toggleIthBit(13, 1);//15
//        removeLastRightMostBit(13);
//        System.out.println(checkPowerOfTwo(16));
//        countSetBit(5);
        System.out.println(checkEven(14));
    }
}

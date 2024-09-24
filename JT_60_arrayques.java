public class JT_60_arrayques {
    //    Q1) Find the second largest element in the given array
    static void greatestElement(int[] ar) {
        int max = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }

            //   ar[i] = -1; // cant assign in the same loop
        }
        System.out.println("The largest element in array is :"+max);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == max) {
                ar[i] = Integer.MIN_VALUE;
            }
        }
        int max1 = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max1) {
                max1 = ar[i];
            }
        }
        System.out.println("The second largest element in array is :"+max1);
    }


    //    Q2) Find the number which is repeated first in given array
    static int firstRepeating(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    return ar[i];
                }
            }
        }
        return -1;
    }




    public static void main(String k[]){
        int[] arr = {-1, -55, -7, -6, -89};
       greatestElement(arr);
        int[] arr1 = {1, 5, 3, 6,3,4,6};
     //int rp =firstRepeating(arr1);
      //  System.out.println("First Repeating element is :"+rp);
    }
}


import java.util.Arrays;

public class JT_62_arrayquest {
    //         Q1 - Given an array sorted in increasing order of size n and an integer x, find if there exists a
//         pair in the array whose absolute difference is exactly x.(n>1)
    static void differencePair(int []arr,int diff) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == diff) {
                    System.out.println("yess");
                    return;
                }
            }
        }
    }
//    Q2 - Given an array of size n, find the total number of occurrences of given number x.
    static void countDubplicate(int ar[], int target){
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
                if (ar[i]==target){
                    count++;
                }
            }

        System.out.println("The number is repeated "+count+" times");
    }
    static void reverseArray(int []ar) {
        int j = ar.length-1;
        int i = 0;
        while (i < j) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
        for (int obj:ar) {
            System.out.print(obj+" ");
        }
    }
    // Q3) Rearrange the given array after rotating k times?
    static void rotateArrayKTimes(int []ar,int k) { // where k is number of rotation
        k = k% ar.length;
        System.out.println(k);
        int n = ar.length - k;
        int dst = 0;
        int ans[] = new int[ar.length];
        for(int i = n;i< ar.length;i++){
            ans[dst++] = ar[i];
        }
        for(int i = 0;i<= n-1;i++){
            ans[dst++] = ar[i];
        }
        for(int i = 0;i<ar.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
//    Q4) LEETCODE Remove a target number in an array
    static void removeTarget(int a[],int target){
        int k = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]!=target){
                a[k++] = a[i];
            }
        }
        System.out.println(Arrays.toString(a));
    }
//    Q5) LEETCODE Remove the dublicates in an SORTED Array
    static void removeDublicates(int ar[]){
        int k =1;
        for(int i = 1;i<ar.length;i++){
            if(ar[i-1]!=ar[i]){
                ar[k++] = ar[i];
            }
        }
        System.out.println(Arrays.toString(ar));
    }
    public static void main(String[] args) {
        int []arr = {5,10,15,20,26};
     //differencePair(arr3,10);
       int  arr1[] = {3, 5, 0, 7, 8, 3, 0};
     //  countDubplicate(arr1,0);
       int []arr2 = {1,2,3,4,5};
     //  reverseArray(arr2);
        int []arr3 = {1,2,3,4,5,6,7};
        rotateArrayKTimes(arr3,1);
        int arr4[] = {5,6,4,8,2,4,6,4}; // output -> {5,6,8,2,6,,,,,,} remove (4)
//        removeTarget(arr4,4);
        int arr5[] = {1,2,2,3,3,4,5}; //output ->{1,2,3,4,5,,,}
      //  removeDublicates(arr5);

    }
}

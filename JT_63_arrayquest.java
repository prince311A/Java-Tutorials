import java.util.Scanner;

public class JT_63_arrayquest {
//    Q1) find the five given number in array but reduce time complexity by applying frequency array?
    static void frequecyArray(int []arr) {
        int[] frqncy = new int[100000];
        for (int i = 0; i < frqncy.length; i++) {
            frqncy[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            frqncy[arr[i]]++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("How many number you want you check");
        int q = sc.nextInt();
        while(q>0){
            System.out.println("Enter the numbers to check whether it is present or not");
            int x = sc.nextInt();
            if(frqncy[x]>0){
                System.out.println("yes");
            }
            else{
                System.out.println("No");
                q--;
            }
        }
    }
//    Q2) Sort an given array with contains only 0 and 1 by increasing order?
    static void sort_01_Array(int ar[]){
       int  count_0 = 0;
       for(int i = 0;i<ar.length;i++){
           if(ar[i]==0){
               count_0++;
           }
       }
//        System.out.println(count_0);

//     for(int i=0;i<count_0;i++){
//         ar[i] = 0;                                // optimized below
//        }
//        for(int i=count_0;i< ar.length;i++){
//            ar[i] = 1;
//        }
        for (int i =0;i<ar.length;i++) {
            if (i < count_0) {
                ar[i] = 0;
            }
            else {
                ar[i] = 1;
            }
        }
        for(int i=0;i< ar.length;i++){
            System.out.print(ar[i]+" ");

        }
        System.out.println();
    }
    // Otimised approch to slove this problem
    static void optimesed_01(int ar[]) {
        int left = 0;
        int right = ar.length - 1;
        while(left<right) {
            if (ar[left] == 1 && ar[right] == 0) {
                int temp = ar[left];
                ar[left] = ar[right];
                ar[right] = temp;
                left++;
                right--;
            }
            if (ar[left] == 0) {
                left++;
            }
          if(ar[right]==1){
              right--;
          }

        }
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
//    Q4)  In an given array move all the even integer in begining and odd integer at end
    static void evenOddArrange(int ar[]){
        int left =0;
        int right = ar.length-1;
        while(left<right){
            if (ar[left]%2 ==1 && ar[right]%2 == 0) {
                int temp = ar[left];
                ar[left] = ar[right];
                ar[right] = temp;
                left++;
                right--;
            }
            if(ar[left]%2==0){
                left++;
            }
            if(ar[right]%2 ==1){
                right--;
            }
        }
        for (int obj:ar) {
            System.out.print(obj+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {400,500,5,1000,50000};
        frequecyArray(arr);
        int arr1[] = {0,1,0,1,0,1,0,1};
      // sort_01_Array(arr1);
        int arr2[] = {1,0,0,1,0,1,0};
  //  optimesed_01(arr2);
        int arr3[] ={1,3,4,5,7,6,8};
//        evenOddArrange(arr3);
    }
}

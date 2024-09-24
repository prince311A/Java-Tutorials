import java.util.Arrays;

public class JT_59_ArraysSort {
//    Q1) Find the total number of pairs whose sum is equal to the value x
    static void twoPairSum(int ar[],int x){
        int n = ar.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    if (ar[i] + ar[j] == x) {

                        System.out.println( "Elements in pairs "+ar[i]+" "+ar[j]);
                        ans++;
                }
            }
        }

        System.out.println("Possible pairs are "+ans);
    }
 //      Q1.1) Find the total number of pairs whose sum is equal to the value x in an SORTED ARRAY
    static void twoPairSumSorted(int arr[],int target){
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            if(arr[i]+arr[j]==target){
                System.out.println(arr[i]+" and "+arr[j]);
                break;
            }
            else if(arr[i]+arr[j]<target){
                i++;
            }
            else if(arr[i]+arr[j]>target){
                j--;
            }
        }
    }
//    Q2) Three pair sum?
    static void threePairsSum(int ar[],int x){
        int n = ar.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++) {
                for (int k = j + 1; k < n; k++) {
                    if (ar[i] + ar[j] + ar[k] == x) {
                        System.out.println("Elements in pairs " +i+ ar[i] + " " +j+ ar[j] + " " + +k+ar[k]);
                        ans++;
                    }
                }

            }
        }
        System.out.println("Possible pairs are "+ans);
    }
//    Q3) Find the unique number which is not repeated twice in array
    static void uniqueElement(int ar[]){
        int n = ar.length;
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                if(ar[i] == ar[j]){
                    ar[i] = -5;
                    ar[j] = -5;
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(ar[i]>-5){
                System.out.println("The unique element is:"+ar[i]);
            }
        }
    }
    // other approach
    static void uniqueAnotherApproach(int []arr1) {
        int repeat[] = new int[arr1.length];
        int rept = 0;
        outlook:
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < repeat.length; k++) {
                if (arr1[i] == repeat[k]) {
                    continue outlook;
                }
            }
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    repeat[rept++] = arr1[i];
                    continue outlook;
                }
            }
            System.out.println(arr1[i]);
        }
    }
        public static void main(String[] args) {
        int []arr = {4,6,3,5,8,2};
        int target = 7;
     //  twoPairSum(arr,target);
       int []arr1 = {-1,0,1,2,-1,-4};
       int target1 = 0;
//       threePairsSum(arr1,target1);
        int[]arr2 = {10,6,9,6,9,6,8,6,9};
        int []arr4 = {1,2,2,3,4,4,5};
            int []arr5= {1, 5, 5, 8, 8,5,8, 1, 9, -1};
//        uniqueElement(arr5);
        uniqueAnotherApproach(arr5);

        int[]arr3 = {3,5,8,13,100};
//        twoPairSumSorted(arr3,16);
     }
}


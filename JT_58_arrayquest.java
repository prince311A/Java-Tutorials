import java.util.Arrays;

public class JT_58_arrayquest {
     //Q1) count the number strictly greater than x?
        static void strictGreater(int ar[],int x){
            int count = 0;
            for(int i = 0;i<ar.length;i++){
                if(ar[i]>x){
                    count++;
                }
            }
            System.out.println(count);
        }
    // Q2) Check given array is shorted or not
    static int[] sortarray(int []ar){
        Arrays.sort(ar);//prebuilt function
//        for(int i = 0;i<ar.length;i++){
//            System.out.print(ar[i]+" ");
//        }
//        System.out.println();
        int []ans =    {ar[0]+1,ar[0]+2};
        return ans;
//        ************************************************************
//            if(ar[i]<ar[i-1]){
//                int x = ar[i-1];
//                ar[i-1] = ar[i];
//                ar[i] = x;
//            }



    }
    public static void main(String[] args) {
        int arr[] = {1,4,5,7,88,44,2,61,3};
        // strictGreater(arr,7);
        int an[] =  sortarray(arr);
        System.out.print("The 2nd and 3rd smallest element of array is:");
        System.out.println(an[0] +" "+ an[1]);
    }
}

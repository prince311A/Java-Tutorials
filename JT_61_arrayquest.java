public class JT_61_arrayquest {
//  Q1) Swap two number
    static  void swap(int a,int b){
        a = a+b;
        b=  a-b;
        a = a-b;
      System.out.println("The swap of the number is "+a+" "+b);
    }
//    Q2) Reverse the array
static void reverse(int []ar) {
    int[] ans = new int[ar.length];
    int j = 0;
    for (int i = (ar.length)-1; i >=0; i--) {
        ans[j++] = ar[i];
    }
    System.out.print("The reverse of the string :");
    for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i] + " ");
    }
}
//Q3) find minimum element in given array
    static void smallestElement(int ar[]){
        int min = ar[0];
            for(int i =0;i<ar.length;i++){
                if(ar[i]<min)
                    min = ar[i];
    }
        System.out.println(min);
    }
//    Q4) Given an unsorted array arr[] of size N having both negative and positive integers, place
//all negative elements at the end of array without changing the order of positive elements
//and negative elements
     static void arrangeInSeperation(int []ar){
        int []ans = new int[ar.length];
        int dst = 0;
        for(int i =0;i<ar.length;i++){
            if(ar[i]>=0){
                ans[dst] = ar[i];
                dst++;
            }
        }
         for(int i =0;i<ar.length;i++){
             if(ar[i]<0){
                 ans[dst] = ar[i];
                 dst++;
             }
         }
         for (int i =0;i<ar.length;i++){
             System.out.print(ans[i]+" ");
         }


     }
     // Solving it by different approach
    static void arrangeInsep_2(int ar[]){
        int left = 0;
        int right = ar.length-1;
        while(left<right) {
            if (ar[left] >= 0 && ar[right] < 0) {
                int temp = ar[left];
                ar[left] = ar[right];
                ar[right] = temp;
                left++;
                right--;
            }
            if (ar[left] < 0) {
                left++;
            }
            if (ar[right] > 0) {
                right++;

            }
        }
            for (int i = 0; i < ar.length; i++) {
                System.out.print(ar[i] + " ");
            }
        }
    public static void main(String[] args) {
  // swap(1,2);
   int arr[] = {1,2,3,4,5};
  // reverse(arr);
   int arr1[] = {2,-3,5,8,1,0,-4};
  // smallestElement(arr1);
        int []arr2 = {1, -1,  -7, 11,-99};
         arrangeInSeperation(arr2);
   //     arrangeInsep_2(arr2);
           }
}
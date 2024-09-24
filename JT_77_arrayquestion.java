import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class JT_77_arrayquestion {
//    Q1) remove the dublicate elements in an sorted array and return or count the unique element
    static int removedublicates(int nums[]){
        int c= nums.length;
        int k = 1;
        for(int i= 0;i<nums.length-1;i++){
           if(nums[i]!=nums[i+1]){
               nums[k] = nums[i+1];
               k++;
           }
//           if(nums[i]==nums[i+1]){
//               continue;
//       }
   }
        for(int i =0;i< k;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return k;
    }
//    Q2) Remove the element in array which are repeated than return the unique elements in variable k and change that same array
//    to print first unique elements
    static int removeElement(int nums[],int val) {
        int ii = 0;
        int jj = nums.length - 1;
        while (ii < jj) {
            if (nums[jj] == val) {
                jj--;
            }
          else   if (nums[ii] != val) {
                ii++;
            }
           else if (nums[ii] != val && nums[jj] == val) {
                ii++;
                jj--;
            }
         else if(nums[ii] == val && nums[jj] != val) {
                int temp = nums[ii];
                nums[ii] = nums[jj];
                nums[jj] = temp;
                ii++;
                jj--;
            }
        }
        for (int r = 0; r < nums.length; r++) {
            System.out.print(nums[r] + " ");
        }
        System.out.println();
        int k =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                k++;
            }
        }
        return k;
    }
//    Q3) Return the insert position in an sorted array and if the number is not there then where it will inserted sorted way
    static int searchInsert(int nums[],int val) {
        for(int i =0;i<nums.length;i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        int ans[] = new int[nums.length + 1];
        for(int i =0;i<nums.length;i++){
            ans[i] = nums[i];
        }
        ans[ans.length-1]=val;
        for (int i = 0; i < ans.length; i++) {
            for(int j =i+1;j<ans.length;j++){
                if (ans[i] > ans[j]) {
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j]=temp;
                }
        }
        }
        for(int i = 0;i<ans.length;i++){
            if (ans[i] == val) {
                return i;
            }
        }
        return 0;
    }
    //    Q4) Plus one to the last index of the given array
    static int[] plusOne(int digits[]){
        int xx[]= new int[1];
         if (digits[digits.length-1]<9) {
             digits[digits.length - 1] = digits[digits.length - 1] + 1;
             return digits;
         }
        else if(digits[digits.length - 1] >= 9) {
        int ans[] = new int[digits.length+1];
        for(int i =0;i<ans.length-2;i++){
            ans[i] = digits[i];
        }
             ans[ans.length - 1] = 0;
             ans[ans.length - 2] = 1;
             return ans;
        }
        return xx;
    }
//    Q5) Return true if array contains duplicate number
    static boolean containsDuplicate(int[] nums) {
        for(int i =0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
//    Q6) find the third maximum number in an array
 static void minvalue(int nums[],int maxx) {
     for (int i = 0; i < nums.length; i++) {
         if (nums[i] == maxx) {
             nums[i] = Integer.MIN_VALUE;
         }
     }
 }
    static int findmax(int numss[]){
         int max = numss[0];

             for (int i = 0; i < numss.length; i++) {
                 if (numss[i] > max) {
                     max = numss[i];
                 }
             }
         return max;
     }
    static int thirdMaximun(int nums[]) {
        int maxi = findmax(nums);
        System.out.println(maxi);
        if (nums.length == 2) {
            return maxi;
        } else {
            minvalue(nums, maxi);
            int maxi2 = findmax(nums);
            System.out.println("Second Max " + maxi2);
            minvalue(nums, maxi2);
            int maxi3 = findmax(nums);
            System.out.println("Third Max " + maxi3);
            return maxi3;
        }
    }
//    Q8) Program for fibonacci series
    static void fibonacci(int range){
        int a =0;
        int b = 1;
        for (int i =0;i<range;i++){
            System.out.print(a+" ");
            System.out.print(b+" ");
            a = a+b;
            b = a+b;
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //  int c =  removedublicates(arr);
        //  System.out.println(c);
        int arr1[] = {0, 1, 2, 2, 3, 0, 4, 2};
          int k =removeElement(arr1,2);
         System.out.println(k);
        int arr2[] = {1, 3, 5, 6};
       // int r = searchInsert(arr2,2);
       //  System.out.println(r);
        int arr3[] = {1, 2, 9, 9};
        //   int ans[] = plusOne(arr3);
       /* for(int i = 0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }*/
        int arr4[] = {1, 3,3};
        //boolean yes = containsDuplicate(arr4);
        //System.out.println(yes);
        int arr5[] = {1,1,3,2,2};
     //thirdMaximun(arr5);

//        fibonacci(5);
    }
}

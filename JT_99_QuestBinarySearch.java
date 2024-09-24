public class JT_99_QuestBinarySearch {
/*    Problem 1: Find the index of the first occurrence of a given element x in an array? It is given that the array is
    sorted? If no occurrence of x is found then return -1.
    Input
    arr = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
    x = 5
    Output :1
*/
    static int firstOccurrene(int a[],int target){
        int start = 0;
        int end = a.length-1;
        int firstocrnce = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(a[mid]==target){
               firstocrnce = mid;
               end = mid-1; // for first occurrence index
                // start = mid+1; // for last occurrence index
            }
            else if(a[mid]<target){
                start = mid+1;
            }
            else if(a[mid]>target){
                end = mid-1;
            }
        }
        return firstocrnce;
    }
//    Q2) Find the square root of the number
    static void squareRoot(int x){
        int y = 0;
        while(y*y<=x)y++;
        System.out.println("Square root is "+(y-1));
    }
    static int binarySquareRoot(int a){
        int start = 0;
        int end= a;
        int ans =-1;
        while(start<=end){
            int mid = (start+end)/2;
            int val = mid*mid;
            if(val==a)return mid;
            else if(val<a){
                ans = mid;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
//    Q3 Given an rotated sorted array,Find the minimum element or index in the array .Follow 0 based indexing
    static int minimumRotatedArray(int []a){
        int start = 0;
       int end = a.length-1;
        int ans=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(a[mid]>a[a.length-1]){
                start = mid+1;
            }
            else if(a[mid]<=a[a.length-1]){
                ans = mid;
                end = mid-1;
            }
        }
//        return ans; // for minimum element index
        return a[ans];// for minimum element
    }
//Q4: Given the rotated sorted array of integers, which contains distinct elements, and an integer target,
//            return the index of target if it is in the array. Otherwise return -1.
    static int targetRotatedArray(int a[],int target){
        int start = 0;
        int end = a.length-1;
        while(start<=end){
            int mid = (start+end)/2;
                if(target==a[mid]){
                    return mid;
                }
         else    if(a[mid]<a[end]) { //checking end and mid
                if (target > a[mid] && target <= a[end]) {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(target>=a[start] && target<a[mid]){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }
    // Solving Same problem by  a[mid]>a[start] checking start and mid
//     while (start<=end){
//        int mid = (start+end)/2;
//        if(c[mid]==target){
//            System.out.println(mid);
//            break;
//        }
//        else if(c[start]<c[mid]){
//            if(target>=c[start] && target<c[mid]){
//                end = mid-1;
//            }
//            else {
//                start = mid+1;
//            }
//        }
//        else {
//            if (target>c[mid] && target<=c[end]) {
//                start = mid + 1;
//            }
//            else {
//                end = mid-1;                }
//        }
//    }
//*******************************************************************

    ////    Trying by different approach i.e finding the two sorted array in rotated array then
    ////    Apply binary search to both array's to find the target
    ////    3-times binary search used in this approach
    static void targetRotatedArrayBasic(int c[],int targer){
        int start = 0;
        int end = c.length-1;
        int ans = -1;
        while (start<=end){  // applying binary search to find index where array is rotated
            int mid  = (start+end)/2;
            if(c[mid]<c[c.length-1]){
                ans = mid;
                end = mid-1;
            }
            else if(c[mid]>c[c.length-1]){
                start = mid+1;
            }
        }
        // ans is the index from where array is rotated
        int end1 = ans;
        int start1 = 0;
        while(start1<end1){ // applying BS to search in one part of array
            int mid = (start1+end1)/2;
            if(c[mid]==targer){
                System.out.println(mid);
                break;
            }
            else if(c[mid]<targer){
                start1 = mid+1;
            }
            else {
                end1 = mid-1;
            }
        }
        int end2 = c.length-1;
        while(end1<=end){  // applying BS to search in another part of array
            int mid = (end2+end1)/2;
            if(c[mid]==targer){
                System.out.println(mid);
                break;
            }
            else if(c[mid]<targer){
                end2 = mid+1;
            }
            else {
                end1 = mid-1;
            }
        }
    }
//Q5) Search element in rotated sorted aaray with dublicate elements
    public static int targetDublicateRotatedArray(int a[],int target){
        int start = 0;
        int end = a.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target==a[mid]){
                return mid;
            }
            else if (a[start]==a[mid] && a[mid]==a[end] && a[start]==a[end]) {
                start++;
                end--;
            }
            else    if(a[mid]<=a[end]) { //checking end and mid
                if (target > a[mid] && target <= a[end]) {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(target>=a[start] && target<a[mid]){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int a[] = {5,5,5,6,6,8,9,9,9};
       // System.out.println(firstOccurrene(a,5));
//        squareRoot(625);
//        System.out.println(binarySquareRoot(24));
        int b[] = {3,4,5,1,2};
//        System.out.println(  minimumRotatedArray(b));

        int c[] = {6,7,1,2,3,4,5};
       // System.out.println(targetRotatedArray(c,2)); // 1
       // targetRotatedArrayBasic(c,7); // 1

        int d[]={0,0,0,1,1,1,2,0,0,0};
        int e[] = {1,1,1,1,1,1,2,3,1};
        System.out.println(targetDublicateRotatedArray(e,3));
    }
}

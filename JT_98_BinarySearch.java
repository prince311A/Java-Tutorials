public class JT_98_BinarySearch {
//    ***********************************************BINARY SEARCH ALGORITHM**************************
    static boolean binarySearch(int a[],int target){
        int start = 0;
        int end = a.length-1;
//        int mid = (start+end)/2;
        while(start<=end){
        int mid = (start+end)/2; // (start+(end-start))/2 saves from crossing the range of integer
            if (a[mid] == target){
                System.out.println("Element Found at Index "+mid);
                return true;
            }
            else if(a[mid]<target){
                start =mid+1;
//                mid = (start+end)/2;
            }
            else if(a[mid]>target){
                end = mid-1;
//                mid = (start+end)/2;
            }
        }
        return false;
    }
//    ************************************RECURSIVE BINARY SEARCH ALGORITHM**************************

    static boolean recursiveBinarySearch(int a[],int start,int end,int target){
        if(start>end)return false;
        int mid = (start+end)/2; //(start+(end-start))/2 saves from crossing the range of integer
        if(a[mid]==target)return true;
        else if (a[mid]<target) {
           return recursiveBinarySearch(a,mid+1,end,target);
        }
        else{
          return   recursiveBinarySearch(a,start,mid-1,target);
        }
    }
    public static void main(String[] args) {
        int a [] = {2,5,9,15,17,21,25};
//        System.out.println(binarySearch(a,2));
        System.out.println(recursiveBinarySearch(a,0,a.length-1,21));

        // TIME COMPLEXITY OF BINARY-SEARCH IS O(log n)
        // SPACE COMPLEXITY OF BINARY-SEARCH IS O(log n) recursive case
        // SPACE COMPLEXITY OF BINARY-SEARCH IS O(1) iterative case



    }
}

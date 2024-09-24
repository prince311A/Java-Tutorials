
public class JT_101_2dBinarySearch {
    //    Q1) Search for the target element in 2d Array using binary search (time complexity mlogn) where m is rows n is column

    static void twoD_BinarySearch(int d[][], int target) { // applying binary search to every row and find target
        for (int i = 0; i < d.length; i++) { //(myapproach)
            int start = 0;//
            int end = 3; // number of columns
            while (start <= end) {
                int mid = (start + end) / 2;
                if (d[i][mid] == target) {
                    System.out.println("d[" + i + "][" + mid + "]");
                    return;
                } else if (d[i][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.println("-1");
    }

    //******************************One time use of binary search (OPTIMISED)  T.C(logmn) m = rows, n = column*************
    // As given all matrix is sorted and first element of every row is greater than the last element of previous row
    static void twoD_BinarySearch_Optimised(int d[][], int target) { // (74.LEETCODE)
        int rows = 3;
        int col = 4;
        int start = 0;
        int end = (rows * col) - 1;
        int i;
        int j;
        while (start <= end) {
            int mid = (start + end) / 2;
            i = mid / col;
            j = mid % col;
            if (d[i][j] == target) {
                System.out.println("Element found at d[" + i + "][" + j + "]");
                return;
            } else if (d[i][j] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("-1");
    }
    // Applied when both rows and columns sorted in increasing order ( 240.LEETCODE)
    static void twoD_BinarySearch_More_optimised (int d[][],int target){
        int rows = d.length;//3
        int col = d[0].length;//4
        int i =0;
        int j = col-1;
        while (i< rows && j>=0){
            if(target ==d[i][j]){
                System.out.println("Element found at d[" + i + "][" + j + "]");
                break;
            }
            else if(target>d[i][j]){
                i++;
            }
            else if(target<d[i][j]){
                j--;
            }
        }
    }
//Q2) 852.LEETCODE
    static void peakIndexMountain(int e[]){  //(852 LEETCODE)
        int start = 0;
        int end = e.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(e[mid]>e[mid-1] && e[mid]>e[mid+1]){
                System.out.println(e[mid]);
                return;
            }
            else if(e[mid]>e[mid-1]){
                start = mid+1;
            } else if (e[mid]<e[mid-1]) {
                end = mid-1;
            }
        }
        System.out.println(-1);
    }
    //Q3) 162.LEETCODE
    // O(n)
    /*
     public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1])
                    return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1])
                    return i;
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
    * */
    static void findPeakElement(int f[]){  // (162 LLETCODE)
        int start = 0;
        int end = f.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if((mid==0 || f[mid]>f[mid-1]) && (mid==f.length-1 || f[mid]>f[mid+1])){
                System.out.println(f[mid]);
                return;
            }
            else if(f[mid]>f[mid-1]){
                start = mid+1;
            } else if (f[mid]<f[mid-1]) {
                end = mid-1;
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) {
        int d[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//         twoD_BinarySearch(d,0);
        //twoD_BinarySearch_Optimised(d,30); // (74.LEETCODE)
      //  twoD_BinarySearch_More_optimised(d,23); (240.LEETCODE)

        int e[] = {1,3,5,6,8,10,9,7,4,2};
        int g[] = {1,2,1,3,5,6,4}; // testcase
//        peakIndexMountain(e); // (852.LEETCODE)

        int f[] = {1,2,3,1};
        findPeakElement(f); // (162.LEETCODE)
    }
}
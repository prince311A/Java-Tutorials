public class JT_100_QuestBinarySearch {
    //   Q1) You are given a sorted array containing N integers and a number target, you have to find the number of
//    occurrences of the target in the given array.
//    N=10, target= 5
//    Array ={1,3,3, 4, 5, 5, 5, 11, 15, 15}; // 3
    static void countOccurence(int c[], int target) {
        int start = 0;
        int end = c.length - 1;
        int firstOccurence = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (c[mid] == target) {
                firstOccurence = mid;
                end = mid - 1;  //4
//                start = mid+1; //6

            } else if (c[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
//        System.out.println(firstOccurence);

        int start1 = 0;
        int end1 = c.length - 1;
        int lastoccurence = -1;
        while (start1 <= end1) {
            int mid = (start1 + end1) / 2;
            if (c[mid] == target) {
                lastoccurence = mid;
                start1 = mid + 1; //6

            } else if (c[mid] > target) {
                end1 = mid - 1;
            } else {
                start1 = mid + 1;
            }
        }
//        System.out.println(lastoccurence);
        if (firstOccurence == -1 || lastoccurence == -1) {
            System.out.println("Element not found");
        }
        System.out.println((lastoccurence - firstOccurence) + 1);
    }

    //    Q2)5. Given a sorted array of distinct integers that is rotated in natures find the value of the maximum element in
//the array.
    public static int maximumRotatedArray(int b[]) {
        int start = 0;
        int end = b.length - 1;
        int max = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (b[mid] > b[b.length - 1]) {
                max = mid;
                start = mid + 1;
            } else if (b[mid] < b[b.length - 1]) {
                end = mid - 1;

            }
        }
        return max;

    }

    //Q3)You are given a sorted array containing N integers and a number target. Implement the upper bound
    //function that returns the index of an element just greater than the target element. If there exists no such
    //element then return -1.
    //Note: The target may not be present in the array.
    static void greaterThenTarget(int c[], int target) {
        int start = 0;
        int end = c.length - 1;
        int lastoccurrence = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (c[mid] == target) {
                lastoccurrence = mid;
                start = mid + 1;
            } else if (c[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (lastoccurrence == -1) {
            System.out.println("Element doesnot exist");
            return;
        }
        System.out.println(lastoccurrence + 1);
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 3, 4, 5, 5, 5, 11, 15, 15};
//          countOccurence(a,5);

        int b[] = {6, 7, 11, 13, 15, 1, 2, 3,4, 5}; // 15
          System.out.println(maximumRotatedArray(b));

        int c[] = {1, 3, 3, 4, 5, 8, 9, 11, 15, 15};
//        greaterThenTarget(c,11);

    }
}
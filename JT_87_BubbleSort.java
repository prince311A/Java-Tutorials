import java.util.Arrays;

public class  JT_87_BubbleSort {
    static void bubbleSort(int []a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            Boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
        // Here in best case like only one swap time complexity is same O(n*n) to reduce it O(n) we check the swap
        // IF swap not happens means array is sorted
    public static void main(String[] args) {
        int a [] ={6,5,1,8,2};
        bubbleSort(a);


    }
}

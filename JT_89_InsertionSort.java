import java.util.Arrays;

public class JT_89_InsertionSort {
    static void insertionSort(int a[]){
        int n = a.length;
        for (int j = 1; j < a.length; j++){
            int i = j;
            while (i > 0 && a[i] <a[i - 1]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                i--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[] = {5, 8, 6, 1};
        int b[] = {1,2,2};
       insertionSort(a);
    }
}

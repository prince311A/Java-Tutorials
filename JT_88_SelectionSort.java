import javax.management.timer.TimerNotification;

public class JT_88_SelectionSort {
    static void selectionSort(int a[]){
        for (int i = 0; i< a.length-1 ; i++) {
            int min_index =i;

            for(int j =i+1;j<a.length;j++){
                if (a[min_index ]>a[j]) {
                    min_index = j;
                }

            }
            int temp =a[i];
            a[i] =a[min_index];
            a[min_index] = temp;
        }
        for (int ss:a) {
            System.out.print(" "+ss);
        }
    }
    public static void main(String[] args) {
        int a[] = {5, 6, 9, 2, 4};
        selectionSort(a);
    }
}

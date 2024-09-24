import java.util.Arrays;

public class JT_94_QuickSort {
    //    Q1) Basic Main Algorithm, In a given Array find the perfect sorted index of the first element i.e pivot element and placed it in right position
//            then,such that all the element should arrange, smaller than pivot element and others are greater then pivot element

    static void piovotMethod(int a[]){
        int pivot = a[0];
        System.out.println("Pivot Element is "+pivot);
        int count  = 0;
        for (int i =1;i<a.length;i++){
            if(pivot>=a[i]){ // counting the elements smaller than pivot or a[0]
               count++;
            }
        }
//        System.out.println("Count "+count);
        if(a.length==count){
            count--; // when all the elements smaller than pivot
        }
        int pivot_index = count;
//        System.out.println(pivot_index);
        int temp = a[0];
        a[0]= a[pivot_index]; // placing pivot or first element in right position
        a[pivot_index] = temp;

        System.out.println("Placed the Pivot Element in right position "+Arrays.toString(a));
        int i =0;
        int j = a.length-1;
        while(i<pivot_index && j>pivot_index){

            while (a[i]<a[pivot_index]){
                i++;
            }
            while (a[j]>a[pivot_index]){
                j--;
            }
            if(i<pivot_index && j>pivot_index){
                int temp1 = a[i];
                a[i] =a[j];
                a[j] = temp1;
                i++;j--;
            }
        }
        //****************************************************************************************
//        while (i<pivot_index && j>pivot_index){
//            if(a[i]<a[pivot_index]){
//                i++;
//            }
//            if(a[j]>a[pivot_index]){
//                j--;
//            }                  // also valid
//            if(a[i]>a[pivot_index] && a[j]<a[pivot_index]){
//                int temp1 = a[i];
//                a[i] = a[j];
//                a[j] =temp1;
//                i++;
//                j--;
//            }
//        }**************************************************************************************
        System.out.println("Elements smaller than Pivot and Larger than Pivot "+Arrays.toString(a));
    }

    
    //   ***********************************QUICKSORT ALGORITHM******************************************************

    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];
        int cnt = 0;
        for(int i = st; i <= end; i++){
            if(arr[i] < pivot) cnt++;
        }
        int pivotIdx = st + cnt;
        swap(arr, st, pivotIdx);
//        int temp = arr[st];
//        arr[st] = arr[pivotIdx];  // cant swap like this due to recursion
//        arr[pivotIdx] = temp;
        int i = st, j = end;
        while(i < pivotIdx && j > pivotIdx){
            while (arr[i] <arr[pivotIdx]){
                i++;
            }
            while (arr[j] > arr[pivotIdx]){
                j--;
            }
            if(i < pivotIdx && j > pivotIdx){
                swap(arr, i, j);
//                int temp1 = arr[i];
//                arr[i] =arr[j]; // cant swap like this due to recursion
//                arr[j] = temp1;
                i++;
                j--;
            }
        }
        return pivotIdx;
    }
    static void quickSort(int[] arr, int st, int end){
        if(st >= end) return;
        int pi = partition(arr, st, end);
        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
    }

    public static void main(String[] args) {
        int a [] = {7,13,8,5,10,2,99};
        int b[] = {6,99,3,1,6,5,7,4};
        int c[] = {6,3,1,6,5,4};
//        piovotMethod(b); // valid code only when start element is unique in array
       System.out.println("Array Before Sorting "+Arrays.toString(b));
        quickSort(b,0,b.length-1);
//       pivotPartition(b,0, b.length-1);
        System.out.println("Array After Sorting "+Arrays.toString(b));
    }
}

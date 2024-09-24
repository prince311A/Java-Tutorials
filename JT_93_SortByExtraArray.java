import java.util.Arrays;

public class JT_93_SortByExtraArray {
    static int minIndex(int c[]){
        int min_index = 0;
        for(int i =0;i<c.length;i++){
            if(c[min_index]>c[i]){
                min_index = i;
            }
        }
        return min_index;
    }
    static void sortedArray(int arr[]) {
        int ans[] = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            int minimun = minIndex(arr);
            ans[i] = arr[minimun];
            arr[minimun] = Integer.MAX_VALUE;
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int arr[] = {8,9,5,6,1};
        sortedArray(arr);
    }
}

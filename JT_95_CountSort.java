import java.util.Arrays;

public class JT_95_CountSort {
    //Q1) COUNT SORT ALGORITHM (without maintaining stability)
    static void countSort(int a[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i]){    // finding the maximum number to create the frequency array i.e k
                max = a[i];
            }
        }
        int frequency[] = new int[max+1];  // creating frequency array
        for(int i =0;i<a.length;i++){
            frequency[a[i]]++;
        }
        int k =0;
        for(int i =0;i<frequency.length;i++){
            for(int j =0;j<frequency[i];j++){
                a[k++] = i;
            }
        }
        System.out.println(Arrays.toString(a));
    }

//    Q2) COUNT SORT ALGORITHM (with maintaining stability)

    static void countSortStability(int a[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i]){  // finding the maximum number to create the frequency array i.e k
                max = a[i];
            }
        }
        int frequency[] = new int[max+1];
        for(int i =0;i<a.length;i++){
            frequency[a[i]]++;
        }
        // We have to covert the frequency array to its prefix array
        for(int i =1;i<frequency.length;i++){
            frequency[i] = frequency[i] + frequency[i-1];
        }
        int ans[] = new int[a.length];
        for(int i = a.length-1;i>=0;i--){
            ans[--frequency[a[i]]] =a[i];

        }
        System.out.println(Arrays.toString(ans));
    }


    public static void main(String[] args) {
        int a[]= {4,3,1,5,3,1,3,5};
//      countSort(a);
        countSortStability(a); 
    }
}

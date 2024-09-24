import java.util.Arrays;

public class JT_96_RadixSort {
    static void frequencyRadix(int a[],int place){
        int frequency[] = new int[10];
        for(int i =0;i<a.length;i++){
            frequency[(a[i]/place)%10]++;//frequency array
        }
        for(int i =1;i<frequency.length;i++){
            frequency[i] = frequency[i]+frequency[i-1]; // prefix of frequency array
        }
        int ans[] = new int[a.length];
        for(int i=a.length-1;i>=0;i--){
//            ans[--frequency[(a[i]/place)%10]] = a[i];
            int idx = frequency[(a[i]/place)%10]-1;
            ans[idx] = a[i];
            frequency[(a[i]/place)%10]--;
        }
        for(int i =0;i<a.length;i++){
            a[i] = ans[i];
        }
        System.out.println(Arrays.toString(a));
    }
    static void radixSort(int a[]){
//        for(int place = 1;802/place>0;place*=10){
//            frequencyRadix(a,place); //also valid
//        }
        frequencyRadix(a,1);
        frequencyRadix(a,10);
        frequencyRadix(a,100);


    }
    public static void main(String[] args) {
        int a[] = {170, 45, 75, 90, 802, 2};
        radixSort(a);
    }
}

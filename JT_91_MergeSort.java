import java.util.Arrays;
import java.util.Objects;

public class JT_91_MergeSort {
    //Q1) Given the two sorted array Convert it into one sorted array
    static void merge(int nums1[],int nums2[]){
        int m = nums1.length;
        int n = nums2.length;
        int nums[] = new int[m+n];
        int i=0;int j=0;int k=0;
//        while(i<n1 &&j<n2){
//            if(a[i]<b[j]){
//                ans[idx++] = a[i];
//                i++;
//            }
//            else{
//                ans[idx++] = b[j];
//                j++;
//            }
//        }
//
//        while (j<n2){
//            ans[idx++] =b[j++];
//        }
//
//
//        while (i<n1){
//            ans[idx++] =a[i++];
//        }
        while(i<n && j<m){
            if(nums1[i] <nums2[j]){
                nums[k++] = nums1[i++];
            }
            else{
                nums[k++] = nums2[j++];
            }
        }
        while(i<m){
            nums[k++] = nums1[i++];
        }
        while(j<n){
            nums[k++] = nums2[j++];
        }

        System.out.println(Arrays.toString(nums));
    }
    // MERGE SORT ALGORITHM
    static void sortByMerge(int c[],int l,int r,int mid){
        int n1= mid-l+1;
        int n2 = r-mid;
        int left[] = new int[n1];
        int right[] = new int [n2];
        for(int i =0;i<n1;i++)left[i]=c[i+l];
        for(int j =0;j<n2 ;j++)right[j]=c[mid+1+j];
        int i =0,j=0,k=l;
        while(i<n1 && j<n2) {
            if (left[i] > right[j]) {
                c[k++] = right[j++];
            } else {
                c[k++] = left[i++];
            }
        }
        while (i<n1){
            c[k++] = left[i++];
        }
        while (j<n2){
            c[k++] = right[j++];
        }
    }
    static void mergeSortAlgo(int c[],int l,int r){
        if(l>=r){return;}
       int mid = (l+r)/2;
      mergeSortAlgo(c,l,mid);
       mergeSortAlgo(c,mid+1,r);
       sortByMerge(c,l,r,mid);
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,5,6};
//         merge(a,b);
        int c[] = {7, 20, 4, 11};
           mergeSortAlgo(c,0,c.length-1);
           System.out.println(Arrays.toString(c));
    }
}

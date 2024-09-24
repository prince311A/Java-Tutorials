import java.util.Arrays;

public class JT_97_sortingQuest {
//    Q1) Given an sorted array except two elements,sort it in O(n)
    // {3,8,6,7,5,9,10) ==> {3,5,6,7,8,9,10} only swap one time.Assume there are no duplicates in the array.
    static void swaponetime(int a[]){
        if(a.length<=1){
            return;
        }
        int index[] = new int[2];
        int idx = 0;
        for(int i =0;i<a.length-1;i++){
            if(a[i]>a[i+1]){                           // this is my approach
                index[idx++] = i;
            }
        }
        System.out.println(Arrays.toString(index));
        int temp = a[index[0]];
        a[index[0]] = a[index[1]+1];
        a[index[1]+1] = temp;
        System.out.println(Arrays.toString(a));

        // Second approach without using extra array
//        int x = -1,y=-1;
//        for(int i =1;i<a.length;i++){
//            if(a[i-1]>a[i]){
//                if(x==-1){
//                    x = i-1;
//                }
//                else{
//                    y = i;
//                }
//            }
//        }
//        System.out.println(x+" "+y);
//        int temp1 = a[x];
//        a[x] = a[y];
//        a[y] = temp1;
//        System.out.println(Arrays.toString(a));
    }
//     Q2) Given an array of positive and ne^ative inte^ers, se^re^ate them in linear time and constant space.
//     The output should print all ne^ative numbers, folloGed by all positive numbers.
//     Input: [ 19, -20, 7, -4, -13, 11, -5, 3]
//     Output: [ -20 -4 -13 -5 7 11 19 3 ;
    static void seperatePosNeg(int []a){
        int i = 0;
        int j = a.length-1;
        while (i<j){
            if(a[i]<0){
                i++;
            }
            if(a[j]>0){
                j--;
            }
            if(a[i]>0 && a[j]<0){
                int temp = a[i];
                a[i] = a[j];
                a[j] =temp;
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(a));
}
//Q3)  Given an array of size U containing only 0s, 1s, and 2s; sort the array in ascending order.
    static void zeroOneTwos(int a[]){
//        *****************************************************************************************
//        int frequency[] = new int[3];
//        for(int i =0;i<a.length;i++){
//            frequency[a[i]]++;
//        }
//        int k =0;
//        for(int i=0;i<frequency.length;i++){
//            for(int j= 0;j<frequency[i];j++){   // not optimised
//                a[k++] = i;
//            }
//        }
//        *************************************************************************************
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]==0)count0++;
            if(a[i]==1) count1++;
            if(a[i]==2)count2++;
        }
        System.out.println(count0+" "+count1+" "+count2);
        int k = 0;
        while(count0>0){
            a[k++] = 0;
                    count0--;   //linear time approach but with two pass
        }
        while(count1>0){
            a[k++] =1;
                    count1--;
        }
        while(count2>0){
            a[k++] =2;
                    count2--;
        }
        System.out.println(Arrays.toString(a));
    }
    //// MORE OPTIMISED APPROACH WITH THREE POINTERS
    static void threePointer(int a[]){
        int low = 0;
        int mid = 0;
        int high = a.length-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp1 = a[mid];
                a[mid] = a[low];
                a[low] = temp1;
                low++;
                mid++;
            }
          else   if(a[mid]==1){
                mid++;
            }
           else if(a[mid]==2){
                int temp = a[mid];
                a[mid] = a[high];
                a[high] =temp;
                high--;
            }
        }

        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int a[] = {11,3,6,7,9,10,1};
        int b [] = {2,1};
        swaponetime(a);

        int c[] = {19, -20, 7, -4, -13, 11, -5, 3,};
        //seperatePosNeg(c);

        int d[] = {0,2,1,2,0,0};
       // zeroOneTwos(d);
//        threePointer(d);

    }
}

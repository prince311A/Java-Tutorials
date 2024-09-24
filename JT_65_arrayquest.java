public class JT_65_arrayquest {
//    Q1) A sorted array is given in non decending order return an array in non decending order after squaring it
    static void SquareArray(int ar[]){
        int ans[] = new int[ar.length];
        int dst =0;
        int left = 0;
        int right = ar.length-1;
        while(left<right){
            if(Math.abs(ar[left])>Math.abs(ar[right])){
                ans[dst] = ar[left]*ar[left];
                dst++;
                left++;

            }
            if(Math.abs(ar[left])<=Math.abs(ar[right])){ // else can also work here but for proper uderstanding i use this
                ans[dst] = ar[right]*ar[right];
                dst++;
                right--;
            }
        }
        for(int i=0;i<ar.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
       int i = 0;
        int j = ans.length-1;
        while(i<j){
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
        for(int is=0;is<ans.length;is++){
            System.out.print(ans[is]+" ");
        }
//        ********************************************************************************************
//        for (int i = 0;i<ar.length;i++){ // work only when array contain only positive integer
//            ans[dst] = ar[i]*ar[i];
//            System.out.print(ans[dst]+" ");
//        }
//        ***********************************************************************************************
    }
//    Q2) return an array after calculating the sum of element-1 in every new index like 5,1,2 => 5,6,8
    // By make new array
    static void makePrefixSum(int ar[]){
        int ans[] = new int[ar.length];
        int dst = 0;
        int sum =0;
//        ans[0] = ar[0];

        for(int i =0;i<ar.length;i++){
            sum =sum+ ar[i];
            ans[dst++] = sum;
        } System.out.println("By creating new array");
        for(int i =0;i<ar.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
    // By not creating new array solving it in given array only(optimized approch)
    static void prefixSumInSingleArray(int ar[]){

        for(int i=1;i<ar.length;i++) {
            ar[i] = (ar[i - 1]) + ar[i];
        }
        System.out.println("Without creating new array");
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {-10,-3,-2,1,4,5};
//        SquareArray(arr);
        int arr2[] = {2,1,3,4,5};
        makePrefixSum(arr2);
      //  prefixSumInSingleArray(arr2);
    }
}

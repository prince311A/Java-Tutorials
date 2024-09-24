import java.util.Arrays;

public class JT_107_IMPcopyarray {
/*    QUESTION==> We have a array arr[] = {1,2,3} Now We want to double the size of Array with same elements present before
                        Output => arr[] = {1,2,3,0,0,0}

 */

public static void main(String[] args) {
    // AAM ZINDGI*************************************************************
   int arr[] = {1,2,3};
  /*  System.out.println(arr.length);
    System.out.println(Arrays.toString(arr));
    int brr[] = new int[arr.length*2];
    for(int i =0;i<arr.length;i++){
            brr[i] = arr[i];
        }
    arr =brr;
    System.out.println(arr.length);
    System.out.println(Arrays.toString(arr));
    */


  // MENTOS ZINDGI******************************************************************USING Arrays.copyOf()
    int brr[] = Arrays.copyOf(arr,arr.length*2);
    arr = brr;
    System.out.println(Arrays.toString(arr));
}
}

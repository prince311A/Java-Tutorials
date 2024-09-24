import java.util.Arrays;

public class JT_127_StackQuest {
//  Q1)  Largest Rectangle Histogram (BRUTEFORCE APPROACH)
    static int previousSmallerElement(int []arr,int idx) {
        for (int i = idx ; i >= 0; i--) {
            if(arr[i]<arr[idx]){
                return i;
            }
        }
        return -1;
    }
    static int nextSmallerElement(int []arr,int idx){
        for(int i=idx;i<arr.length;i++){
                if(arr[i]<arr[idx]){
                 return i;
                }
            }
        return -1;
    }
    static void largestRectangleHistogramBruteForce(int []arr){
        //FORMULA => max area = (nextSmaller-1)-(previousSmaller+1)+1 * arr[i] this also varies when next-smaller and previous-smaller is -1
        // BEST  OPTIMIZE FORMULA ==> if next-small is -1 make it arr.length, if previous small is -1 make it -1
        // then formula is ==> (next-small-previous-small)-1
        int max  =0;
        int maxarea = 0;
        for(int i = 0;i<arr.length;i++){
            int nextsmall = nextSmallerElement(arr,i);
            int prevsmall = previousSmallerElement(arr,i);
//            System.out.println(nextsmall+" "+prevsmall+" "+i); // checking purpose
            if(prevsmall ==-1&& nextsmall==-1){
                max = arr.length*arr[i];
            }
           else if(nextsmall==-1){
                max = ((arr.length-1)-(prevsmall+1) +1)*arr[i];
            }
          else if(prevsmall==-1){
                max = ((nextsmall-1)+1)*arr[i];
            }

            else if(max<((nextsmall-1)-(prevsmall+1)+1)*arr[i]){
                max=((nextsmall-1)-(prevsmall+1)+1)*arr[i];
            }
            if(maxarea<max){
                maxarea = max;
            }
        }
        System.out.println("The maximum area is "+maxarea);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};

//        System.out.println(nextSmallerElement(arr,3));
//        System.out.println(previousSmallerElement(arr,3));

//        largestRectangleHistogramBruteForce(arr);


    }
}

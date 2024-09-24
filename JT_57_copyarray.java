
public class JT_57_copyarray {
    static void printarray(int []arr){
        for (int w:arr) {
            System.out.print(w+" ");
        }
        System.out.println();
    }
    static void changearray(int arr[]){
        for(int i = 0;i< arr.length;i++){
            arr[i] = 0;
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 9};
       // printarray(a);//1569
        /// now copy one array to another array
        int f[] = a.clone();//clone() helps to deep copy means change in copied array doesnot reflect to original
        f[0] = 0;
        f[1] = 0;
       // printarray(f);//0069
       //  printarray(a);//No change in original array 1569 because of clone()
        //        *******************************************************************************
      //  changearray(a); // change the array because array stored in heap memory
        // --> not like primitive  datatype means change in method doesnot change actual value
        //printarray(a); // change to (0,0,0,0}
       int av[] = {4,5,6,0};
        int ab[] = new int[av.length];
        ab = av;
        printarray(ab);
        printarray(av);
        System.out.println("lets change");
        av[0] = 45;
        ab[0]=33;
        printarray(ab);
        printarray(av);
            }
}
// NOTE:- clone() and Arrays.copyOf() do the same things means change in other array not reflect to original array

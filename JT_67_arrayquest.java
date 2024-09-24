public class JT_67_arrayquest {
    static boolean pefixSuffix(int ar[]){
        int prefix[] = new int[ar.length];
        int suffix[] = new int[ar.length];
        int dst = 0;
        int pst = ar.length-1;
        int pum=0;
        int sum =0;
//        prefix[0] = ar[0];
        for(int i=0;i< ar.length;i++){
            sum = sum+ar[i];
            prefix[dst++] = sum;
        }
        System.out.println("This is prefix sum:");
        for(int i =0;i<ar.length;i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();
//        -------------------------------------------------------------
      suffix[ar.length-1] = ar[ar.length-1];
        for(int i=ar.length-2;i>=0;i--){
            suffix[i] = suffix[i+1]+ar[i];
        }
        System.out.println("This is Suffix sum:");
        for(int i =0;i<ar.length;i++){
            System.out.print(suffix[i]+" ");
        }
        System.out.println();
        for (int i =0;i<ar.length;i++){
            if (prefix[i] == suffix[i+1]){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int arr[] = {5,3,2,6,3,1};

       boolean result =  pefixSuffix(arr);
        System.out.println(result);
    }
}

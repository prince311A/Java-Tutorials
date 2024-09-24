public class JT_64_HODquestion {
//    public static void main(String[] args) {
//        double rewa = 250000;
//        double satna = 320000;
//        double rp =0.07;
//        double sp = 0.06;
//        int year = 0;
//        while(rewa<=satna){
//            rewa = rewa*(1+rp);
//            satna=  satna*(1+sp);
//            year++;
//        }
//        System.out.println(year);
//    }
//}
    public static void main (String[] args)
    {
        // Initialize the array
        int[] arr = {1,1,4,2,1,5,1,4};

        // Create a variable to store the length of array arr
        int l = arr.length;

        // Create two arrays to store the repetitive values and unique values
        int[] rep = new int[l/2];
        int[] unq = new int[l];

        // Create two variables to store the length of rep and unq arrays
        int r, u;
        r = u = 0;

        outerloop:
        for (int i = 0; i < l; i++)
        {
            int x = arr[i];

            // If the value in current iteration is in array rep then it is a repetitive value and should be skipped
            for (int k = 0; k < r; k++)
            {
                if (x == rep[k])
                {
                    continue outerloop;
                }
            }

            for (int j = i + 1; j < l; j++)
            {
                if (x == arr[j])
                {
                    rep[r++] = x;
                    break;
                }
                if (j == l - 1)
                {
                    unq[u++] = x;
                }
            }
        }

        // Print the unique values
        for (int i = 0; i < u; i++)
        {
            System.out.println(unq[i]);
        }
    }
}

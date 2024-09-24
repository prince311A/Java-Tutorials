public class JT_80_recurssion {
//    Q1) Print all the natural numbers from 1 to n
    static void printIncreasing(int n ){
        // halting condtion/base case
        if(n ==1){
            System.out.println(n);
            return;
        }

        // Subproblem /recursion
        printIncreasing(n-1);

        //self work
        System.out.println(n);
    }
//    Q2) Print all the natural numbers from n to 1 (reverse)
    static void printDecreasing(int n){
        // halting condtion/base case
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);  //self work
        printDecreasing(n-1); // Subproblem /recursion
    }
//    Q3) Calculate the factorial of the given number by recursion
    static int factorial(int n){
        if(n==0) return 1;
       int fact =  factorial(n-1);
       int ans = fact*n;
       return ans;
    }
//    Q4) Calculate the fibonacci series of the given number by recursion
    static int fibonacci(int n) {
       /*/ int x = 0;
        int y = 1;
        for (int i = 0; i < n; i++) {
            int z = x + y;
            System.out.println(z);
            x = y;
            y = z;}*/
        if(n ==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
     int x =   fibonacci(n-1);
        int y = fibonacci(n-2);
        int z = x +y;
        return z;
    }
//    Q5) Calculate the sum of the given digits by recursion ex-> 585 = 5+8+5 = 18
    static int sumOfDigits(int n){
//        int sum =0;
//        int count = 0;
//        do { // approch with itration
//           int rem = n % 10;
//           sum = sum + rem;
//            n = n / 10;
//            count++;
//        }while (n!=0);
        if(n ==0) {
            return n;
        }
       int sum= sumOfDigits(n/10);

        int rem = n%10;
        return rem+sum;
    }
//    Q6) Calculate the count of the given digits by recursion ex-> 585 = 3
    static int countDigits(int n){
        if(n<=9){
            return 1;
        }
        int sum = countDigits(n/10);
        int count = sum+1;
        return count;
    }
//    Q7) Calculate the power of the given two number by recursion ex-> 2^4 = 16
    static int pow(int p ,int q){
       if(q==0){
           return 1;
       }
       int power = pow(p,q-1);
       return power*p;
    }
//    Q8) Calculate the multiples of the given number k times by recursion ex-> num =2,k 3=> 2,4,6\
    static void multiple(int num,int k){
        if(k==1){
            System.out.println(num);
            return;
        }
        multiple(num,k-1);
        System.out.println(num*k);
    }
//    Q9) Calculate the sum of the given n natural number by recursion ex-> n=5 ==> 1+2+3+4+5 = 15
    static int SumOfNatural(int n){
        if(n==1){
            return n;
        }
        int sum = SumOfNatural(n-1);
        return sum+n;
    }
// Q10) Calculate the sum of the given n natural number with alternative sign by recursion ex-> n=5 ==> 1-2+3-4+5 = 3
static int SumOfNaturalAlternate(int n){
        if(n==0){
            return 0;
        }
    else if(n%2==0){
        return SumOfNaturalAlternate(n-1)-n;
    }
    else {
        return SumOfNaturalAlternate(n-1)+n;
    }
}
public static void main(String[] args) {
           // int a = 5;
        //printIncreasing(a);
         // printDecreasing(a);
        // System.out.println(factorial(a));
        // System.out.println(fibonacci(4));
      //  System.out.println(sumOfDigits(123));
       // System.out.println(countDigits(156));
       // System.out.println(pow(2,4));
        //multiple(2,3);
       // System.out.println(SumOfNatural(5));
      //  System.out.println(SumOfNaturalAlternate(10));

    }
}

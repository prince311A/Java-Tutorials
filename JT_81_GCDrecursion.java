
public class JT_81_GCDrecursion {
    //Q1) Find the greatest common divisor of given x and y numbers
    static void BasicGcd(int x ,int y){ // Basic approch or brute for approch
        int min;
        if(x>y){
             min  = y;
        }
        else{
            min = x;
        }
       for(int i = min;i>=1;i--){
           if(x%i==0 && y%i==0){
               System.out.println("The GCD of given numbers is "+i);
               break;
           }
       }
    }
    // Quite Good approch to find GCD
    static int LongDivison(int x , int y){
        int rem;
        while(x%y!=0){
            rem= x%y;
           x = y;
           y = rem;
        }
        return y;
    }
    // BEST approch through recurssion
    static int GcdRecursion(int x,int y){
        if(y==0){
            return x;
        }
        return GcdRecursion(y,x%y);
    }
    public static void main(String[] args) {
       // BasicGcd(24,15);//3
        //System.out.println(LongDivison(24,15));//3
        System.out.println(GcdRecursion(17,3233));//3
// Important Note=> LCM * GCD = x * y or
        // LCM  = x * y / GCD
        System.out.println(1296%7);
    }
}
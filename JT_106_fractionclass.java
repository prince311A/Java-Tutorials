import jdk.jfr.Frequency;

import java.util.Arrays;

//Question) Simplify the fractions and Add two fraction
class Fraction{
    int numo;
    int demo;

    Fraction(int numo, int demo){
        this.numo = numo;
        this.demo = demo;
        simplify(); // simplifying when object is created because of constructor
    }
    public void simplify(){ //simplifying the fraction 3/12 ==> 1/4
        int min;
        if(numo>demo){
            min = demo;
        }
        else{
            min = numo;
        }
        int gcd=0;  // GCD helps to calculate the HCF for simplifying
        for(int i = min;i>=1;i--){
            if(numo%i==0 && demo%i==0){
                gcd = i;
                break;
            }
        }
        numo = numo/gcd;
        demo = demo/gcd;
    }
}

public class JT_106_fractionclass {
    public static Fraction addFraction(Fraction f1, Fraction f2){

        int numerator =(f1.numo*f2.demo) + (f1.demo*f2.numo) ;
        int denominator = f1.demo * f2.demo;

//        System.out.println(numerator+"/"+denominator); // use it when return type is void

        Fraction f3 = new Fraction(numerator, denominator);
        return f3;
    }
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        System.out.println(f1.numo+"/"+f1.demo);
      //  f1.simplify(); // simplifying the fraction 3/12 ==> 1/4, we cant call here as well but it's quick to call in constructor
      //  System.out.println(f1.numo+"/"+f1.demo);

        Fraction f2 = new Fraction(4,2);
        System.out.println(f2.numo+"/"+f2.demo);

        // f3 = f1 + f2
        Fraction f3 =addFraction(f1,f2);
        System.out.println("After Adding two fractions "+f3.numo+"/"+f3.demo);

    }
}

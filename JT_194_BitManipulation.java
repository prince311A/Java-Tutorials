import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JT_194_BitManipulation {
//    Q1) Convert Decimal to binary
    static void decimalToBinary(int decimal){
        String str = "";
        while (decimal>0){
            if(decimal%2==0){
                str = str+"0";
            }
            else{
                str = str+"1";
            }
            decimal = decimal/2;
        }
        System.out.println(str);
        StringBuffer buffer = new StringBuffer(str);
        buffer.reverse();
        System.out.println(buffer);
    }
//    Q2) Binary to decimal
    static void binaryToDecimal(String binary){
        int sum = 0;
        int power= 1;
        for(int i =binary.length()-1;i>=0;i--){
            if((binary.charAt(i)!='0')){
                sum = (sum+binary.charAt(i)-'0')*power;
            }
            power = power*2;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int decimal = 8;
//        decimalToBinary(decimal);
        String binary = "1000";
        binaryToDecimal(binary);
    }

}


import java.util.Stack;
public class JT_84_StringRecursion {
//    Q1) Remove the repeating character in array by recurssion
    static String ReturnUnique(String a,int idx){ //"bcx"
        if(idx==a.length()){
            return " ";
        }
       String ans = ReturnUnique(a,idx+1);
        if(a.charAt(idx)!='a'){
            return a.charAt(idx)+ans;
        }
        else{
            return ans;
        }
    }
//    Q2) Reverse the string through recurrsion
    static String reverseString(String a,int idx){
        if(idx==a.length()){
            return "";
        }
        String ans = reverseString(a,idx+1);

        ans = ans+a.charAt(idx);
        return ans;

    }
//    Q3) find a minimum cost to reach the nth index of an array
    public static void main(String[] args) {
        String a = "abcax";
        String b= "prince";
        System.out.println(ReturnUnique(a,0));
        System.out.println(reverseString(b,0));

    }
}


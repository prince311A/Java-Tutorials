import java.util.Arrays;

public class JT_85_question {
    //    Q1) return the index of first non-repeating character in the string
    static int NonRepaeatingindex(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }

        }
        return -1;
    }

    //Q2) Reverse the string
    static void reverseTheString(String s) {
        String ans = "";
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            ans = c + ans;
        }
        System.out.println(ans);
//     **********************************OR************************************
        String s1 = "prince tiwari";
        String ans1 = "";
        for (int i = 0; i < s1.length(); i++) {
            ans1 = s1.charAt(i) + ans1;
        }
        System.out.println(ans1);
    }

    // Q3) Print all the substring input String s = "abcd" ==> a,b,c,d,ab,bc,cd,abc,bcd,abcd
    static void findAllPossibleSubString(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.print(s.substring(i, j) + ", ");
            }
        }
    }
    // Q4) Toggle the string change uppercase to lower and lower to upper
    // Various ways to do this :-
    // String -> char[]  then convert
    // String -> StringBuilder then convert
    // Direct string (very bad approach because string are immutable

    // String -> char[]  then convert
    static void toggleCharArray(char s[]){
        for(int i =0;i<s.length;i++){
            char ch = s[i];
            int ascii = (int)ch;
            if(ascii<=97){
                ascii = ascii+32;
                char dh = (char)ascii;
                s[i] = dh;
            }
            else{
                ascii = ascii-32;
                char dh1 = (char)ascii;
                s[i] = dh1;

            }

        }
        System.out.println(Arrays.toString(s));
    }
    // String -> StringBuilder then convert
    static void toggleStringBuilder(StringBuilder str){
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii<=97){
                ascii = ascii+32;
                char dh = (char)ascii;
                str.setCharAt(i,dh);
            }
            else {
                ascii = ascii-32;
                char dh = (char)ascii;
                str.setCharAt(i,dh);
            }
        }
        System.out.println((str));

    }
        public static void main(String[] args) {
        String s1 = "abcbdsa";
        String s2 = "prince";
        // System.out.println(NonRepaeatingindex(s1));
       // reverseTheString(s2);


        String s3 = "abcd";
      findAllPossibleSubString(s3);

            String s4 = "pHYsics";
            char d[]=s4.toCharArray();
          //  toggleCharArray(d);     // String -> char[]  then convert

            StringBuilder s5 = new StringBuilder(s4);
            //toggleStringBuilder(s5);    // String -> StringBuilder then convert

    }
}

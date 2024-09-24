public class JT_104_stringQuests {
//    Q1) Find the possible substring of the string and in that find the palindrome String
    static void subStringPalindrome(String s1){
        for(int i =0;i<s1.length();i++){
            for(int j = i+1;j<=s1.length();j++){
                String str =s1.substring(i,j);
                String revss =  reverseString(str);
                if(str.equals(revss)){
                    System.out.print(str+" ");
                }
            }
        }
    }
    static String reverseString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
       // String rstr = String.valueOf(str); //// MOST IMP
        String rstr = str+""; // or convert StringBuilder to string
        return rstr;
    }

//    Q2) Check String is Palindrome or not without reversing the String (Optimized And Quickest)
    static void palindromeString(String s){
        int i =0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                System.out.println("Not Palindrome");
                break;
            }
            else {
                System.out.println("Palindrome");
            }
            i++;
            j--;
        }
    }

//    Q3) Reverse Eah Word in String Ex-> I am prince ==> I ma ecnirp
    static void reverseEachWord(String s){
        String ans = "";
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch !=' '){
                sb.append(ch);
            }
            else {
                sb.reverse();
                ans = ans+sb;
                ans = ans+" ";
                sb.delete(0,sb.length());
            }
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(ans+sb);
    }

//    Q4) Compress the string having consecutive character Ex-> aaabbbbccd => a3b4c2d
    static void compressConsecutiveString(String s){

    }

    public static void main(String[] args) {
        String s1 = "abc";
//        subStringPalindrome(s1);

        String s2 = "aabbaa";
//        palindromeString(s2);

        String s3 = "I am an educator";
        reverseEachWord(s3);

        String s4 = "aaabbbbccdddeff";
        String ans = "";
        int count = 1;
        char curr = ' ' ;
        char prev = ' ';
        for(int i =1;i<s4.length();i++) {

             curr = s4.charAt(i);
             prev = s4.charAt(i - 1);
            if (curr == prev) {
                count++;

            } else {
                ans = ans +prev+count;
                count = 1;
            }
        }
        if(count<=0){
            ans = ans+curr;
        }else{
            ans = ans+curr+count;
        }
        System.out.println(ans);
    }
}

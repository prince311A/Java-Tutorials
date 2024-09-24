import java.util.Scanner;

public class JT_174_ValidPassword {
    /* A valid Password should have
     * capital letter
     * smaller letter
     * an integer
     * And a special Character -> @,#,$,%,&,!,^,*,(,),+,=,_,-
     */

    // small letter 97->122
    // Capital letter 65->90
    // integer 48->57
    // special character 33->47
   static boolean specialChar(String str){
        for(int i =0;i<str.length();i++){
            int x = (int)str.charAt(i);
            if(x>=33 && x<=47|| x>=58 && x<=64){
             return true;
            }
        }
        return false;
    }
    static boolean integer(String str){
        for(int i =0;i<str.length();i++){
            int x = (int)str.charAt(i);
            if(x>=48 && x<=57){
                return true;
            }
        }
        return false;
    }
    static boolean smallLetter(String str){
        for(int i =0;i<str.length();i++){
            int x = (int)str.charAt(i);
            if(x>=97 && x<=122){
                return true;
            }
        }
        return false;
    }
    static boolean capitalLetter(String str){
        for(int i =0;i<str.length();i++){
            int x = (int)str.charAt(i);
            if(x>=65 && x<=90){
                return true;
            }
        }
        return false;
    }
    static void validPassword(String str){
       if(str.length()<8 || str.length()>15){
           System.out.println("Password Length Should be between 8-15");
           return;
       }
       if(str.contains(" ")){
           System.out.println("Password should not contain blank space ");
           return;
       }
       if(!specialChar(str)){
           System.out.println("Password should contain a special character");
           return;
       }
       if(!integer(str)){
           System.out.println("Password should contain an integers 0-9");
           return;
       }
       if(!smallLetter(str)){
           System.out.println("Password should contain a small letter a-z");
           return;
       }
       if(!capitalLetter(str)){
           System.out.println("Password should contain a letter capital letter A-Z");
       }
       else{
           System.out.println("Valid Password");
       }


    }
    public static void main(String[] args) {
        String str = "pR1@11122";
        validPassword(str);

    }
}

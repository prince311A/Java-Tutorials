import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.*;
public class JT_16_string {
        public static void main(String k[]){
            String a;
            Scanner sc = new Scanner(System.in);
//            a = sc.nextLine();//not working this here
//            System.out.println("My name is "+a);
// or
            String b = "yahoo";
            System.out.println(b);
//or
            String c = new String();
            c = "AMAN";
            System.out.println(c);
//or
            String d = new String("APSU");
            System.out.println(d);
            System.out.println(d.toLowerCase());
            System.out.println(d.length());
//            ***************************************************************
            String e = "prince";
            System.out.println(e.length()); // gives length of string
            System.out.println(e.toUpperCase()); // gives string in capital letter
            System.out.println(e.charAt(4)); // this method gives character at specified index
// substring method:-
            System.out.println(e.substring(1,3)); // gives character from start index to end
// print string by loop character by character
            for(int i = 0;i<e.length();i++){
                System.out.println(e.charAt(i));

            }
//            ***************************************************************************
            // String immutability with example
            String f = "rahul";
            f.concat("preet");
            System.out.println(f); // it will give rahul becuase new object is created but f refers to the first object
            f = f.concat("preet");// then it will give rahulpreet
            System.out.println(f);
//            *******************************************************************************
            //Constructor in String Class
            String g = new String("prince");//1constructor

            StringBuffer sb = new StringBuffer("yash");
            String sbuffer = new String(sb);// converting mutable string to immutable//2constructor
            System.out.println(sbuffer);

            StringBuilder sbb = new StringBuilder("yahoo");
            String sbuilder = new String(sbb);// converting mutable string to immutable//3constructor
            System.out.println(sbuilder);

            char []chr = new char[]{'r','e','s','t'};
            String charr = new String(chr);//4 constructor
            System.out.println(charr);

            byte []by =new byte[] {101,102,103};
            String byy = new String(by);// 5 constructor
            System.out.println(byy);
//            *****************************************************************************
            //Methods of String Class
            String fg = "    ";
            System.out.println(fg.length());//count space also
            System.out.println(fg.isEmpty()); // count space also so bad approch
            System.out.println(fg.trim().isEmpty());//best approch
            System.out.println(fg.equals(""));//false

            String s1 = "Prince";
            String s2 = "Vandana";//join is a static method
            System.out.println(String.join(";",s1,s2)); // Add Delimeter between two strings
            System.out.println(s1.indexOf('e'));//star with zero like array
            System.out.println(s2.lastIndexOf('a'));
            System.out.println(s1.charAt(0));
            System.out.println(s1.contains("i"));
            System.out.println(s1.startsWith("P"));
            System.out.println(s1.endsWith("d"));

            System.out.println(s1.compareTo(s2));// returns integer

            //Type Conversion Method ==> valueOf(),toCharArray()
            double abc = 100.5;
            String a1 = String.valueOf(abc);// convert different value to string,static method so call by class name
            String a2 = Double.toString(abc);//here toString and valueOf do same thing
            System.out.println(a2);
            System.out.println(a1);
            String chrr = "prince";
            char []ch = chrr.toCharArray();
            System.out.println(Arrays.toString(ch));


            String rp = "prince tiwari";
            rp.replace(" ","");// replace()
            System.out.println("@"+rp.replace(" ","")+rp.length());
            System.out.println(rp.substring(0,1).toUpperCase()+rp.substring(1));

            // sc.next() --> Hello Sir ==> Hello
            // sc.nextLine() --> Hello Sir ==> Hello Sir

        }
    }


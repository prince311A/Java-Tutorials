public class JT_103_stringBuilder_Buffer {
//    Q1) Reversing the String Using string Builder
    static void revserseStringBuilder(StringBuilder s) {

//        String s = "PrinceTiwari";
//        int i = 0;
//        int j = s.length()-1;
//        while(i<j){
//            char temp = s.charAt(i);
//            s.charAt(i) = s.charAt(j); //two pointer approach not possible in string class
//            s.charAt(j) = temp;
//            i++;
//            j--;
//        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j)); // not possible in string class
            s.setCharAt(j, temp);
            i++;
            j--;
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hii I am");
//        str = str+"good";// +.concat cannot be applied here

        //append()
        str.append(" Prince Tiwari"); // it is mutable
        System.out.println(str);

        //setCharAt(idx,char)
        str.setCharAt(1,'Z'); // special method not available in string class
        System.out.println(str);

        //insert(idx,char)
        str.insert(2,'X'); //change length,add charac. to idx and shift right next characters
        System.out.println(str);

        //deleteCharAt(idx)
        str.deleteCharAt(0);//delete character at given idx
        System.out.println(str);

        //delete(from idx,to idx)
        StringBuilder str1 =  new StringBuilder("RahulSingh");
        str1.delete(2,4); // include (2,3,4)
        System.out.println(str1);


        StringBuilder s = new StringBuilder("PrinceTiwari");
//        revserseStringBuilder(s);

        // Converting String to String Builder and vice-versa
        String s1 = "prince";
        StringBuilder ss1 = new StringBuilder(s1); // converted String to StringBuilder

        StringBuilder s2 = new StringBuilder("tiwari");
        String ss2 = s2+""; //converted Builder to String
        //OR
        String ss3 = String.valueOf(s2); //converted Builder to String
    }
}

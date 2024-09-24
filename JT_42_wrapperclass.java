public class JT_42_wrapperclass {
    public static void main(String[] args) {
      /*
      * value()==> doesnot need any argument,non-static means called by the object,converts primitive object to primitive data type,return primitive datatype
      * parse()==>it takes string as argument,static method,convert string to primitive datatype,return primitive datatype
      * toString()==> it takes primitive datatype as argument,static method,convert primitive datatype to string,return string
      * valueOf() ==> Any type of primitive datatype to object and store in Primitive Object
       */
        //1) Convert Any type of primitive data to any  object type
        int ac = 10;
        Double I1=Double.valueOf(ac);
        //2) object to primitve data type
         double i = I1.doubleValue();
        System.out.println(i);
//        *****************************************************
        //3) string to primitve datatype
        String s ="83";
        int a = Integer.parseInt(s);
        System.out.println("a= "+a);
//        *********************************************************
//      4)primitive datatype to string
       double s1 = 45;
        String sc =Double.toString(s1);
        System.out.println(sc);
    }


}

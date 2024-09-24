 class JT_19_methodoverloading {
   void fun1(){
        System.out.println("This is the method without arguments");
    }
    void fun1(int x){
        System.out.println("The square value of number is "+x*x);
    }
    void fun1(int x,int y){
        System.out.println("The sum of two number is "+(x+y));
    }
    public static void main(String[] args) {
      JT_19_methodoverloading p = new JT_19_methodoverloading();
      p.fun1();
//      fun1();// works when method is static
      p.fun1(5);
      p.fun1(2,5);
   // In case of changing array in methods the actual array will be change because array is the object
        // In method overloading name should be name
        // Arugements should be different
        // returntype can be same or different it doesnt matter
   }
}

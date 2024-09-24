public class JT_33_tryandcatch {
    public static void main(String k[]){
        int a = 1000;
        int b = 0;
        try{
            int c = a/b;
            System.out.println("The result of division is "+c);
        }
        catch(Exception e){
            System.out.println("Sorry we could not find out the result");
            System.out.println(e);
        }
        System.out.println("End of the program");
    }
}

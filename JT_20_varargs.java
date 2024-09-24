public class JT_20_varargs {
    // This variable argument method is used to take as much arguments without changing in the formal arguments of the method
    static int sum(int...arr){
//        int arr[] //available as
        int result = 0;
        for (int elemment:arr) {
            result = result+elemment;
        }
        return result;
        }
        // for taking compulsory one argument or at least one argument then
    static int sum1(int x,int...arr){
        int result = x;
        for (int element :arr
             ) {
            result = result+element;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = sum(1,2,5,7);
        System.out.println("The sum of the number is "+x);
        int y = sum1(1,4,5);
        System.out.println("The sum is "+y);
    }
}

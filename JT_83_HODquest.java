import java.util.Scanner;

public class JT_83_HODquest {
    static int CountryIndex(String country[][],String count) {
        int a;
        for (int i = 0; i < country.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (country[i][j].toUpperCase().equals(count.toUpperCase())) {
                     a = i;
                     return a;}}}
        return 0;}
    public static void main(String k[]) {
        String country[][] = {{"India", "Delhi"},
                {"Pakistan", "Islamabad"}, {"China", "Beijing"},
                {"Nepal","Kathmandu"}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the country");
        String count = sc.next();
        System.out.println("Enter the capital");
        String cty = sc.next();
        int a = CountryIndex(country,count);
        if(cty.toUpperCase().equals(country[a][1].toUpperCase())){
            System.out.println("Correct Answer");
        }
        else{
            System.out.println("Wrong Answer");}}}
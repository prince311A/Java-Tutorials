import java.io.*;
import java.util.Scanner;

public class JT_38_readfromfile {
    public static void main(String[] args){
        // reaing data in character form---------------------------------------------------------------------------
        File myfile = new File("Prince.txt");
        try{
            Scanner sc = new Scanner(myfile);
            while(sc.hasNextLine()){
                String Line = sc.nextLine();
                System.out.println(Line);
            }
            sc.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}

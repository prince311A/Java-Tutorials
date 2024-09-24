import java.io.*;
import java.util.Scanner;

public class JT_37_writeinfile {
    public static void main(String[] args) {
        // Write in a file at compile time(by FileWriter) character form---------------------------------------------------------------
        try {
//            String r = "hello";// also working
            FileWriter myfile = new FileWriter("Prince.txt", true);
            myfile.write("I am Prince Tiwari\n");
//            myfile.write(r);
            myfile.close();
            System.out.println("Message written successfully");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error Something went wrong");
        }
//  ---------------------------------------------------------------------------------------------------------
            // Write in a file at runtime (by FileOutputStream) byte form--------------------------------------------------------------------------
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the message to written in file");
            String a = sc.nextLine();
            try {
                FileOutputStream myfile2 = new FileOutputStream("Prince.txt", true);
                byte c[] = a.getBytes();
                myfile2.write(c);
                myfile2.close();
                System.out.println("Message Written Successfully");
            } catch (Exception f) {
                f.printStackTrace();
                System.out.println("Error Something went wrong");
            }
        }
}

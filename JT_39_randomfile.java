//import java.io.IOException;
import java.io.*;
import java.util.Scanner;

class RDemo {
    int id;
    String name;
    RandomAccessFile raf;

    RDemo() {
        try {
            RandomAccessFile raf = new RandomAccessFile("Prince.txt", "rw");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getadata() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id");
            id = sc.nextInt();
            System.out.println("Enter name");
            name = sc.next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writedata() {
        Scanner sc = new Scanner(System.in);
        try {
            String choice = "yes";
            int size = (int) raf.length();//return length of file
            raf.seek(size);//set file pointer at end of file
            while (choice.equals("yes")) {
                getadata();
                raf.writeInt(id);
                raf.writeUTF(name);
                System.out.println("More records yes or no");
                choice = sc.next().trim();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readrecord()

    {
        try {
            raf.seek(0);
            int size = (int) raf.length();
            while (raf.getFilePointer() < size) {
                int id = raf.readInt();
                String name = raf.readUTF();
                System.out.println("Id no:" + id + " Name " + name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }

    public class JT_39_randomfile {
        public static void main(String[] args) throws IOException {
            RDemo p = new RDemo();
            p.writedata();
            p.readrecord();
//            p.raf.close();
        }
    }

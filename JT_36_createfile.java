import java.io.File;
import java.io.IOException;

public class JT_36_createfile {
    public static void main(String[] args) throws IOException {

        File myfile = new File("Prince.txt");
   try{
    if(myfile.createNewFile()){
        System.out.println("File is created");
    } else {
        System.out.println("File is already created");
    }
        System.out.println(myfile.canRead());
        System.out.println(myfile.canWrite());
        System.out.println(myfile.getName());
        System.out.println(myfile.getFreeSpace());
}
        catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }


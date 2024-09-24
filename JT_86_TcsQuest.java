import java.util.Scanner;
public class JT_86_TcsQuest {
static int CarRace(int n1,int n2){
        int Acar=1;
        int Bcar = 0;
        int sec =0;
        if(n1>n2){
            return -1;
        }
        else {
            while(Bcar<=Acar) {
                Acar =Acar + n1;
                Bcar = Bcar +n2;
                sec++;
                if(Bcar>Acar){
                    return sec;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.println("Enter the Acar speed");
        //int n1 = sc.nextInt();
       // System.out.println("Enter the Bcar speed");
        //int n2= sc.nextInt();
      //  System.out.println(CarRace(n1,n2));
    }
}

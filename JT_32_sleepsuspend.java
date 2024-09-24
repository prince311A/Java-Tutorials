class TH1 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Most imporatant Thread");
        }
    }
}
class TH2 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Two");
            try {
                Thread.sleep(5000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
class TH3 extends Thread{
    public void run(){
        for(int i=0;i<40;i++){
            System.out.println("Three");
        }
    }
}
class TH4 extends Thread{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("Four");
        }
    }
}
public class JT_32_sleepsuspend{
    public static void main(String[] args){
        TH1 p1 = new TH1();
        p1.start();

        TH2 p2 = new TH2();
        p2.start();

        TH3 p3 = new TH3();
        p3.start();
        TH4 p4 = new TH4();
         p4.start();
    }
}

// This is multithreading by the implementation of runnable interface
class MythreadRunable1 implements Runnable{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Prince the don");
        }
    }
}
class MyThreadRunable2 implements Runnable{
    public void run(){
        for (int i = 0; i < 90; i++) {
            System.out.println("Yahoo");
        }
    }
        }
public class JT_30_runnablethread {
    public static void main(String[] args) {
        MythreadRunable1 p = new MythreadRunable1();
        Thread p1 = new Thread(p);
        p1.start();
        MyThreadRunable2 q = new MyThreadRunable2();
        Thread q1 = new Thread(q);
        q1.start();
    }
}

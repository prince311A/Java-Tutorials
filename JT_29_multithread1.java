// This is multithreading by extending thread class
class multithreadA extends Thread{
    public void run(){
        for(int i = 0;i<90;i++){
            System.out.println("Hii I am prince");
        }
    }
}
class multithreadB extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("ok");
        }
    }
}
public class JT_29_multithread1 {
    public static void main(String k[]){
        multithreadA p = new multithreadA();
        multithreadB q = new multithreadB();
        p.start();
        q.start();
    }
}

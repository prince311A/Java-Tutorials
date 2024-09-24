class Thh1 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Most imporatant Thread");
        }
    }
}
class Thh2 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Two");
        }
    }
}
class Thh3 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Three");
        }
    }
}
class Thh4 extends Thread{
    public void run(){
        for(int i=0;i<90;i++){
            System.out.println("Four");
        }
    }
}
public class JT_31_prioritythread {
    public static void main(String[] args) {
        Thh1 p1 = new Thh1();
        p1.setPriority(Thread.MAX_PRIORITY);
        p1.start();
        Thh2 p2 = new Thh2();
        p2.setPriority(Thread.NORM_PRIORITY);// NORM priority is defalut
        p2.start();
        Thh3 p3 = new Thh3();
        p3.setPriority(Thread.NORM_PRIORITY);
        p3.start();
        Thh4 p4 = new Thh4();
        p4.setPriority(Thread.MIN_PRIORITY);
        p4.start();
    }
}

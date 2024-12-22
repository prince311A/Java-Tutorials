
// About join() method--> it waits for another thread to complete its tasks then after join with it
class Test1 extends Thread{
    public static Thread mainThread;
    public void run(){
            try {
                for(int i =0;i<5;i++) {
                    mainThread.join(); // when this enables means Thread-0 wait main execute

                    System.out.println(Thread.currentThread().getName() + " " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
public class JT_209_MultiThreading_join extends Test {

    public static void main(String[] args) throws InterruptedException {
        Test1 t1 = new Test1();
        // Case-1 let main thread should wait till t1 complete it task
        t1.start(); // first this executes after that below for loop execute
//        t1.join(); // when this enable means main wait Thread-0 excute

        // Case-2 let first main thread complete its task the child thread executed
        // storing reference of main thread
        Test1.mainThread = Thread.currentThread();

        for (int i =0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }




    }


}

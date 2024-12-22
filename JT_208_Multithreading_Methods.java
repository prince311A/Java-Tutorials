class Test extends Thread{
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            // get priority of t i.e demon
            System.out.println("Demon Thread :" + Thread.currentThread().getName()+ " Priority "+
                    Thread.currentThread().getPriority());
        } else {
            // get priority of t1 i.e normal
            System.out.println("Normal Thread :" + Thread.currentThread().getName()+ " Priority "+
                    Thread.currentThread().getPriority());
        }
    }
}


public class JT_208_Multithreading_Methods {
    public static void main(String[] args) {
        Thread.currentThread().setName("master");// setName
        System.out.println(Thread.currentThread().getName());// get Name
        Test t = new Test();
        Test t1 =new Test();

        t.setDaemon(true); // setting demon
        t.start();
        t.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY); // windows doesn't support that why didn't work

        System.out.println("Check Demon :"+t.isDaemon()); // check isDemon
        System.out.println("Check Demon :"+t1.isDaemon()); // check isDemon


    }
}

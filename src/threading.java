import java.util.concurrent.ConcurrentHashMap;

/**
 * Program to print 1-10 with 2 threads and thread which starts first will print oddd and another will print even nos.
 *
 */
public class threading {

    public static void main(String[] args) {
        Signal s=new Signal(new Object());
        Thread t1= new Thread(s);
        Thread t2= new Thread(s);
        t1.start();
        t2.start();

        ConcurrentHashMap concurrentHashMap;
    }
}

/**
 * if wait or notifyall is not called at acquired monitor or lock then it will throw illegalmonitorstateexception
 */

class Signal implements Runnable{

    volatile int i=1;
    Object lock;
    public Signal(Object lock){this.lock=lock;}
    @Override
    public void run() {

            synchronized (lock){
                while(i<10){
                System.out.println(i++ +" "+ Thread.currentThread().getName());
                lock.notifyAll();
                try {
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class EvenOddSem {

    public static void main(String[] args) {
        SharedPrinter1 sp = new SharedPrinter1();
        // Starting two threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new EvenNumProducer1(sp, 10));
        executor.execute(new EvenNumProducer1(sp, 10));
        executor.execute(new OddNumProducer1(sp, 10));
        executor.shutdown();
    }

}

//Shared class used by both threads
class SharedPrinter1{
    boolean evenFlag = false;
    // 2 semaphores
    Semaphore semEven = new Semaphore(0);
    Semaphore semOdd = new Semaphore(1);

    //Method for printing even numbers
    public void printEvenNum(int num){
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(num);
        semOdd.release();
    }

    //Method for printing odd numbers
    public void printOddNum(int num){
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(num);
        semEven.release();

    }
}

//Thread Class generating Even numbers
class EvenNumProducer1 implements Runnable{
    SharedPrinter1 sp;
    volatile  static int index=2;
    EvenNumProducer1(SharedPrinter1 sp, int index){
        this.sp = sp;
       // this.index = index;
    }
    @Override
    public void run() {
        //for(int i = 2; i <= index; i = i+2)
        {
            sp.printEvenNum(index);
        }

    }

}

//Thread Class generating Odd numbers
class OddNumProducer1 implements Runnable{
    SharedPrinter1 sp;
    int index;
    OddNumProducer1(SharedPrinter1 sp, int index){
        this.sp = sp;
        this.index = index;
    }
    @Override
    public void run() {
        for(int i = 1; i <= index; i = i+2){
            sp.printOddNum(i);
        }
    }
}
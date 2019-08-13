package multhread;

import java.util.concurrent.Semaphore;

public class Foo {

    private Semaphore sec = new Semaphore(0);
    private Semaphore thd = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sec.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sec.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thd.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thd.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
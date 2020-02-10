/*
按顺序打印(多线程)
https://leetcode-cn.com/problems/print-in-order/
 */
public class PrintByNo2 {
    //只有volatile变量来强制各线程读取主内存。
    private volatile boolean firstFinished;
    private volatile boolean secondFinished;
    private Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstFinished = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //空循环等待变量 firstFinished 为true时，执行打印
        while (!firstFinished) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondFinished = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        //空循环等待变量 secondFinished 为true时，执行打印
        while (!secondFinished) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}


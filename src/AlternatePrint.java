/**
 * 交替打印
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * 两个不同的线程将会共用一个  实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次
 */
public class AlternatePrint {
    private int n;
    private volatile boolean fooLock = false;
    public AlternatePrint(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooLock){}
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooLock = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooLock){};
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooLock = false;
        }
    }
}

package ex6;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector implements Runnable {

    @Override
    public void run() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads();
        System.out.println("Dang quet deadlock...");
        if (threadIds == null) {
            System.out.println("Khong phat hien deadlock.");
        } else {
            System.out.println("Phat hien deadlock!");
        }
    }
}

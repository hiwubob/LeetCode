package 多线程;

import java.util.concurrent.CountDownLatch;

public class 跑步 {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Player(begin, end));
            thread.start();
        }
        try {
            System.out.println("比赛开始了");
            begin.countDown();
            end.await();
            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Player implements Runnable {
        CountDownLatch begin;
        CountDownLatch end;

        public Player(CountDownLatch begin, CountDownLatch end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                begin.await();
                System.out.println(Thread.currentThread().getName() + "arrived");
                end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

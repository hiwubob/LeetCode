package ��Ʊ;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopTickets {
    private static volatile AtomicInteger tickets=new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(3);
        Executor exe = Executors.newCachedThreadPool();
        exe.execute(new TicketSales(doneSignal, "��ƱԱ 1", tickets));
        exe.execute(new TicketSales(doneSignal, "��ƱԱ 2", tickets));
        exe.execute(new TicketSales(doneSignal, "��ƱԱ 3", tickets));
        doneSignal.await();
        System.out.println("Ʊ������");

    }


}

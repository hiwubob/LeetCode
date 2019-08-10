package ��Ʊ;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketSales implements Runnable {
    private final CountDownLatch doneSignal;
    private final AtomicInteger tickets;
    private String salename;
    public TicketSales(CountDownLatch doneSignal, String salename, AtomicInteger tickets) {

        this.doneSignal = doneSignal;
        this.tickets = tickets;
        this.salename = salename;
    }

    public void run() {
        doSales(tickets);
    }

    private void doSales(AtomicInteger tickets) {
        try {
            while (tickets.get() > 0) {
                System.out.println(salename + "����һ��Ʊ���У�" + tickets.decrementAndGet() + "��");
                Thread.sleep(1000);
            }
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

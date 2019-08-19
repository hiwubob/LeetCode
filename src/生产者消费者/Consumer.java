package 生产者消费者;

import javax.swing.*;

public class Consumer implements Runnable {
    private Storage storage;
    public Consumer(Storage storage){};

    public Consumer(Storage storage, String string) {
        this.storage = storage;
    }

    public void run(){
        while (true) {
            try{
                Thread.sleep(1000);
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

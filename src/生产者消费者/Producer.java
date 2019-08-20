package 生产者消费者;

import JIANZHIOffer.TreeNode;

public class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage){};


    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

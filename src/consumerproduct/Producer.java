package consumerproduct;



public class Producer implements Runnable {
    //生产者
    private Storage storage;

    public Producer(Storage storage){
        this.storage=storage;
    };


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

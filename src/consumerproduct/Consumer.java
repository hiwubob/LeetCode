package consumerproduct;



public class Consumer implements Runnable {
    //消费者
    private Storage storage;
    public Consumer(Storage storage){
        this.storage=storage;
    }

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

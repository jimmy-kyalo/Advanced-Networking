public class Consumer extends Thread {
    private SynchQueue synQue;

    public Consumer(SynchQueue que) {
        synQue = que;
    }

    @Override
    public void run() {
        int item = 0;
        do {
            item = synQue.remove();
            System.out.println("Consumer:" + this + " value:" + item);
        }
        while (item != -1);
    }
}

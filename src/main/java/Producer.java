public class Producer extends Thread {
    private SynchQueue synQue;
    private int maxItem, minItem;

    public Producer(SynchQueue que, int min, int no) {
        synQue = que;
        minItem = min;
        maxItem = min + no;
    }

    @Override
    public void run() {
        for (int item = minItem; item < maxItem; item++) {
            System.out.println("Producer:" + this + " value:" + item);
            synQue.insert(item);
        }
    }
}

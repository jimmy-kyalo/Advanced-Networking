public class SynchQueue {
    private int front = 0, back = 0, noItems = 0;
    //    queue buffer
    private int[] tabItems;
    //    maximum no of items in queue
    private int maxnoItems;

    public SynchQueue(int maxsize) {
        maxnoItems = maxsize;
        tabItems = new int[maxnoItems];
    }

    //    returns no of items in queue
    public int queueSize() {
        return noItems;
    }

    //    insert elements in queue
    public synchronized void insert(int item) {
        // check for space availability
        while (noItems == maxnoItems) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // insert items at back
        tabItems[back] = item;
        // move back index one step
        back = (back + 1) % maxnoItems;
        // increment no of items
        noItems+=1;
        // notify all threads waiting for the object that it is free
        notifyAll();
    }
    /* remove objects from queue */
    public synchronized int remove(){
        int item;
        // wait if queue is empty
        while (noItems == 0){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        // retrieve item at front
        item=tabItems[front];
        // move front index one step
        front = (front+1)%maxnoItems;
        noItems-=1;
        notifyAll();
        return item;
    }
}

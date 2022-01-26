public class MultiProdCons {
    public static void main(String[] args) {
        int noCons = 3, noProds = 4;
        // create 5 element queue
        var sque = new SynchQueue(5);
        // create consumers and produces
        Consumer[] cons = new Consumer[noCons];
        Producer[] prods = new Producer[noProds];

        // start the consumers
        for (int i = 0; i < noCons; i++) {
            cons[i] = new Consumer(sque);
            cons[i].start();
        }

        // start the producers
        for (int i = 0; i < noProds; i++) {
            prods[i] = new Producer(sque, i * 100, 50);
            prods[i].start();
        }

        // wait for producers to finish
        for (int i = 0; i < noProds; i++) {
            try {
                prods[i].join();
            } catch (InterruptedException e) {
            }
        }

        // insert -1 in queue for each consumer to terminate
        for (int i = 0; i < noCons; i++) {
            sque.insert(-1);
        }

        // wait for consumers to terminate
        for (int i = 0; i < noCons; i++) {
            try {
                cons[i].join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Successful completion!");
    }
}

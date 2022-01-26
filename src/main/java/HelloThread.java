public class HelloThread extends Thread {
    int pause;
    private static final int TIMES = 10;

    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            try {
                System.out.println("Hello!");
                pause = (int) (Math.random() * 3000);
                sleep(pause);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}

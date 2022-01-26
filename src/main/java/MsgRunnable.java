public class MsgRunnable implements Runnable {
    private String message;
    private static final int TIMES = 10;

    public MsgRunnable(String aMessage) {
        message = aMessage;
    }

    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            try {
                System.out.println(message);
                int pause = (int) (Math.random() * 3000);
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}

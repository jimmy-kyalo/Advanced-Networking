import java.util.Date;

public class DateRunnable implements Runnable {
    private Date date;
    private static final int TIMES = 10;

    public DateRunnable(Date adate) {
        date = adate;
    }

    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            try {
                var nowDate = new Date();
                System.out.println("Started:" + date + " now:" + nowDate);
                int pause = (int)(Math.random()*3000);
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}

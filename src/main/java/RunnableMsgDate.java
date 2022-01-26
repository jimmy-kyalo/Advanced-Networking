import java.util.Date;

public class RunnableMsgDate {
    public static void main(String[] args) {
        var mr= new MsgRunnable("Hello!");
        var dr = new DateRunnable(new Date());
        var mt = new Thread(mr);
        var dt = new Thread(dr);
        mt.start();
        dt.start();
    }
}

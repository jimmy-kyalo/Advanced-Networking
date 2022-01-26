public class ThreadHelloCount {
    public static void main(String[] args) {
        var count = new CountThread();
        var hello = new HelloThread();
        count.start();
        hello.start();
    }
}

package api.java.lang;

public class ShutdownHookDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Demo of a Shutdown hook.");
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        System.out.println("Waiting 5 second...");
        Thread.sleep(5000);
        System.out.println("At the end of the main thread, the shutdownhook is executed");
    }

    // a class that extends thread is to be called when the program does exit
    static class ShutDownHook extends Thread {
        public void run() {
            System.out.println("This thread, part of the class ShutDownHook, is executed after the main thread exited...");
        }
    }
}
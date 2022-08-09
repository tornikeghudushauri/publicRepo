package main;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            String ans = "generating out  files";
            if (Thread.currentThread().getId()<18) {ans = "generating in files";}
            System.out.println("დრო: " + java.time.LocalTime.now() + " ეტაპი: " + ans);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

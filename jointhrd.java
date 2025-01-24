class DownloadTask extends Thread {
    public void run() {
        System.out.println("Thread Class: Downloading file...");
        try {
            Thread.sleep(3000); // Simulates download time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download complete!");
    }
}
public class ThreadJoinExample {
    public static void main(String[] args) {
        DownloadTask downloadThread = new DownloadTask();
        downloadThread.start();        
        // Main thread immediately tries to process the file
        System.out.println("Main class: Processing the file...");
    }
}
// With Join

class DownloadTask extends Thread {
    public void run() {
        System.out.println("Downloading file...");
        try {
            Thread.sleep(3000); // Simulates download time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download complete!");
    }
}
public class ThreadJoinExample {
    public static void main(String[] args) {
        DownloadTask downloadThread = new DownloadTask();
        downloadThread.start();        
        try {
            downloadThread.join(); // Main thread waits for downloadThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Processing the file...");
    }
}

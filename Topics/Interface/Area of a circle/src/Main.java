public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // main thread

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());

        System.out.println(t.MIN_PRIORITY);
        System.out.println(t.MAX_PRIORITY);

    }
    public void printIfDaemon(Thread thread){
        System.out.println("Daemon: " + thread.isDaemon());
    }
}
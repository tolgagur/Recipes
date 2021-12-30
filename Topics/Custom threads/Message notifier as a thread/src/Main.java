class MessageNotifier extends Thread {

    // write fields to store variables here

    public MessageNotifier(String msg, int repeats) {
        for (int i=0;i<repeats;i++)
            System.out.println(msg);
    }

    @Override
    public void run() {
        // implement the method to print the message stored in a field
    }
}
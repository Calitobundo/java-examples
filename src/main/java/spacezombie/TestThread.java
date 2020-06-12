package spacezombie;

public class TestThread extends Thread {

    private TestListener listener;
    public volatile boolean running = true;
    private long now;
    private long before;

    public TestThread(TestListener listener) {
        this.listener = listener;
        this.before = System.currentTimeMillis();
    }

    @Override
    public void run() {

        long time = 0;

        while (running){

            now  = System.currentTimeMillis();
            long delta = now - before;
            time += delta;
            before = now;

            if(time > 1000){

                listener.onEvent(now);
                time = 0;
            }

            try {
                sleep(10);
            } catch (InterruptedException ignored) { }
        }



    }
}

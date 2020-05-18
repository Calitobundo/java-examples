package timer;

public class Timer {

    private final Thread thread;
    private volatile boolean running = true;

    private long before;

    public Timer(long callbackTime, TimerCallback callback) {
        this.before = System.currentTimeMillis();
        this.thread = new Thread(() -> {

            final long sleep = callbackTime/10;
            while(running) {
                long now = System.currentTimeMillis();
                long delta = now - before;
                if(delta > callbackTime){
                    callback.onTimer(delta);
                    before = now;
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ignored) {
                }
            }
        });

    }

    public void start(){
        thread.start();
    }

    public void stop(){
        running = false;
    }

}


package timer;

public class Timer {

    private Thread thread;
    private volatile boolean running = true;

    private long before;

    public Timer(long callbackTime, TimerCallback callback) {
        this.before = System.currentTimeMillis();
        this.thread = new Thread(() -> {

            while(running) {
                long now = System.currentTimeMillis();
                long delta = now - before;
                if(delta > callbackTime){
                    callback.onTimer(now);
                    before = now;
                }
                try {
                    Thread.sleep(100);
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


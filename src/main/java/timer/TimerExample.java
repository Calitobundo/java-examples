package timer;

public class TimerExample {

    public static void main(String[] args) throws InterruptedException {
        new TimerExample();
    }

    public TimerExample() throws InterruptedException {

        //TimerCallback callback = now -> {
        //    System.out.println("now: " + now);
        //};

        TimerCallback callback2 = new MyCallback();

        Timer timer =  new Timer(2000, callback2);
        timer.start();

        Thread.sleep(8000);
        timer.stop();

    }

    public class MyCallback implements TimerCallback {

        @Override
        public void onTimer(long now) {
            System.out.println("now: " + now);
        }
    }


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

}















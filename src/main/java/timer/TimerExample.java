package timer;

public class TimerExample {


    private Thread thread;

    public TimerExample() {

    }

    public static void main(String[] args) {
        TimerExample app = new TimerExample();
        app.start();
    }

    public void start(){

        thread =  new TimerThread(now -> {
            System.out.println("now: "+now);
        });
        thread.start();

    }


    public class TimerThread extends Thread {

        private final TimerEvent event;
        private long before;

        public TimerThread(TimerEvent event) {
            this.event = event;
            this.before = System.currentTimeMillis();
        }

        @Override
        public void run() {

            while(true) {

                long now = System.currentTimeMillis();
                long delta = now - before;
                if(delta > 2000){
                    before = now;
                    event.onTimer(now);
                }

            }
        }
    }

}















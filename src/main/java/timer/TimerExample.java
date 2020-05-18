package timer;

public class TimerExample {

    public TimerExample() throws InterruptedException {

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

    public static void main(String[] args) throws InterruptedException {
        new TimerExample();
    }

}















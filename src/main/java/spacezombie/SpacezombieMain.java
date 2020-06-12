package spacezombie;

public class SpacezombieMain implements TestListener {

    private TestThread thread;
    private boolean running = true;

    public SpacezombieMain() throws InterruptedException {

        thread = new TestThread(this);
        thread.start();

        while (running){


            Thread.sleep(10000);
            thread.running = false;
            running = false;
        }




    }

    @Override
    public void onEvent(long now) {

        System.out.println("onEvent "+now);

    }

    public static void main(String[] args) throws InterruptedException {
        new SpacezombieMain();
    }
}

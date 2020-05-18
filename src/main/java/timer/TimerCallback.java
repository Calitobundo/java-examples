package timer;

@FunctionalInterface
public interface TimerCallback {

    void onTimer(long now);

}

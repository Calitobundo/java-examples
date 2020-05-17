package timer;

@FunctionalInterface
public interface TimerEvent {

    void onTimer(long time);

}

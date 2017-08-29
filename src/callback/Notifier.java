package callback;

/**
 * Created by liuxiao on 2017/6/11.
 */
public class Notifier {

    private SomeEvent event;
    private boolean somethingHappened;

    public Notifier(SomeEvent event) {
        this.event = event;
    }

    public void doWork() {
        if (somethingHappened) {
            event.doSomeJob();
        }
    }
}

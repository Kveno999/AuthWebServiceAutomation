package base.waits;

public class WaitStrategyFactory {
    public ToExists exists() {
        return new ToExists(30, 2);
    }

    public ToExists exists(int timeoutInterval, int sleepInterval) {
        return new ToExists(timeoutInterval, sleepInterval);
    }

    public ToBeVisible beVisible(int timeoutInterval, int sleepInterval) {
        return new ToBeVisible(timeoutInterval, sleepInterval);
    }

    public ToBeVisible beVisible() {
        return new ToBeVisible(30, 2);
    }

    public ToBeClickable beClickable(int timeoutInterval, int sleepInterval) {
        return new ToBeClickable(timeoutInterval, sleepInterval);
    }

    public ToBeClickable beClickable() {
        return new ToBeClickable(30, 2);
    }
}

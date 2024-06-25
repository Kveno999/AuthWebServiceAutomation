package base.waits;

public class Wait {
    public static WaitStrategyFactory to() {
        return new WaitStrategyFactory();
    }
}

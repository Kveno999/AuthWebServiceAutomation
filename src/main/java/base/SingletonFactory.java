package base;

import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {
    private static final SingletonFactory singletonFactory = new SingletonFactory();

    private final Map<String, Object> mapHolder = new HashMap<>();

    private SingletonFactory() {
    }

    public static <T> T getInstance(Class<T> classOf, Object... initArgs) {
        try {
            if (!singletonFactory.mapHolder.containsKey(classOf.getName())) {
                T obj = (T) classOf.getConstructors()[0].newInstance(initArgs);
                singletonFactory.mapHolder.put(classOf.getName(), obj);
            }
            return (T) singletonFactory.mapHolder.get(classOf.getName());
        } catch (Exception e) {
            return null;
        }
    }
}

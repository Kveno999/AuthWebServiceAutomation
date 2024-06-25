package base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    OPERA("opera"),
    SAFARI("safari"),
    INTERNET_EXPLORER("internetExplorer");

    private final String value;

    Browser(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Browser fromValue(String value) {
        for (Browser browser : Browser.values()) {
            if (browser.value.equalsIgnoreCase(value)) {
                return browser;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + value);
    }
}

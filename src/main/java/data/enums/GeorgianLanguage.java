package data.enums;

import lombok.Getter;

@Getter
public enum GeorgianLanguage implements Language {

    KA("ka"),
    MINT("ming"),
    SVAN("svan");

    private final String value;

    GeorgianLanguage(String value) {
        this.value = value;
    }
}

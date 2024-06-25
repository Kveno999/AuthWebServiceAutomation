package teststeps;

import data.enums.GeorgianLanguage;

public class WrongCredentialsTranslatorSteps {

    public static String getErrorMessageByLanguage(GeorgianLanguage language) {
        switch (language) {
            case SVAN -> {
                return "მონაცემოლ სწორ დემეგ ლი";
            }
            case MINT -> {
                return "მუნაჩემეფი ვა რე თინუ";
            }
            default -> {
                return "მონაცემები არასწორია";
            }
        }
    }

}

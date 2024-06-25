package utils;

import java.util.Random;

public class RandomUtils {

    public static String generateRandomGeorgianString(int length) {
        String GEORGIAN_ALPHABET = "აბგდევზთიკლმნოპჟრსტუფქღყშჩცძწჭხჯჰ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(GEORGIAN_ALPHABET.length());
            sb.append(GEORGIAN_ALPHABET.charAt(index));
        }

        return sb.toString();
    }

}

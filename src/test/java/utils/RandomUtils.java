package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(randomInt(10, 100));
        System.out.println(randomEmail());

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(randomItem(names));

    }
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    public static String randomString(int length) {

//        String AB = "0123456789ABXDEFGHIJKLMNOPRSTUVWXYZ";
        String AB = "ABXDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnoprstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < length; i++)
            stb.append(AB.charAt(rnd.nextInt(AB.length())));

        return stb.toString();

    }

    public static String randomEmail() {
        return randomString(10) + "@mail.com";
    }

    public static String randomItem(String[] values) {
        int index = randomInt(0, values.length - 1);
        return  values[index];
    }

}

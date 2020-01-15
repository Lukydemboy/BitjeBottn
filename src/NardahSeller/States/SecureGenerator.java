package NardahSeller.States;

import org.rspeer.runetek.api.commons.Time;

import java.security.SecureRandom;

public class SecureGenerator {

    public static void randomSleep(int min, int max) {
        SecureRandom random = new SecureRandom();
        Time.sleep(random.nextInt(max - min) + min);
    }
    public static int randomInt(int min, int max){
        SecureRandom random = new SecureRandom();
        return random.nextInt(max - min) + min;
    }
}
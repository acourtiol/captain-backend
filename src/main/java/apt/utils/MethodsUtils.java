package apt.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MethodsUtils {
    private static String salt = "hackathondjshfjsdhg65464544";

    public static String hashPass(String password) {
        return DigestUtils.sha256Hex(password + salt);
    }

}

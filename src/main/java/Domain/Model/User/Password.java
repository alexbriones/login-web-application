package Domain.Model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Password {
    private static String ENCRYPTATION_TYPE = "MD5";

    private byte[] passwordEncrypted;

    public Password(String password) {
        this.passwordEncrypted = encryptPassword(password);
    }

    private byte[] encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ENCRYPTATION_TYPE);
            return messageDigest.digest(password.getBytes());

        } catch (NoSuchAlgorithmException e) {
            return password.getBytes();
        }
    }

    public byte[] getPasswordEncryted() {
        return this.passwordEncrypted;
    }

    public boolean equals(String password) {
        return (Arrays.equals(this.passwordEncrypted, encryptPassword(password)));
    }
}

package com.fakecinema.helper;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Vova on 05.06.2019.
 */
public class Hash {

    static public String hashPass (String password) {
        String encryptedPassword = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            encryptedPassword = String.format("%032X", new BigInteger(1, hashedPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}

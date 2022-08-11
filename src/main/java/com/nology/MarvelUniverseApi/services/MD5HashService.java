package com.nology.MarvelUniverseApi.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class MD5HashService {
    public static String getMD5Hash(Timestamp timestamp, String privateApiKey, String publicApiKey) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String toHash = timestamp + privateApiKey + publicApiKey;
            byte[] messageDigest = md.digest(toHash.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(no.toString(16));
            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        }  catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

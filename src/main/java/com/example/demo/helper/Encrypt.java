package com.example.demo.helper;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by fengjiamin on 2018/3/19.
 */
public class Encrypt {
    public static final String KEY_MD5 = "MD5";

    public static String getMd5Result(String inputStr, String salt) {
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            inputStr = inputStr.concat(salt);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16).substring(1);
    }
}

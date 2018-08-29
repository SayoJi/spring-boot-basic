package com.sayo.girl.config;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("encryor")
public class Encryor {

    @Autowired
    private StandardPBEStringEncryptor standardPBEStringEncryptor;

    @Autowired
    private StandardPBEByteEncryptor standardPBEByteEncryptor;

    public String encrypt(String str) {
        return this.standardPBEStringEncryptor.encrypt(str);
    }

    /**
     * decrypt the string if pattern match with ENC()
     * otherwise return the original values
     */
    public String decrypt(String encrypted) {
        try {
            String patternStr = "^ENC\\((.*)\\)$";
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(encrypted);
            if (matcher.find()) {
                String decryptStr = null;
                String matched = matcher.group(1);
                //If encrypted by byte, decrypt by byte.
                if (Pattern.compile("(-{0,1}[0-9]{1,3}\\|)+").matcher(matched).find()) {
                    byte[] ba = stringToByte(matched);
                    byte[] decryptByte = this.standardPBEByteEncryptor.decrypt(ba);
                    char[] decryptChar = byteToChar(decryptByte);
                    decryptStr = String.valueOf(decryptChar);
                } else {
                    decryptStr = this.standardPBEStringEncryptor.decrypt(matched);
                }
                return decryptStr;
            } else {
                return encrypted;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //String is a set of number splitting by '|'.
    private byte[] stringToByte(String matched) {
        String[] sl = matched.split("\\|");
        byte[] bl = new byte[sl.length];
        for (int i = 0; i < bl.length; ++i) {
            bl[i] = Byte.valueOf(sl[i]);
        }
        return bl;
    }

    //Change byte to char using bit operation.
    public char[] byteToChar(byte[] ba) {
        char[] ca = new char[ba.length / 2];
        for (int i = 0; i + 1 < ba.length; i += 2) {
            ca[i / 2] = (char) (((ba[i] & 0xFF) << 8) | (ba[i + 1] & 0xFF));
        }
        return ca;
    }


}

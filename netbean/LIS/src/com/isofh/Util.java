/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh;

import java.nio.charset.Charset;

/**
 *
 * @author vanminh
 */
public class Util {

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes, int length) {
        if (length == 0) {
            length = bytes.length;
        }
        char[] hexChars = new char[length * 2];
        for (int j = 0; j < length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String bytesToHex(byte[] bytes) {
        return bytesToHex(bytes, 0);
    }

    public static String repChar(char c, int reps) {
        String adder = Character.toString(c);
        String result = "";
        while (reps > 0) {
            if (reps % 2 == 1) {
                result += adder;
            }
            adder += adder;
            reps /= 2;
        }
        return result;
    }

    public static String getMessage(byte[] data, int length) {
        if (length == 0) {
            length = data.length;
        }
        if (length <= 8) {
            return "";
        }
        byte[] results = new byte[length - 8];
        for (int i = 0; i < results.length; i++) {
            results[i] = data[i + 1];
        }
        return new String(results, Charset.forName("US-ASCII"));
    }
}

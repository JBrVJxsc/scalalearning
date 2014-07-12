package com.scala.exercises.impatient.chapter10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Who on 14-7-12.
 */
public class Caesar {
    public static final String SOURCE = "abcdefghijklmnopqrstuvwxyz";
    public static final int LEN = SOURCE.length();

    //Encryption
    public static String caesarEncryption(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() < 1) {
            System.out.println("you Input nothing.");
            return null;
        }
        if (!isAlp(s)) {
            System.out.println("input ABC... only");
            return null;
        }
        s = s.toLowerCase();
        int len = s.length();
        for (int j = 0; j < len; j++) {
            char c = s.charAt(j);
            int a = SOURCE.indexOf(c);
            if (a == LEN - 1) a = -1;
            if (a == LEN - 2) a = -2;
            if (a == LEN - 3) a = -3;
            sb.append(SOURCE.charAt(a + 3));
        }
        return sb.toString();
    }

    //Decryption
    public static String caesarDecryption(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() < 1) {
            System.out.println("you Input nothing.");
            return null;
        }
        if (!isAlp(s)) {
            System.out.println("input ABC... only");
            return null;
        }
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = SOURCE.indexOf(c);
            if (a == 2) a = LEN + 2;
            if (a == 1) a = LEN + 1;
            if (a == 0) a = LEN;
            sb.append(SOURCE.charAt(a - 3));
        }
        return sb.toString();
    }

    public static boolean isAlp(String s) {
        String p = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}

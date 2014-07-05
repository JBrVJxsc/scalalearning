package com.scala.common;


/**
 * Created by Who on 2014/5/28.
 */
public final class Random {
    private static java.util.Random random = new java.util.Random();

    public static int getInt(int bound) {
        return random.nextInt(bound);
    }

    public static long getLong() {
        return random.nextLong();
    }
}

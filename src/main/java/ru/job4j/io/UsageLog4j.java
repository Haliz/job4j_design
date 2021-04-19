package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int a = 10;
        char b = 'b';
        float c = 3.14F;
        double d = 55.22;
        byte e = 100;
        long f = 500;
        short g = 1000;
        boolean h = true;
        LOG.debug("int variable : {}, char variable : {}, float variable : {}, double variable : {},"
                        + "byte variable : {}, long variable : {}, short variable : {}, boolean variable : {},",
                a, b, c, d, e, f, g, h);
    }
}

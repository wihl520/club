package com.gzqf.club.utils;

import java.util.Random;

/**
 * <p>Description: </p>
 * 生成一个4位数的随机数验证码
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 16:22
 **/
public class RandomNumber {
    public static String randomNumber() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++) {
                fourRandom = "0" + fourRandom;
            }
        }
        return fourRandom;
    }
}

package com.ywf.JavaCourseDesign;

import java.util.Random;



public class IdGenerater {
    private static  final int SHORT_MAX=65536;
    private static int counter=-1;


    public static synchronized Long nextId() {
        long now = System.currentTimeMillis();
        if (counter == -1) {

            long seed = now ^ Thread.currentThread().getId();

            Random rnd = new Random(Long.hashCode(seed));
            counter = rnd.nextInt(SHORT_MAX);
        }
        // 保证每次生成的id都不一样
        Long id = (now << 16) | counter;

        counter = (counter + 1) % SHORT_MAX;
        return id;
    }



}

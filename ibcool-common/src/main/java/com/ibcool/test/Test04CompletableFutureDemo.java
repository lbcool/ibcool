package com.ibcool.test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: Test04CompletableFutureDemo
 * @Description:
 *  练习 CompletableFuture
 * @date 2021/7/30
 */
public class Test04CompletableFutureDemo {

    static List<Prople> list = Arrays.asList(new Prople("1", "小明"),
            new Prople("2", "王五"),
            new Prople("3", "张六"),
            new Prople("4", "李四"));


    public static void main(String[] args) {
    }


    static class Prople {
        private String id;

        public Prople(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
        private int age;
    }

    public static int calculate(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new SecureRandom().nextInt(100) + name.charAt(0);
    }
}

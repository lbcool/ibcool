package com.ibcool.test;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: Test05CompletableFutureDemo2
 * @Description:
 * @date 2021/7/30
 */
public class Test05CompletableFutureDemo3 {


    public static void main(String[] args) {
        Prople prople = new Prople();
        long l = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - l);
        System.out.println(prople.toString());
    }


    public static String m1() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { }
       return "李云龙";
    }
    public static String m2() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { }
        return "pre李云龙";
    }
    public static String m3() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { }
        return "next李云龙";
    }

    @Data
    @ToString
    static class Prople {
        private String name;
        private String preName;
        private String nextName;
    }
}

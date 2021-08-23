package com.ibcool.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: Test05CompletableFutureDemo2
 * @Description:
 * @date 2021/7/30
 */
public class Test05CompletableFutureDemo2 {

    public static void main(String[] args) throws Exception {
        m2();
        TimeUnit.SECONDS.sleep(5);
    }

    // 计算结果合并
    public static void m2() throws Exception {
        CompletableFuture.runAsync(() -> {
            try { t1(); } catch (Exception e) { e.printStackTrace(); }
        }).thenRunAsync(() -> {
            try { t2(); } catch (Exception e) { e.printStackTrace(); }
        }).thenRunAsync(() -> {
            try { t3(); } catch (Exception e) { e.printStackTrace(); }
        });
    }

    public static void t1() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1------执行了");
    }
    public static void t2() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2------执行了");
    }
    public static void t3() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3------执行了");
    }

    // 优先级
    public static void m1() {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        })
                .applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }), result -> {
            return result;
        }).join());
    }

}

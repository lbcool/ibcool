package com.ibcool.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: Test03CompletableFuture
 * @Description:
 * 可以异步编排的线程
 * @date 2021/7/29
 */
public class Test03CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("无返回值线程...");
        });

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值线程...");
            return 12;
        }).thenApply(p -> {
            return p + 12;
        }).whenComplete((r,e) -> {
            System.out.println(r);
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        System.out.println(future.get());
        System.out.println("主线程 ---- is over!");
        // 简单使用 Com
        // pletableFuture，直接调用get方法还是会阻塞
    }
}

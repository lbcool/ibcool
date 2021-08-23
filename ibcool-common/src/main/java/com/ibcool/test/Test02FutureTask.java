package com.ibcool.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: Test02FutureTask
 * @Description:
 * 测试Future线程，带返回值的线程
 * @date 2021/7/29
 */
public class Test02FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("开始任务....");
            try {
                TimeUnit.SECONDS.sleep(5);
                return 1024;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1024;
        });

        new Thread(futureTask, "返回值线程").start();
        System.out.println(futureTask.get());
        /**
         * FutureTask优缺点
         *  get()方法在调用的时候会阻塞主线程
         *  什么方案比阻塞好？ 轮询 > 阻塞，要么使用fuTureTask.get(xx, xx),设置超时的获取时间
         *  但是轮询会消耗CPU资源
         *  有没有更好的方案解决轮询和阻塞方案 ------ CompletableFuture, 异步编排的fuTureTask
         **/
    }
}

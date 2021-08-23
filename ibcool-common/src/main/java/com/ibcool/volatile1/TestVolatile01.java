package com.ibcool.volatile1;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunlng
 * @ClassName: TestVolatile01
 * @Description:
 * @date 2021/8/6
 */
public class TestVolatile01 {
    static  boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("开始");
            while (flag) {

            }
            System.out.println("结束");
        }, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            flag = false;
        }, "t2").start();
    }
}

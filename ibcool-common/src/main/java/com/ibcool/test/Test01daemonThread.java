package com.ibcool.test;

/**
 * @author liyunlng
 * @ClassName: Test01daemonThread
 * @Description:
 *  测试守护线程
 * @date 2021/7/29
 */
public class Test01daemonThread {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            System.out.println("守护线程正在执行！");
            while (true) {
            }
        }, "守护线程");
        // 设置此线程为守护线程，主线结束守护线程跟着消失
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

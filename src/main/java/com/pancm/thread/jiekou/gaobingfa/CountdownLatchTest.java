/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: CountdownLatchTest
 * Author:   admin
 * Date:     2019/9/29 14:56
 * Description: 使用 CountDownLatch 模拟1000一个并发访问
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou.gaobingfa;


/**
 * 〈自动化测试平台〉
 * 〈使用 CountDownLatch 模拟1000一个并发访问〉
 *
 * @author admin
 * @create 2019/9/29
 * @since 1.0.0
 */

import java.util.concurrent.CountDownLatch;


public class CountdownLatchTest {
    private static final int CONCURRENCE_COUNT = 1000 + 1;
    private static CountDownLatch cd = new CountDownLatch(1000);

    public static void main(String[] args) {
        // 一千个线程，同时怼一个方法
        for (int i = 0; i < CONCURRENCE_COUNT; i++) {
            new Thread(new SendTask()).start();

            cd.countDown();
        }

        long currentTimeMillis = System.currentTimeMillis();

        try {
            cd.countDown();

            cd.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("当前用时：" +
                (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void sendsms() {
        System.out.println("信息发送成功" + System.currentTimeMillis());
    }

    private static class SendTask implements Runnable {
        @Override
        public void run() {
            try {
                cd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendsms();
        }
    }
}

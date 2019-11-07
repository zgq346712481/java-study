/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: MockMultiThreadController
 * Author:   admin
 * Date:     2019/9/29 14:38
 * Description: 使用CountDownLatch模拟高并发:CountDownLatch和CyclicBarrier底层都是通过计数器实现的,场景化：有一道阻塞墙，站着一个管理员，手里拿着N（线程数）个牌子，到达一个线程，把牌子给该线程，当手里牌子都发完时，打开墙门，放行所有线程通过
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou.gaobingfa;

/**
 * 〈如何模拟真正的高并发请求（countdownlatch和cyclicbarrier）〉
 * 〈使用CountDownLatch模拟高并发:CountDownLatch和CyclicBarrier底层都是通过计数器实现的,场景化：有一道阻塞墙，站着一个管理员，手里拿着N（线程数）个牌子，到达一个线程，把牌子给该线程，当手里牌子都发完时，打开墙门，放行所有线程通过〉
 * 该类用于模拟高并发请求，参考文档
 *
 * @author admin
 * @create 2019/9/29
 * @see <a href="http://www.importnew.com/30073.html"></a> https://blog.csdn.net/xichengqc/article/details/86673159
 * @since 1.0.0
 */

import java.util.concurrent.CountDownLatch;

public class MockMultiThreadController {
    private static final int NUM = 5;
    private static int count = 0;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        System.out.println("Ready, Go!");
        waitAllArrrived(countDownLatch);
        try {
            // 阻塞等待
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }

    /**
     * @return
     * 任务启动，到达一个计数减1，都到达后开启gate
     */
    private static void waitAllArrrived(CountDownLatch countDownLatch) {
        for (int i = 0; i < NUM; i++) {
            Thread t = new Thread() { //线程执行类,开始运行方法
                @Override
                public void run() {
                    try {
                        bizCode();//执行业务类方法
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            };
            t.start();
        }
    }

    /**
     * 业务调用，对数字进行加1操作
     */
    private static void bizCode() {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println("This is bizCode--" + i + "count:" + count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
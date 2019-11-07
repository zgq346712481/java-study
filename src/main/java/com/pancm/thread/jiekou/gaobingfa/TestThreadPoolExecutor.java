/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: TestThreadPoolExecutor
 * Author:   admin
 * Date:     2019/9/30 16:41
 * Description: ThreadPoolExecutor构造方法参数的使用规则
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou.gaobingfa;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈自动化测试平台〉
 * 〈ThreadPoolExecutor构造方法参数的使用规则〉
 * java多线程对CountDownLatch的使用实例 https://www.cnblogs.com/kaituorensheng/p/9043494.html
 * https://www.cnblogs.com/cdf-opensource-007/p/8769777.html
 *
 * @author admin
 * @create 2019/9/30
 * @since 1.0.0
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        // 任务1
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                    System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 任务2
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 任务3
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            }
        });

        // 任务4
        pool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
            }
        });

        // 任务5
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_005---------------" + Thread.currentThread().getName());
            }
        });

    }

}
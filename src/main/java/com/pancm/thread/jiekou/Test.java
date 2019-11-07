/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: main
 * Author:   admin
 * Date:     2019/9/29 14:17
 * Description: 写一个test 类的main方法来执行多线程并发
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈自动化测试平台〉
 * 〈写一个test 类的main方法来执行多线程并发 〉
 *
 * @author admin
 * @create 2019/9/29
 * @since 1.0.0
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {

        long begaintime = System.currentTimeMillis();//开始系统时间

        //线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //设置集合点为93
        final int count = 50;
        CountDownLatch countDownLatch = new CountDownLatch(count);//与countDownLatch.await();实现运行完所有线程之后才执行后面的操作
        //final CyclicBarrier barrier = new CyclicBarrier(count);  //与barrier.await() 实现并发;
        //创建100个线程
        for (int i = 0; i < count; i++) {

            MyThread target = new MyThread("para1", "para2", "para3", countDownLatch);
            //barrier.await();
            pool.execute(target);
        }

        pool.shutdown();
        try {
            countDownLatch.await();  //这一步是为了将全部线程任务执行完以后，开始执行后面的任务（计算时间，数量）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis(); //结束时间
        System.out.println(count + " 个  接口请求总耗时 ： " + (endTime - begaintime) + "-----平均耗时为" + ((endTime - begaintime) / count));
    }

}
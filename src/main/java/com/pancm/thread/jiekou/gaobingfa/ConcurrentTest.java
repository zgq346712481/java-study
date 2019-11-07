///**
// * Copyright (C), 2005-2019, 北京优路教育股份有限公司
// * FileName: ConcurrentTest
// * Author:   admin
// * Date:     2019/9/29 15:13
// * Description: CountDownLatch 模拟高并发:CountDownLatch 是 java.util.concurrent 包下的一个同步辅助类，它能使一个或多个线程在其他的线程的一系列操作完成之前一直等待，初始化值为计数器大小（即线程数量）。  二、使用场景 同时启动多个线程； 多个线程操作完成之前一直等待。 注：此处“同时”只能是“大约同时”，涉及到每个线程是否可以分配到一个自由的处理器，系统是否繁忙，线程释放CPU的速度，线程的优先级等等诸多因素。  三、主要方法 await() 方法是线程阻塞，直到计数器为0，才会启动；  countDown() 方法使计数器减1。
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者           修改时间           版本号              描述
// */
//package com.pancm.thread.jiekou.gaobingfa;
//
///**
// * 〈自动化测试平台〉
// * 〈CountDownLatch 模拟高并发:CountDownLatch 是 java.util.concurrent 包下的一个同步辅助类，它能使一个或多个线程在其他的线程的一系列操作完成之前一直等待，初始化值为计数器大小（即线程数量）。  二、使用场景 同时启动多个线程； 多个线程操作完成之前一直等待。 注：此处“同时”只能是“大约同时”，涉及到每个线程是否可以分配到一个自由的处理器，系统是否繁忙，线程释放CPU的速度，线程的优先级等等诸多因素。  三、主要方法 await() 方法是线程阻塞，直到计数器为0，才会启动；  countDown() 方法使计数器减1。〉
// *高并发实例：此处为模拟100个线程同时对一条数据进行加1操作
// * https://blog.csdn.net/u012099869/article/details/52769384
// * @author admin
// * @create 2019/9/29
// * @since 1.0.0
// */
//
//import javax.annotation.PostConstruct;
//
//import org.jvnet.hk2.annotations.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.wlm.test.award.AwardDao;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @author wengliemiao
// */
//@Service
//public class ConcurrentTest {
//    @Autowired
//    private AwardDao awardDao;
//
//    /**
//     * 线程数量
//     */
//    public static final int THREAD_NUM = 100;
//
//    /**
//     * 开始时间
//     */
//    private static long startTime = 0L;
//
//    @PostConstruct
//    public void init() {
//        try {
//            startTime = System.currentTimeMillis();
//            System.out.println("CountDownLatch started at: " + startTime);
//
//            // 初始化计数器为1
//            CountDownLatch countDownLatch = new CountDownLatch(1);
//
//            for (int i = 0; i < THREAD_NUM; i ++) {
//                new Thread(new Run(countDownLatch)).start();
//            }
//
//            // 启动多个线程
//            countDownLatch.countDown();
//
//        } catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//    }
//
//    /**
//     * 线程类
//     */
//    private class Run implements Runnable {
//        private final CountDownLatch startLatch;
//
//        public Run(CountDownLatch startLatch) {
//            this.startLatch = startLatch;
//        }
//
//        @Override
//        public void run() {
//            try {
//                // 线程等待
//                startLatch.await();
//
//                // 执行操作
//                awardDao.update(3);
//
//                long endTime = System.currentTimeMillis();
//                System.out.println(Thread.currentThread().getName() + " ended at: " + endTime + ", cost: " + (endTime - startTime) + " ms.");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
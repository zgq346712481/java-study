///**
// * Copyright (C), 2005-2019, 北京优路教育股份有限公司
// * FileName: WaitThreadTest
// * Author:   admin
// * Date:     2019/9/29 15:16
// * Description: 等待多个线程处理实例
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者           修改时间           版本号              描述
// */
//package com.pancm.thread.jiekou.gaobingfa;
//
///**
// * 〈自动化测试平台〉
// * 〈等待多个线程处理实例〉
// *
// * @author admin
// * @create 2019/9/29
// * @since 1.0.0
// */
//import java.util.concurrent.CountDownLatch;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Service;
//
///**
// * @author wengliemiao
// */
//@Service
//public class WaitThreadTest {
//
//    @PostConstruct
//    public void init() {
//        try {
//            System.out.println("******************** WaitThreadTest started at:" + System.currentTimeMillis() + " ********************");
//            CountDownLatch stopLatch = new CountDownLatch(3);
//
//            for (int i = 0; i < 3; i ++) {
//                new Thread(new Run(stopLatch)).start();
//            }
//
//            // 等待所有线程操作完成
//            stopLatch.await();
//
//            System.out.println("******************** WaitThreadTest ended at:" + System.currentTimeMillis() + " ********************");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public class Run implements Runnable {
//
//        private CountDownLatch stopLatch;
//
//        public Run(CountDownLatch countDownLatch) {
//            this.stopLatch = countDownLatch;
//        }
//
//        @Override
//        public void run() {
//            // 线程操作
//            System.out.println(Thread.currentThread().getName() + " Handler...");
//
//            // 线程结束操作
//            stopLatch.countDown();
//        }
//    }
//
//}
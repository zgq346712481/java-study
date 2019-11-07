/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: MyThread
 * Author:   admin
 * Date:     2019/9/29 14:17
 * Description: 写一个 MyThread 类 继承Runnable 接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou;

/**
 * 〈自动化测试平台〉
 * 〈写一个 MyThread 类 继承Runnable 接口〉
 *
 * @author admin
 * @create 2019/9/29
 * @since 1.0.0
 */

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {

    private String para1;
    private String para2;
    private String para3;
    private CountDownLatch countDownLatch;  //多线程结束后，执行后面的代码（计算时间、数量）

    public MyThread(String para1, String para2, String para3, CountDownLatch countDownLatch) {
        this.para1 = para1;
        this.para2 = para2;
        this.para3 = para3;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            postRequest.postRequestTest(para1, para2, para3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }


}
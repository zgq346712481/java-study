/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: StoppableTask
 * Author:   admin
 * Date:     2019/9/30 10:40
 * Description: java中volatile关键字的作用与用法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.concurrent.volatil;

/**
 * 〈自动化测试平台〉
 * 〈java中volatile关键字的作用与用法〉
 * https://www.cnblogs.com/blog-Aevin/p/9302678.html
 *
 * @author admin
 * @create 2019/9/30
 * @since 1.0.0
 */
public class StoppableTask extends Thread {
    private volatile boolean pleaseStop;

    @Override
    public void run() {
        while (!pleaseStop) {
            // do some stuff...

        }

    }


    public void tellMeToStop() {

        pleaseStop = true;

    }
}
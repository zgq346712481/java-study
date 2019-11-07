/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: MyThread3
 * Author:   admin
 * Date:     2019/9/29 15:34
 * Description: 利用多线程Runnable，共用一个参数问题:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.runnable;

/**
 * 〈自动化测试平台〉
 * 〈利用多线程Runnable，共用一个参数问题:〉
 * 案例：
 * 售货员卖票问题，一个旅游景点有40张票，开启了两个买票的窗口，请用线程的方式，进行模拟售货员卖票过程，并进行分析。
 * 思路：景点的40张票是一个共享票池，当进行售票时，进行票数确认售票和票数-1，为保证卖的票不是同一张票，必须进行加锁并进行票数判断
 *
 * @author admin
 * @create 2019/9/29
 * @since 1.0.0
 */
//使两个线程共用一个安全的数据，保障数据安全

/**
 * 售票线程  
 * 进行售票线程的模拟,利用Runnable接口实现重写run方法，保证线程的安全
 * @author [Light]（必须）
 * @see      [run()]（可选）  
 * @since [version 1.0] （必须）
 */
public class MyThread3 implements Runnable {
    //售票数
    int num = 40;
    //设置锁旗标
    Object lock = new Object();

    @Override
    public void run() {
        // TODO Auto-generated method stub　　　
        //循环开始售票
        while (num > 0) {
            //进行加锁，获取锁
            synchronized (lock) {
                //判断是否售完
                if (num > 0) {
                    //模拟售票过程
                    System.out.println(Thread.currentThread().getName() + "卖出第" + num + "张票");
                    num--;
                }
                try {
                    //进行睡眠，暂时放弃cpu的使用，但不释放锁
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}

//主函数MyTest.java

/************************************************************   
 Copyright (C), 1988-1999, Huawei Tech. Co., Ltd.   
 FileName: Mytest.java   
 Author:       Light 
 Version :          version1.0
 Date:              2018/7/11
 Description:      //模拟售货员售票        
 Version:         // 版本信息 
 1.开启两个进程，通过Runnable接口实现多线程
 2.保证两个进程公用一个售票参数
 Function List:     // 主要函数及其功能     
 1.Thred3售票线程
 2.Thred3.start();开启线程
 History: 
 // 历史修改记录 

 <author>  <time>   <version >   <desc>       
 Light        2018/7/11     1.0     build this moudle   
 ***********************************************************/
class MyTest {

    //主函数
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建MyThread3线程
        Runnable myThread3 = new MyThread3();
//开启两个线程
        Thread t1 = new Thread(myThread3);
        Thread t2 = new Thread(myThread3);
        t1.start();
        t2.start();
    }
}
//从结果可以看出，开启的两个线程公用了同一个售票池，进行售票，通过加锁，实现了每一张票对每一人的售卖，最终进行示例的模拟。
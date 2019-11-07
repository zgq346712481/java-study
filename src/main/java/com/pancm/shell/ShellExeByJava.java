///**
// * Copyright (C), 2005-2019, 北京优路教育股份有限公司
// * FileName: ShellExeByJava
// * Author:   admin
// * Date:     2019/9/28 17:18
// * Description: java连接ssh执行shell脚本
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者           修改时间           版本号              描述
// */
//
//package com.pancm.shell;
//
//import com.jcraft.jsch.Session;
//
//import java.io.IOException;
//import java.sql.Connection;
//
///**
// * 〈自动化测试平台〉
// * 〈java连接ssh执行shell脚本〉
// * Java执行shell脚本文件
// * @author admin
// * @create 2019/9/28
// * @since 1.0.0
// */
//public class ShellExeByJava {
//    static Connection conn = null;
//    static String hostname = "XXXiP地址2";
//    static String username = "root";
//    static String password = "zhou123";
//    static int port = 36000;
//
//
//    public static void connect()
//            throws IOException {
//        try {
//            conn = new Connection(hostname,port);
//            conn.connect();
//            conn.authenticateWithPassword(username, password);
//        } catch (Exception e) {
//            System.out.println("ִ���쳣");
//            System.out.println("" + e);
//        }
//    }
//
//
//    @SuppressWarnings("resource")
//    public static String execCommand(String command) throws IOException {
//        connect();
//        Session session = conn.openSession();
//        session.execCommand(command);
//        StreamGobbler stdout = new StreamGobbler(session.getStdout());
//        BufferedReader br = new BufferedReader(new InputStreamReader((stdout),
//                "UTF-8"));
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        session.close();
//        return line;
//    }
//
//
//    @SuppressWarnings("resource")
//    public static ArrayList<String> execCommandd(String command)
//            throws IOException {
//        connect();
//        Session session = conn.openSession();
//        session.execCommand(command);
//        ArrayList<String> array_result = new ArrayList<String>();
//        StreamGobbler stdout = new StreamGobbler(session.getStdout());
//        BufferedReader br = new BufferedReader(new InputStreamReader((stdout),
//                "UTF-8"));
//        String line;
//        while ((line = br.readLine()) != null) {
//            array_result.add(line);
//        }
//        session.close();
//        return array_result;
//    }
//
//    public static void main(String[] args) {
//        try {
//            // System.out.println( execCommandd("uname -s -r -v"));
//            System.out.println( execCommandd("pwd"));//使用的sh方式执行
//            System.out.println( execCommandd("sh /script/test3.sh"));//使用的sh方式执行
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//}
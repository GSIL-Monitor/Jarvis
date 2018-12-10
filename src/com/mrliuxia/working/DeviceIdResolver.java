package com.mrliuxia.working;

import sun.misc.BASE64Decoder;
import com.mrliuxia.util.FileUtil;
import com.mrliuxia.util.PrintUtil;

import java.io.File;
import java.net.URLDecoder;
import java.util.Scanner;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/5/17
 */
public class DeviceIdResolver {

    public static void main(String[] args) throws Exception {
        System.out.println("\n华为 组1============================");
        decodeDeviceId("CQlkNmI2OTk1YjM3NThhZjRmCU1ZVjAyMTU4MjYwMDExNTM%3D");
        decodeDeviceId("CQlhODlmMmNkMzM3MDBlZDcwCU1ZVjAyMTU4MjYwMDExNTM%3D");
        decodeDeviceId("CQkxNjgxNjNlMjM1OGVhOTVkCU1ZVjAyMTU4MjYwMDExNTM%3D");
        System.out.println("===================================");

        System.out.println("\n魅族 组1============================");
        decodeDeviceId("CQkzNmEzYWE1YjE0OGU5ZjkxCTg4MVFBRFM2QURWQjQ%3D");
        decodeDeviceId("CQk3NmU5OGEzMDFkODljM2E1CTg4MVFBRFM2QURWQjQ%3D");
        decodeDeviceId("CQljNjhiYmE1ZTUwNmE3MzFiCTg4MVFBRFM2QURWQjQ%3D");
        decodeDeviceId("CQk3ZmRhODNlZTc5ZjE3MjY2CTg4MVFBRFM2QURWQjQ%3D");
        System.out.println("===================================");

        System.out.println("\n魅族 组2（明献）=====================");
        decodeDeviceId("CQk0ZWFiNTA5ZjdkZmJmN2FiCTgwU1FCRFBMMjI2Vko%3D");
        decodeDeviceId("CQliMjA4NzI0M2IzMjQzMjEwCTgwU1FCRFBMMjI2Vko%3D");
        System.out.println("===================================");

        System.out.println("\nos8.0 ============================");
        decodeDeviceId(new File("/Users/netease/Desktop/deviceId变化排查/os8.0"));
        System.out.println("===================================");

        System.out.println("\nos7.0 ============================");
        decodeDeviceId(new File("/Users/netease/Desktop/deviceId变化排查/os7.0"));
        System.out.println("===================================");
    }

    public static void decodeDeviceId(String deviceId) throws Exception {
        String d1 = URLDecoder.decode(deviceId);
        byte[] bytes;
        bytes = new BASE64Decoder().decodeBuffer(d1);
        StringBuilder androidIDSB = new StringBuilder();
        StringBuilder serialNumSB = new StringBuilder();
        boolean targetAndroidID = true;
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (c == '\t') {
                if (androidIDSB.toString().length() > 0) {
                    targetAndroidID = false;
                }
                continue;
            }
            if (targetAndroidID) {
                androidIDSB.append(c);
            } else {
                serialNumSB.append(c);
            }
        }
        PrintUtil.print(70, "deviceId:", deviceId);
        if (targetAndroidID) {
            PrintUtil.println("This is IMEI or mac");
            return;
        }
        PrintUtil.print(35, "android_id: ", androidIDSB.toString());
        PrintUtil.print(40, "serial.sub: ", serialNumSB.toString());
        PrintUtil.println(30, "serial.len: ", serialNumSB.toString().length());
    }

    public static void decodeDeviceId(File file) throws Exception {
        Scanner scan = new Scanner(FileUtil.readFromFile(file));
        while (scan.hasNext()) {
            String s = scan.next();
            decodeDeviceId(s);
        }
    }


}

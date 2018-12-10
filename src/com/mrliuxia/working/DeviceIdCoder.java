package com.mrliuxia.working;

import com.mrliuxia.util.PrintUtil;

import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuxiao
 * Created: 2018/12/3 22:32
 * Description:
 */
public class DeviceIdCoder {

    private static final String KEY_ANDROID_ID = "android_id";
    private static final String KEY_SERIAL = "serial";
    private static final String KEY_SEP = "\t";

    public static void main(String[] args) {
        String oldDeviceId = "CQkyNmVhODMwNjg0MDlhNDA1CWNiNTNjODI%3D";
        String newDeviceId = "CQk4M2YyNDQ5NGIzOGQwN2Y5CWNiNTNjODI%3D";

        PrintUtil.print(42, "DeviceId");
        PrintUtil.print(20, "android_id");
        PrintUtil.println(10, "SERIAL");

        Map<String, String> oldDataMap = decode(oldDeviceId);
        PrintUtil.print(42, oldDeviceId);
        PrintUtil.print(20, oldDataMap.get(KEY_ANDROID_ID));
        PrintUtil.println(10, oldDataMap.get(KEY_SERIAL));

        Map<String, String> newDataMap = decode(newDeviceId);
        PrintUtil.print(42, newDeviceId);
        PrintUtil.print(20, newDataMap.get(KEY_ANDROID_ID));
        PrintUtil.println(10, newDataMap.get(KEY_SERIAL));
    }

    public static Map<String, String> decode(String deviceId) {
        Map<String, String> result = new HashMap<>();
        String source = new String(Base64.getDecoder().decode(URLDecoder.decode(deviceId)));
        String[] data = source.trim().split(KEY_SEP);
        result.put(KEY_ANDROID_ID, data[0]);
        result.put(KEY_SERIAL, data[1]);
        return result;
    }

}

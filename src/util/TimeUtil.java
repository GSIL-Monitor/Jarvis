package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/4/2
 */
public class TimeUtil {

    public static String parseToString(long time) {
        return parseToString(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String parseToString(long time, String template) {
        return new SimpleDateFormat(template).format(time);
    }

    public static Long parseToTimeStamp(String time) {
        return parseToTimeStamp(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static Long parseToTimeStamp(String time, String template) {
        try {
            return new SimpleDateFormat(template).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}

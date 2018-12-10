package com.mrliuxia.heiheihei.w0082_simple_operator;

import java.util.*;

/**
 * Created by Poker on 2016/12/29.
 */
public class Hello {

    public static void main(String[] args) throws Exception{

        Calendar c = Calendar.getInstance();
        Calendar c1 = new GregorianCalendar(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)
        ,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND));
        c1.add(Calendar.HOUR, 2);
        System.out.println(c1.getTime());
        System.out.println(c.getTime());

        System.out.println((c1.getTimeInMillis()-c.getTimeInMillis())/1000/60);
        System.out.println((c1.get(Calendar.HOUR_OF_DAY) - c.get(Calendar.HOUR_OF_DAY)) * 60 + c1.get(Calendar.MINUTE - c.get(Calendar.MINUTE)));

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            list.add(i);
//        }
//        for (int i = 0; i < list.size(); ++i) {
//            if (list.get(i) >=5 &&list.get(i)<=10) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
//        System.out.println(Arrays.toString(list.toArray()));
    }

}

package com.mrliuxia.jianzhioffer._42_翻转单词顺序VS左旋转字符串;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class ReverseSentence {

    public static void main(String[] args) {
//        System.out.println(reverse2("ab cd ef"));
        String s = "ab cd ef 123 56";
        System.out.println(reverse(s));
        System.out.println(reverse1(s));
        System.out.println(reverse2(s));
//        int index = s.indexOf(" ");
//        System.out.println(index);
//        System.out.println(s.substring(index+1));
//        System.out.println(s.substring(0, index));
    }

    private static String reverse(String str) {
        StringBuffer sb = new StringBuffer();
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[strings.length - i - 1]).append(" ");
        }
        return sb.toString();
    }
    
    private static String reverse1(String str) {
        str = rev(str);
        String[] strs = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s: strs) {
            sb.append(rev(s)).append(" ");
        }
        return sb.toString();
    }

    private static String reverse2(String str) {
        if (!str.contains(" ")) {
            return str;
        }
        int index = str.indexOf(" ");
        return reverse2(str.substring(index+1))+" "+str.substring(0, index);
    }

    
    private static String rev(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2+1; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return new String(chars);
    }
}

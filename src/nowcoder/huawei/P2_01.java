package nowcoder.huawei;

import java.util.Scanner;

/**
 * 简单密码
 * 大写字母->小写、往后移一位, 小写字母->数字（手机键盘）, 数字不变
 * <p>
 * Created by pokerface_lx on 16/8/17.
 */
public class P2_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String password = scan.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (c >= 'A' && c <= 'Y') {
                    sb.append((char) (c + 33));
                    continue;
                }
                if (c == 'Z') {
                    sb.append('a');
                    continue;
                }
                if (c >= 'a' && c <= 'c') {
                    sb.append('2');
                    continue;
                }
                if (c >= 'd' && c <= 'f') {
                    sb.append('3');
                    continue;
                }
                if (c >= 'g' && c <= 'i') {
                    sb.append('4');
                    continue;
                }
                if (c >= 'j' && c <= 'l') {
                    sb.append('5');
                    continue;
                }
                if (c >= 'm' && c <= 'o') {
                    sb.append('6');
                    continue;
                }
                if (c >= 'p' && c <= 's') {
                    sb.append('7');
                    continue;
                }
                if (c >= 't' && c <= 'v') {
                    sb.append('8');
                    continue;
                }
                if (c >= 'w' && c <= 'z') {
                    sb.append('9');
                    continue;
                }
                sb.append(password.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }

}

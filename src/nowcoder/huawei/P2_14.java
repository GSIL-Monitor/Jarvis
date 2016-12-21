package nowcoder.huawei;

import com.sun.xml.internal.stream.Entity;

import java.util.*;

/**
 * 按照ASCII码将字符排序
 *
 * Created by pokerface_lx on 16/8/25.
 */
public class P2_14 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            Collections.sort(list, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return ((int)o1)-((int)o2);
                }
            });
            for (Character c: list) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}

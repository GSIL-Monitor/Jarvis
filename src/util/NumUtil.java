package util;

import javax.xml.parsers.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

/**
 * Created by Poker on 2016/12/21.
 */
public class NumUtil {

    public static double sumOfList(List<Double> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> list=  new ArrayList<>();
        boolean flag = true;
        while (flag) {
            try {
                double num = scan.nextDouble();
                list.add(num);
            }catch (InputMismatchException e) {
                flag = false;
            }
        }
        System.out.println(sumOfList(list));
    }

}

package zzz_test;

import com.sun.tools.javap.SourceWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zzz_test.Poker on 2016/12/2.,
 */
public class Hello {


    public static void main(String[] args) {
        String s = null;
        switch (s) {
            case "a":
                System.out.println(s);
                break;
            default:
                System.out.println("null");
                break;
        }
    }

    private static List<String> getContent(Map<String, List<String>> map) {
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            for (String s : entry.getValue()) {
                list.add(s);
            }
        }
        return list;
    }

}

package zzz_test;

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
 * Created by zzz_test.Poker on 2016/12/2.
 */
public class Hello extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene =  new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Button button = new Button();
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

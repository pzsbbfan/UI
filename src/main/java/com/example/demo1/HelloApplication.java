package com.example.demo1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    List names = new ArrayList<String>();
    ObservableList<String> list = FXCollections.observableList(names);
    @Override
    public void start(Stage stage) {
        list.addAll("Time","Jane","Mark");


        GridPane root = new GridPane();
        root.setStyle("-fx-font-size: 14pt");
        Label label1 = new Label(" Amount: ");
        Label label2 = new Label(" Result :");
        TextField textField2 = new TextField();

        TextField textField1 = new TextField();

        CheckBox cb = new CheckBox("Add Tip (5%)");
        CheckBox taxcb = new CheckBox("Add Tax (8%)");

        Button btn1 = new Button(" Submit ");

        ListView<String> listView = new ListView();
        listView.setItems(list);

        cb.setOnAction(event -> {
            System.out.println("is selected: " + cb.isSelected());
        });

        btn1.setOnAction(e ->{
            Double cost = Double.parseDouble(textField1.getText());
            if (cb.isSelected()) {
                cost *= 1.05;
            }
            if (taxcb.isSelected()){
                cost *=1.08;
            }
            textField2.setText("Total is: " + cost);
        });

        root.add(label1,0,0);
        root.add(textField1,1,0);
        root.add(btn1,0,2);
        root.add(label2,0,1);
        root.add(textField2,1,1);
        root.add(cb,2,0);
        root.add(taxcb,2,1);
        root.add(listView,0,3,3,1);



        root.setOnMouseMoved(mouseEvent -> {
            double y = mouseEvent.getScreenY();
            double x = mouseEvent.getScreenX();
            textField2.setText("x :" + x +"," + " y: "+y);
        });
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
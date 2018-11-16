package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ResultBox {

    public static void display(boolean w, boolean l, boolean c, ObservableList<Data> list) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Results");
        window.setMinWidth(250);
        VBox layout = new VBox();

        TableView<Data> table;

        TableColumn<Data, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<Data, String> wordColum = new TableColumn<>("Word Count");
        wordColum.setMinWidth(200);
        wordColum.setCellValueFactory(new PropertyValueFactory<>("wcount"));

        TableColumn<Data, String> lineColumn = new TableColumn<>("Line Count");
        lineColumn.setMinWidth(200);
        lineColumn.setCellValueFactory(new PropertyValueFactory<>("lcount"));

        TableColumn<Data, String> charColum = new TableColumn<>("Char Count");
        charColum.setMinWidth(200);
        charColum.setCellValueFactory(new PropertyValueFactory<>("ccount"));

        TableColumn<Data, String> sorceColumn = new TableColumn<>("Source Count");
        sorceColumn.setMinWidth(200);
        sorceColumn.setCellValueFactory(new PropertyValueFactory<>("slcount"));

        TableColumn<Data, String> commentColumn = new TableColumn<>("Comment Count");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cccount"));

        table = new TableView<>();
        table.setItems(list);
        if(!l && !w && !c)
            table.getColumns().addAll(nameColum, lineColumn,wordColum,charColum, commentColumn, sorceColumn);
        else {
            table.getColumns().add(nameColum);
            if(w)
                table.getColumns().add(wordColum);
            if(l)
                table.getColumns().add(lineColumn);
            if (c)
                table.getColumns().add(charColum);
        }
        layout.getChildren().addAll(table);


        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
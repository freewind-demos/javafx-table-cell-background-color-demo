package demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static javafx.collections.FXCollections.observableArrayList;

public class Hello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        TableView<Person> root = createTable();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private final ObservableList<Person> data = observableArrayList(
            new Person("AAA", Color.RED),
            new Person("BBB", Color.BLUE),
            new Person("CCC", Color.YELLOW)
    );

    private TableView<Person> createTable() {
        return new TableView<Person>() {{
            getColumns().add(new TableColumn<Person, String>("Name") {{
                setCellValueFactory(new PropertyValueFactory<>("name"));
            }});
            getColumns().add(new TableColumn<Person, Color>("Color") {{
                setCellValueFactory(new PropertyValueFactory<>("color"));
                setCellFactory(param -> new TableCell<Person, Color>() {
                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        if (!empty) {
                            this.setBackground(new Background(new BackgroundFill(item, CornerRadii.EMPTY, Insets.EMPTY)));
                            setText(item.toString());
                        }
                    }
                });
            }});
            setItems(data);
        }};
    }
}

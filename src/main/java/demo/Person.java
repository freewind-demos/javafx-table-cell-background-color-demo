package demo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;

public class Person {
    private final SimpleStringProperty name;
    private final SimpleObjectProperty<Color> color;

    Person(String name, Color color) {
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleObjectProperty<>(color);
    }

    public String getName() {
        return this.name.get();
    }

    public Color getColor() {
        return color.get();
    }

}

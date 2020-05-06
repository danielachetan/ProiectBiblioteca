package biblioteca.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {

    public void startScene(final Stage stage) {
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        VBox box = new VBox();
        Text text = new Text("Biblioteca\n");
        text.setFont(new Font(60));
        box.getChildren().add(text);
        Button button = new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuScene(stage);
            }
        });
        box.getChildren().add(button);
        box.setAlignment(Pos.CENTER);
        root.getChildren().add(box);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,900,600);
        stage.setScene(scene);
        stage.show();
    }

    public void menuScene(Stage stage) {
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        VBox box = new VBox();
        Text text1 = new Text("Evidenta cartilor din biblioteca:\n");
        text1.setFont(new Font(45));
        box.getChildren().add(text1);
        Button button1 = new Button();
        Label label1 = new Label("Adaugarea unei noi carti\n",button1);
        label1.setFont(new Font(35));
        box.getChildren().add(label1);
        Button button2 = new Button();
        Label label2 = new Label("Cautarea cartilor scrise de un anumit autor\n",button2);
        label2.setFont(new Font(35));
        box.getChildren().add(label2);
        Button button3 = new Button();
        Label label3 = new Label("Afisarea cartilor din biblioteca care au aparut intr-un\n anumit an, ordonate alfabetic dupa titlu si autori\n",button3);
        label3.setFont(new Font(35));
        box.getChildren().add(label3);
        Button button4 = new Button();
        Label label4 = new Label("Afisarea tuturor cartilor",button4);
        label4.setFont(new Font(35));
        box.getChildren().add(label4);
        root.getChildren().add(box);
        Scene scene = new Scene(root,900,600);
        stage.setScene(scene);
        stage.show();
    }

    public void toateCartile(Stage stage) {
        GridPane root = new GridPane();

    }
}

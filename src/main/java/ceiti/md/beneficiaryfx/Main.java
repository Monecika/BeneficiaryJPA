package ceiti.md.beneficiaryfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        String css = getClass().getResource(
                "/ceiti/md/beneficiaryfx/css/light.css"
        ).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Hello!");
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }
}


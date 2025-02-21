package ceiti.md.beneficiaryfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main extends Application {

    private ApplicationContext springContext;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        // Bootstraps the Spring context using our configuration
        springContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Use our custom loader to get FXML with Spring-managed controllers
        SpringFXMLLoader loader = new SpringFXMLLoader(springContext);
        Parent root = loader.load("/ceiti/md/beneficiaryfx/hello-view.fxml");
        Scene scene = new Scene(root, 800, 600);

        // Load the default (light) theme
        String css = getClass().getResource("/ceiti/md/beneficiaryfx/css/light.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Beneficiary Application");
        stage.setScene(scene);
        stage.show();
    }
}

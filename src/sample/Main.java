package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main
        extends Application
{
    public void start(Stage primaryStage)
            throws Exception
    {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("enter.fxml"));
        primaryStage.setTitle("‚ход");
        primaryStage.setScene(new Scene(root, 650.0D, 400.0D));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

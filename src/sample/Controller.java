package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller
{
    UserDB userDB = new UserDB();
    User user;
    ArrayList<User> list;
    SocketClient socketClient = new SocketClient();
    @FXML
    private Button signUpButton;
    @FXML
    private Button authClientButton;
    @FXML
    private Button authAdminButton;
    @FXML
    private Button signInAdminButton;
    @FXML
    private TextField logAdminField;
    @FXML
    private PasswordField passAdminField;
    @FXML
    private Button signInUserButton;
    @FXML
    private TextField logUserField;
    @FXML
    private PasswordField passUserField;
    @FXML
    private TextField regFioField;
    @FXML
    private TextField regLoginField;
    @FXML
    private PasswordField regPassField1;
    @FXML
    private PasswordField regPassField2;
    @FXML
    private Button signButton;
    @FXML
    private Label RegLabel;
    @FXML
    private Label bad_autorisation;

    public Controller()
    {
        Thread thread = new Thread(this.socketClient);
        thread.start();
    }

    public void SignUp(ActionEvent actionEvent)
            throws IOException
    {
        Parent root  = FXMLLoader.load(getClass().getResource("/sample/registration.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        cancel(actionEvent);
        primaryStage.show();
    }

    public void AuthAdmin(ActionEvent actionEvent)
            throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/authAdmin.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        cancel(actionEvent);
        primaryStage.show();
    }

    public void AuthUser(ActionEvent actionEvent)
            throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/authUser.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        cancel(actionEvent);
        primaryStage.show();
    }

    public void MenuAdmin(ActionEvent ev)
            throws IOException
    {
        Admin admin = new Admin(this.logAdminField.getText(), this.passAdminField.getText());

        Message message = new Message("Авторизация", admin);

        socketClient.getObjectOutputStream().writeObject(message);
        try {
            message=(Message)socketClient.getObjectInputStream().readObject();
            if (message.getMessage().equals("Success")) {
                Parent root  = FXMLLoader.load(getClass().getResource("/sample/menuAdmin.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Меню");
                primaryStage.setScene(new Scene(root));
                primaryStage.setResizable(false);
                cancel(ev);
                primaryStage.show();
            }
            else
            {
                this.bad_autorisation.setText("");
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void MenuUser(ActionEvent ev)
            throws IOException
    {
        this.list = this.userDB.getAll();
        boolean bool = false;
        for (int i = 0; i < this.list.size(); i++)
        {
            this.user = (this.list.get(i));
            if ((this.logUserField.getText().equals(this.user.getLogin())) && (this.passUserField.getText().equals(this.user.getPassword())))
            {
                Parent root = FXMLLoader.load(getClass().getResource("/sample/menuUser.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("User Menu");
                primaryStage.setScene(new Scene(root));
                primaryStage.setResizable(false);
                cancel(ev);
                primaryStage.show();
                bool = true;
                break;
            }
        }
        if (!bool) {
            this.bad_autorisation.setText("");
        }
    }

    public void Registration(ActionEvent ev)
            throws IOException
    {
        boolean bool = false;
        this.list = this.userDB.getAll();
        for (int i = 0; i < this.list.size(); i++)
        {
            this.user = (this.list.get(i));
            if (this.regLoginField.getText().equals(this.user.getLogin()))
            {
                bool = true;
                break;
            }
        }
        if (bool == true)
        {
            this.RegLabel.setText("Данный пользователь уже существует!");
        }
        else if (!this.regPassField1.getText().equals(this.regPassField2.getText()))
        {
            this.RegLabel.setText("Пароли не совпадают!");
        }
        else
        {
            User users = new User(this.user.getId() + 1, this.regFioField.getText(), this.regLoginField.getText(), this.regPassField1.getText());
            this.userDB.add(users);
        }
    }

    public void addComputer(ActionEvent ev)
            throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/addComp.fxml"));
        AnchorPane page = (AnchorPane)loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Добавить");
        primaryStage.setResizable(false);

        Scene scene = new Scene(page);
        primaryStage.setScene(scene);

        ComputerController comp = loader.getController();
        comp.show();

        primaryStage.show();
    }

    public void printComputer(ActionEvent ev)
            throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/print.fxml"));
        GridPane page = (GridPane)loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Вывод");
        primaryStage.setResizable(false);

        Scene scene = new Scene(page);
        primaryStage.setScene(scene);

        PrintCompController controllerr = (PrintCompController)loader.getController();
        controllerr.printComp();

        primaryStage.show();
    }

    @FXML
    public void UpDate(ActionEvent ev)
            throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/updateComp.fxml"));
        GridPane page = (GridPane)loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("?????????");
        primaryStage.setResizable(false);

        Scene scene = new Scene(page);
        primaryStage.setScene(scene);

        UpDateController controllerr = (UpDateController)loader.getController();
        controllerr.printComp();
        primaryStage.show();
    }

    @FXML
    public void begin(ActionEvent ev)
            throws IOException
    {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("/sample/enter.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("????");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        cancel(ev);
        primaryStage.show();
    }

    @FXML
    void cancel(ActionEvent event)
    {
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.hide();
        stage.close();
    }
}


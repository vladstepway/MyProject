package sample;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PrintCompController
{
    private ObservableList<Computer> computers = FXCollections.observableArrayList();
    @FXML
    private TableView<Computer> table;
    @FXML
    private TableColumn<Computer, Integer> NUM;
    @FXML
    private TableColumn<Computer, String> TYPE;
    @FXML
    private TableColumn<Computer, String> PROC_NAME;
    @FXML
    private TableColumn<Computer, Double> FREQ;
    @FXML
    private TableColumn<Computer, Integer> PROC_MEM;
    @FXML
    private TableColumn<Computer, Integer> VIDEO_MEM;
    @FXML
    private TableColumn<Computer, String> DVD;
    @FXML
    private TableColumn<Computer, Integer> CORES;
    @FXML
    private TableColumn<Computer, String> TYPE_DISPLAY;
    @FXML
    private TableColumn<Computer, String> RESOLUTION;
    @FXML
    private TableColumn<Computer, Integer> PRICE;
    CompDB dbC = new CompDB();
    ArrayList<Computer> listComp;

    public void printComp()
    {
        this.NUM.setCellValueFactory(new PropertyValueFactory("id_comp"));
        this.TYPE.setCellValueFactory(new PropertyValueFactory("type_comp"));
        this.PROC_NAME.setCellValueFactory(new PropertyValueFactory("proc_name"));
        this.FREQ.setCellValueFactory(new PropertyValueFactory("proc_freq"));
        this.PROC_MEM.setCellValueFactory(new PropertyValueFactory("proc_memory"));
        this.VIDEO_MEM.setCellValueFactory(new PropertyValueFactory("video_memory"));
        this.DVD.setCellValueFactory(new PropertyValueFactory("dvd_privod"));
        this.CORES.setCellValueFactory(new PropertyValueFactory("cores"));
        this.TYPE_DISPLAY.setCellValueFactory(new PropertyValueFactory("type_display"));
        this.RESOLUTION.setCellValueFactory(new PropertyValueFactory("resolution"));
        this.PRICE.setCellValueFactory(new PropertyValueFactory("price"));

        initData();
        this.table.setItems(this.computers);
    }

    public void initData()
    {
        this.listComp = this.dbC.getAll();
        for (Computer computer : this.listComp) {
            this.computers.add(computer);
        }
    }

    public void MainAdmin(ActionEvent ev)
            throws IOException
    {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("/sample/mainAdmin.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("???? ??????????????");
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

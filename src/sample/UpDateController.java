//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UpDateController {
    private ObservableList<Computer> computerObservableList = FXCollections.observableArrayList();
    @FXML
    private TableView<Computer> tableComp;
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
    CompDB compDB = new CompDB();
    ArrayList<Computer> computerArrayList;
    int index;

    public UpDateController() {
    }

    public void printComp() {
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
        this.init();
        this.tableComp.setItems(this.computerObservableList);
        this.tableComp.setEditable(true);
        this.tableComp.setOnMouseClicked((event) -> {
            this.index = this.tableComp.getSelectionModel().getSelectedIndex();
        });
    }

    private void init() {
        this.computerArrayList = this.compDB.getAll();

        for(int i = 0; i < this.computerArrayList.size(); ++i) {
            Computer computer = this.computerArrayList.get(i);
            this.computerObservableList.add(computer);
        }

    }

    @FXML
    public void DeleteComp(ActionEvent event) throws IOException {
        this.tableComp.setOnMouseClicked((event1) -> {
            this.index = this.tableComp.getSelectionModel().getSelectedIndex();
        });
        ObservableList<Computer> allComps = this.tableComp.getItems();
        ObservableList<Computer> selectedComp = this.tableComp.getSelectionModel().getSelectedItems();
        selectedComp.forEach(allComps::remove);
        ArrayList<Computer> computerArrayList = this.compDB.getAll();
        Computer computer = computerArrayList.get(this.index);
        this.compDB.delete(computer.getId_comp());
    }
}

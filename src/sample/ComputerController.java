package sample;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ComputerController
{
    ObservableList<String> typelist = FXCollections.observableArrayList(new String[] { "Computer", "Notebook" });
    ObservableList<String> matrixlist = FXCollections.observableArrayList(new String[] { "TN+Film", "VA", "IPS", "PLS", "AH-IPS" });
    ObservableList<String> resolutlist = FXCollections.observableArrayList(new String[] { "1366x768", "1600x900", "1920x1080", "2560x1080", "2560x1440", "3440x1440" });
    ObservableList<Integer> corelist = FXCollections.observableArrayList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(12) });
    CompDB dbC = new CompDB();
    @FXML
    private TextField price;
    @FXML
    private TextField proc_name;
    @FXML
    private TextField proc_freq;
    @FXML
    private CheckBox yes;
    @FXML
    private CheckBox no;
    @FXML
    private RadioButton one;
    @FXML
    private RadioButton two;
    @FXML
    private RadioButton three;
    @FXML
    private RadioButton four;
    @FXML
    private RadioButton five;
    @FXML
    private RadioButton onep;
    @FXML
    private RadioButton twop;
    @FXML
    private RadioButton threep;
    @FXML
    private RadioButton fourp;
    @FXML
    private RadioButton fivep;
    @FXML
    private RadioButton sixp;
    @FXML
    private Label dvd;
    @FXML
    private Label video_mem;
    @FXML
    private Label proc_mem;
    @FXML
    private Button authAdminCancelButton;
    @FXML
    private ChoiceBox type_comp;
    @FXML
    private ChoiceBox type_display;
    @FXML
    private ChoiceBox resolution;
    @FXML
    private ChoiceBox cores;
    String dvd_privod;

    public void show()
    {
        this.type_comp.setItems(this.typelist);

        this.type_display.setItems(this.matrixlist);
        this.resolution.setItems(this.resolutlist);
        this.cores.setItems(this.corelist);
    }

    @FXML
    private void YesBox()
    {
        if (this.yes.isSelected())
        {
            this.no.setSelected(false);
            this.dvd_privod = "Yes";
        }
    }

    @FXML
    private void NoBox()
    {
        if (this.no.isSelected())
        {
            this.yes.setSelected(false);
            this.dvd_privod = "No";
        }
    }

    int getVideo()
    {
        if (this.one.isSelected()) {
            return 1;
        }
        if (this.two.isSelected()) {
            return 2;
        }
        if (this.three.isSelected()) {
            return 4;
        }
        if (this.four.isSelected()) {
            return 8;
        }
        return 16;
    }

    int getProc()
    {
        if (this.onep.isSelected()) {
            return 1;
        }
        if (this.twop.isSelected()) {
            return 2;
        }
        if (this.threep.isSelected()) {
            return 4;
        }
        if (this.fourp.isSelected()) {
            return 6;
        }
        if (this.fivep.isSelected()) {
            return 8;
        }
        return 16;
    }

    public void addComputer()
    {
        int price_comp = Integer.parseInt(this.price.getText());
        int vid_mem = getVideo();
        int proces_mem = getProc();
        double freq = Double.parseDouble(this.proc_freq.getText());

        Computer comp = new Computer(this.type_comp.getValue().toString(), this.proc_name.getText(), freq, proces_mem, vid_mem, this.dvd_privod, ((Integer)this.cores.getValue()).intValue(), this.type_display.getValue().toString(), this.resolution.getValue().toString(), price_comp);
        this.dbC.add(comp);
    }

    public void AddComp(ActionEvent actionEvent)
            throws IOException
    {
        addComputer();
    }
}

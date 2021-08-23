package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.SafeBox;

public class SafeBoxGUI {


    @FXML
    private TextField txtZone3;

    @FXML
    private Label labTtitle;

    @FXML
    private Button btnJoin;

    @FXML
    private TextField txtZone2;

    @FXML
    private TextField txtZone4;

    @FXML
    private TextField txtZone1;

    private Stage mainStage;

    public static int password = 4321; 

    public Stage getMainStage() {
        return mainStage;
    }

    public static int getPassword() {
        return password;
    }

    public static void setPassword(int password) {
        SafeBoxGUI.password = password;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    void openSafeBox(ActionEvent event) throws IOException {

        String value = "";

        value += txtZone1.getText();
        value += txtZone2.getText();
        value += txtZone3.getText();
        value += txtZone4.getText();

        int valueInt = Integer.parseInt(value);

        if(SafeBox.openBox(SafeBoxGUI.getPassword(), valueInt) == true) {

            labTtitle.setText(value);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBoxW2.fxml"));
            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            mainStage.setScene(scene);
            mainStage.setTitle("Windows 2");
            mainStage.show();


            //FXMLLoader windows2 = new FXMLLoader(getClass().getResource("SafeBoxW2.fxml"));
            //windows2.setController(this);
            //Parent root = windows2.load();

            //Scene sc = new Scene(root);
            //mainStage.setScene(sc);
            //mainStage.setTitle("Windows 2");
            //mainStage.show();


        } else {

            JOptionPane.showMessageDialog(null, "The password is Incorrect");

        }


    }

}



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
import javafx.scene.control.TextArea;
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
    
    @FXML
    private Button bttnChangePass;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button bttnClose;
    
    @FXML
    private TextField txtCPass3;

    @FXML
    private Button bttnNewChange;

    @FXML
    private TextField txtCPass2;

    @FXML
    private TextField txtCPass4;

    @FXML
    private TextField txtCPass1;

    @FXML
    private TextField txtNPass1;

    @FXML
    private TextField txtNPass2;

    @FXML
    private TextField txtNPass3;

    @FXML
    private TextField txtNPass4;

    @FXML
    private Button bttnReturnMenu;

    private Stage mainStage;
    
    private SafeBox box;

    public Stage getMainStage() {
        return mainStage;
    }
    
    public SafeBoxGUI() {
    	box = new SafeBox();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    void openSafeBox(ActionEvent event) throws IOException {

        String value = "";
        int valueInt = 0;

        value += txtZone1.getText();
        value += txtZone2.getText();
        value += txtZone3.getText();
        value += txtZone4.getText();
        
        try {
        	
        	if(!value.equals("")) {
            	valueInt = Integer.parseInt(value);
            }
        	
        	if(valueInt == 0) {

            	JOptionPane.showMessageDialog(null, "The fields are EMPTY");
            	
            } else if(box.evaluatePassword(valueInt) == true) {


                labTtitle.setText(value);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBoxW2.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);

                mainStage.setScene(scene);
                mainStage.setTitle("Windows 2");
                mainStage.show();

            } else{

                JOptionPane.showMessageDialog(null, "The password is Incorrect");

            }
        	
        } catch(NumberFormatException ex) {
        	
        	JOptionPane.showMessageDialog(null, "Please, join numbers");
        	
        }
        


    }
    
    @FXML
    void closeSafeBox(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBoxW1.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.setTitle("Windows 1");
        mainStage.show();
        
    }
    
    @FXML
    void changePassword(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBoxW3.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.setTitle("Windows 3");
        mainStage.show();
        
    }
    
    @FXML
    void changeNewPass(ActionEvent event) {
    	
    	String oldPass = "";
    	String newPass = "";
    	int oldPassNumber = 0, newPassNumber = 0;
    	
    	oldPass += txtCPass1.getText();
    	oldPass += txtCPass2.getText();
    	oldPass += txtCPass3.getText();
    	oldPass += txtCPass4.getText();
    	
    	newPass += txtNPass1.getText();
    	newPass += txtNPass2.getText();
    	newPass += txtNPass3.getText();
    	newPass += txtNPass4.getText();
    	
    	try {
    		
    		if(!oldPass.equals("")) {
            	oldPassNumber = Integer.parseInt(oldPass);
            }
    		
    		if(!newPass.equals("")) {
            	newPassNumber = Integer.parseInt(newPass);
            }
    		
    		if(box.evaluatePassword(oldPassNumber) == true) {
    			
    			if(newPassNumber == 0) {
    				
    				JOptionPane.showMessageDialog(null, "The new Password zone is Empty");
    				
    			} else {
    				
    				box.setPassword(newPassNumber);
    				JOptionPane.showMessageDialog(null, "The password has been changed");
    			}
    			
    		} else {
    			
    			JOptionPane.showMessageDialog(null, "The current password is incorrect");
    			
    		}
    		
    	} catch(NumberFormatException ex) {
    		JOptionPane.showMessageDialog(null, "Please enter numbers in the boxes");
    	}
    	
    	
    	
    }

    @FXML
    void returnToMenu(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBoxW1.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        mainStage.setScene(scene);
        mainStage.setTitle("Windows 1");
        mainStage.show();
        
    }

}



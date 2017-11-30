package com.apu.auctiondesktop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button increasePriceButton;
    @FXML
    private Button connectButton;
    @FXML
    private TextField TextFieldState;
    @FXML
    private TextField TextFieldLotName;
    @FXML
    private TextField TextFieldStartPrice;
    @FXML
    private TextField TextFieldCurrentRate;
    @FXML
    private TextField TextFieldCurrentWinner;
    @FXML
    private Label LabelResult;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

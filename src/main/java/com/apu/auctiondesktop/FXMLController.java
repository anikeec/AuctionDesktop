package com.apu.auctiondesktop;

import static com.apu.auctiondesktop.MainApp.client;
import com.apu.auctiondesktop.nw.client.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class FXMLController implements Initializable {
    
    private Label label;
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
    private Button newRateButton;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleNewRateButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleConnectButtonAction(ActionEvent event) {  
    }

    @FXML
    private void handleNewRateButtonKeyReleased(KeyEvent event) {
    }

    @FXML
    private void handleConnectButtonKeyReleased(KeyEvent event) {
        
    }

    @FXML
    private void handleNewRateButtonMouseReleased(MouseEvent event) {
    }

    @FXML
    private void handleConnectButtonMouseReleased(MouseEvent event) {
        Object button = event.getSource();
        if(button == connectButton) {
            if(connectButton.getText().equals("Connect")) {
                try {
                    Client.getInstance().start();
                    LabelResult.setText("Server connected.");
                    connectButton.setText("Disconnect");
                } catch (IOException ex) {
                    LabelResult.setText("Error server connect.");
                }                
            } else {
                try {
                    Client.getInstance().stop();
                    LabelResult.setText("Server disconnected.");
                } catch (IOException ex) {
                    LabelResult.setText("Error server disconnect.");
                }
                connectButton.setText("Connect");
            }
        }
    }
}

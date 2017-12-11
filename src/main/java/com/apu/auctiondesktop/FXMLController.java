package com.apu.auctiondesktop;

import com.apu.auctiondesktop.nw.client.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Label LabelResult;
    @FXML
    private Button connectButton;
    @FXML
    private Button newRateButton; 
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
    private TextField TextFieldObservers;
    @FXML
    private TextField TextFieldTimeLastUpdate;
    @FXML
    private TextField TextFieldUserId;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GUIModel model = GUIModel.getInstance();
        model.setStartPrice(-1);
        model.setLotName("");
        model.setCurrentRate(model.getStartPrice());        
        model.setCurrentWinner("-1");
        model.setAmountObservers(-1);
        
        model.startPriceProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                TextFieldStartPrice.setText("" + newValue);
            }
        });
        model.lotNameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                TextFieldLotName.setText(newValue);
            }
        });
        model.currentRateProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                TextFieldCurrentRate.setText("" + newValue);
            }
        });
        model.currentWinnerProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                TextFieldCurrentWinner.setText(newValue);
            }
        });
        model.amountObserversProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                TextFieldObservers.setText("" + newValue);
            }
        });
        model.lastTimeUpdateProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                TextFieldTimeLastUpdate.setText(newValue);
            }
        });
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
                String userIdStr = TextFieldUserId.getText();
                if(userIdStr == null) {
                    LabelResult.setText("Error user ID.");
                    return;
                }
                Integer userId = Integer.parseInt(userIdStr);
                try {
                    Client.getInstance().start(userId);
                    LabelResult.setText("Server connected.");
                    connectButton.setText("Disconnect");
                    TextFieldUserId.setDisable(true);
                } catch (IOException ex) {
                    LabelResult.setText("Error server connect.");
                    TextFieldUserId.setDisable(false);
                }                
            } else {
                try {
                    Client.getInstance().stop();
                    LabelResult.setText("Server disconnected.");
                    TextFieldUserId.setDisable(false);
                } catch (IOException ex) {
                    LabelResult.setText("Error server disconnect.");
                }
                connectButton.setText("Connect");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.auctiondesktop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author apu
 */
public class GUIModel {
    private SimpleStringProperty lastTimeUpdate;
    private SimpleStringProperty state;
    private SimpleStringProperty lotName;
    private SimpleIntegerProperty startPrice;
    private SimpleIntegerProperty currentRate;
    private SimpleStringProperty currentWinner;
    private SimpleIntegerProperty amountObservers;
    
    private static GUIModel instance;
    
    private GUIModel() {        
    }   
    
    public static GUIModel getInstance() {
        if(instance == null)
            instance = new GUIModel();
        return instance;
    }
    
    public SimpleStringProperty lastTimeUpdateProperty() {
        if(this.lastTimeUpdate == null) { 
            this.lastTimeUpdate = new SimpleStringProperty(); 
        }
        return this.lastTimeUpdate;
    }
    
    public final String getLastTimeUpdate() { 
        return this.lastTimeUpdateProperty().get(); 
    }

    public final void setLastTimeUpdate(String value) { 
        this.lastTimeUpdateProperty().set(value); 
    }
    
    public SimpleStringProperty stateProperty() {
        if(this.state == null) { 
            this.state = new SimpleStringProperty(); 
        }
        return this.state;
    }
    
    public final String getState() { 
        return this.stateProperty().get(); 
    }

    public final void setState(String value) { 
        this.stateProperty().set(value); 
    }
    
    public SimpleStringProperty lotNameProperty() {
        if(this.lotName == null) { 
            this.lotName = new SimpleStringProperty(); 
        }
        return this.lotName;
    }
    
    public final String getLotName() { 
        return this.lotNameProperty().get(); 
    }

    public final void setLotName(String value) { 
        this.lotNameProperty().set(value); 
    }
    
    public SimpleIntegerProperty startPriceProperty() {
        if(this.startPrice == null) { 
            this.startPrice = new SimpleIntegerProperty(); 
        }
        return this.startPrice;
    }
    
    public final Integer getStartPrice() { 
        return this.startPriceProperty().get(); 
    }

    public final void setStartPrice(Integer value) { 
        this.startPriceProperty().set(value); 
    }
    
    public SimpleIntegerProperty currentRateProperty() {
        if(this.currentRate == null) { 
            this.currentRate = new SimpleIntegerProperty(); 
        }
        return this.currentRate;
    }
    
    public final Integer getCurrentRate() { 
        return this.currentRateProperty().get(); 
    }

    public final void setCurrentRate(Integer value) { 
        this.currentRateProperty().set(value); 
    }
    
    public SimpleStringProperty currentWinnerProperty() {
        if(this.currentWinner == null) { 
            this.currentWinner = new SimpleStringProperty(); 
        }
        return this.currentWinner;
    }
    
    public final String getCurrentWinner() { 
        return this.currentWinnerProperty().get(); 
    }

    public final void setCurrentWinner(String value) { 
        this.currentWinnerProperty().set(value); 
    }
    
    public final Integer getAmountObservers() { 
        return this.amountObserversProperty().get(); 
    }

    public final void setAmountObservers(Integer value) { 
        this.amountObserversProperty().set(value); 
    }
    
    public SimpleIntegerProperty amountObserversProperty() {
        if(this.amountObservers == null) { 
            this.amountObservers = new SimpleIntegerProperty(); 
        }
        return this.amountObservers;
    }
    
}

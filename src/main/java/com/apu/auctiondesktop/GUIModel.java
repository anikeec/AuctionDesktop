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
    private SimpleIntegerProperty lotId;
    private SimpleStringProperty lotName;
    private SimpleIntegerProperty startPrice;
    private SimpleIntegerProperty currentRate;
    private SimpleStringProperty currentWinner;
    private SimpleIntegerProperty amountObservers;
    private SimpleStringProperty answerTime;
    private SimpleStringProperty timeToFinish;
    
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
    
    public synchronized final String getLastTimeUpdate() { 
        return this.lastTimeUpdateProperty().get(); 
    }

    public synchronized final void setLastTimeUpdate(String value) { 
        this.lastTimeUpdateProperty().set(value); 
    }
    
    public SimpleStringProperty stateProperty() {
        if(this.state == null) { 
            this.state = new SimpleStringProperty(); 
        }
        return this.state;
    }
    
    public synchronized final String getState() { 
        return this.stateProperty().get(); 
    }

    public synchronized final void setState(String value) { 
        this.stateProperty().set(value); 
    }
    
    public SimpleStringProperty lotNameProperty() {
        if(this.lotName == null) { 
            this.lotName = new SimpleStringProperty(); 
        }
        return this.lotName;
    }
    
    public SimpleIntegerProperty lotIdProperty() {
        if(this.lotId == null) { 
            this.lotId = new SimpleIntegerProperty(); 
        }
        return this.lotId;
    }
    
    public synchronized final Integer getLotId() { 
        return this.lotIdProperty().get(); 
    }

    public synchronized final void setLotId(Integer value) { 
        this.lotIdProperty().set(value); 
    }
    
    public synchronized final String getLotName() { 
        return this.lotNameProperty().get(); 
    }

    public synchronized final void setLotName(String value) { 
        this.lotNameProperty().set(value); 
    }
    
    public SimpleIntegerProperty startPriceProperty() {
        if(this.startPrice == null) { 
            this.startPrice = new SimpleIntegerProperty(); 
        }
        return this.startPrice;
    }
    
    public synchronized final Integer getStartPrice() { 
        return this.startPriceProperty().get(); 
    }

    public synchronized final void setStartPrice(Integer value) { 
        this.startPriceProperty().set(value); 
    }
    
    public SimpleIntegerProperty currentRateProperty() {
        if(this.currentRate == null) { 
            this.currentRate = new SimpleIntegerProperty(); 
        }
        return this.currentRate;
    }
    
    public synchronized final Integer getCurrentRate() { 
        return this.currentRateProperty().get(); 
    }

    public synchronized final void setCurrentRate(Integer value) { 
        this.currentRateProperty().set(value); 
    }
    
    public SimpleStringProperty currentWinnerProperty() {
        if(this.currentWinner == null) { 
            this.currentWinner = new SimpleStringProperty(); 
        }
        return this.currentWinner;
    }
    
    public synchronized final String getCurrentWinner() { 
        return this.currentWinnerProperty().get(); 
    }

    public synchronized final void setCurrentWinner(String value) { 
        this.currentWinnerProperty().set(value); 
    }
    
    public synchronized final Integer getAmountObservers() { 
        return this.amountObserversProperty().get(); 
    }

    public synchronized final void setAmountObservers(Integer value) { 
        this.amountObserversProperty().set(value); 
    }
    
    public SimpleIntegerProperty amountObserversProperty() {
        if(this.amountObservers == null) { 
            this.amountObservers = new SimpleIntegerProperty(); 
        }
        return this.amountObservers;
    }

    public SimpleStringProperty answerTimeProperty() {
        if(this.answerTime == null) { 
            this.answerTime = new SimpleStringProperty(); 
        }
        return this.answerTime;
    }

    public synchronized void setAnswerTime(String time) {
        this.answerTimeProperty().set(time);
    } 
    
    public SimpleStringProperty timeToFinishProperty() {
        if(this.timeToFinish == null) { 
            this.timeToFinish = new SimpleStringProperty(); 
        }
        return this.timeToFinish;
    }

    public synchronized void setTimeToFinish(String timeToFinish) {
        this.timeToFinishProperty().set(timeToFinish);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.auctiondesktop.nw.client;

import com.apu.auctiondesktop.nw.Network;
import com.apu.auctiondesktop.nw.entity.Message;
import com.apu.auctiondesktop.nw.entity.User;
import com.apu.auctiondesktop.utils.Log;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author apu
 */
public class Client {
    private static final Log log = Log.getInstance();
    private final Class classname = Client.class;
    private Socket clientSocket; 
    private static Network network;
    private static final int CONNECTION_PORT = 5050;
    private static final String CONNECTION_HOST = "localhost";
    private final int SOCKET_RECEIVE_TIMEOUT = 1000;
    final int MESSAGE_QUEUE_SIZE = 10;
    private BlockingQueue<Message> messagesQueue = new ArrayBlockingQueue<>(MESSAGE_QUEUE_SIZE);
    private Thread networkThread;
    
    private static ClientState clientState = ClientState.NOT_CONNECTED;
    
    private static Client instance;

    private Client() throws IOException {            
        
    }
    
    public static Client getInstance() throws IOException {
        if(instance == null)
            instance = new Client();
        return instance;
    }

    public static synchronized ClientState getClientState() {
        return clientState;
    }

    public static synchronized void setClientState(ClientState state) {
        clientState = state;
    }   

    public void start(int userId) throws IOException {
        clientSocket = new Socket(CONNECTION_HOST, CONNECTION_PORT);
        clientSocket.setSoTimeout(SOCKET_RECEIVE_TIMEOUT);
        log.debug(classname, "Client started");         
//        int usedId = 1;
        log.debug(classname, "Try to connect");
        handleSocket(userId);               
    }
    
    public void stop() throws IOException {
        messagesQueue.add(new Message("Error"));
        while(networkThread.isAlive()){};
        log.debug(classname, "Client finished");
    }
    
    public void newRateQuery(int lotId, int newRate) {
        network.addNewRate(lotId, newRate);
    }
    
    private void handleSocket(int userId) {
        User user = new User(userId, clientSocket);
        network = new Network(user, clientSocket, messagesQueue, false);
        networkThread = new Thread(network);
        networkThread.start();
    }

}

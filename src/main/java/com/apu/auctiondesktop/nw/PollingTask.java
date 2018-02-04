/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.auctiondesktop.nw;

import com.apu.auctionapi.AuctionQuery;
import com.apu.auctionapi.query.PollQuery;
import com.apu.auctiondesktop.nw.entity.Message;
import com.apu.auctiondesktop.nw.entity.User;
import com.apu.auctiondesktop.utils.Log;
import java.util.concurrent.BlockingQueue;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author apu
 */
public class PollingTask implements Runnable {
    
    private static final Log log = Log.getInstance();
    private final Class classname = PollingTask.class;
    
    private final long POLLING_TIMEOUT_MS = 5000;
    private final User user;
    private BlockingQueue<AuctionQuery> queriesQueue;
    private final BlockingQueue<Message> messagesQueue;

    public PollingTask(User user, BlockingQueue<Message> messagesQueue) {
        this.user = user;
        this.messagesQueue = messagesQueue;
    }
    
    public void setQueriesQueue(BlockingQueue<AuctionQuery> queriesQueue) {
        this.queriesQueue = queriesQueue;
    }

    @Override
    public void run() { 
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(POLLING_TIMEOUT_MS);
            } catch (InterruptedException ex) {
                log.debug(classname,"Timeout interrupted.");
//                log.debug(classname,ExceptionUtils.getStackTrace(ex));
                break;
            }
            if(queriesQueue.remainingCapacity() > queriesQueue.size() - 1) { 
                queriesQueue.add(new PollQuery(user.getUserId()));
            } else {
                log.debug(classname, "PollingTask Thread. Queue is full.");
    //            messagesQueue.add(new Message("Error"));
            }
        } 
        log.debug(classname, "Polling thread. Interrupted.");
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.auctiondesktop.nw.utils;

import com.apu.auctionapi.AuctionLotEntity;
import com.apu.auctionapi.AuctionQuery;
import com.apu.auctionapi.query.NewRateQuery;
import com.apu.auctionapi.query.NotifyQuery;
import com.apu.auctionapi.query.PingQuery;
import com.apu.auctionapi.answer.PollAnswerQuery;
import com.apu.auctionapi.query.PollQuery;
import com.apu.auctionapi.QueryType;
import com.apu.auctionapi.answer.AnswerQuery;
import com.apu.auctionapi.query.RegistrationQuery;
import com.apu.auctiondesktop.AuctionLot;
import com.apu.auctiondesktop.utils.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author apu
 */
public class Decoder {
    
    private static final Log log = Log.getInstance();
    private final Class classname = Decoder.class;
    
    private String query;
    private final JsonParser parser = new JsonParser();
    private static Decoder instance;
    
    private JsonElement jsonElement;
    private JsonObject rootObject;
    
    private Decoder() {
    }
    
    public static Decoder getInstance() {
        if(instance == null)
            instance = new Decoder();
        return instance;
    }
    
    private void decode(AnswerQuery result) throws Exception {
        log.debug(classname, "AnswerQuery packet");
        String str = rootObject.get("message").getAsString();
        result.setMessage(str);
    }
    
    private void decode(RegistrationQuery result) throws Exception {
        log.debug(classname, "Registration packet");
    }
    
    private void decode(PingQuery result)  throws Exception {
        throw new Exception("Method has not ready yet");        
    }
    
    private void decode(NewRateQuery result)  throws Exception {
        throw new Exception("Method has not ready yet");        
    }
    
    private void decode(NotifyQuery result)  throws Exception {
        throw new Exception("Method has not ready yet");        
    }
    
    private void decode(PollQuery result)  throws Exception {
        throw new Exception("Method has not ready yet");        
    }
    
    private void decode(PollAnswerQuery result)  throws Exception {
        log.debug(classname, "PollAnswerQuery packet");
        JsonArray array = rootObject.get("auctionLots").getAsJsonArray();
        JsonObject obj;
        Integer lotId, startPrice, lastRate,lastRateUserId, amountObservers;
        long timeToFinish;
        String lotName;
        AuctionLotEntity lot;
        for(JsonElement element:array) {
            obj = element.getAsJsonObject();
            lotId = obj.get("lotId").getAsInt();
            startPrice = obj.get("startPrice").getAsInt();
            lotName = obj.get("lotName").getAsString();
            lastRate = obj.get("lastRate").getAsInt();
            lastRateUserId = obj.get("lastRateUserId").getAsInt();
            amountObservers = obj.get("amountObservers").getAsInt();
            timeToFinish = obj.get("timeToFinish").getAsLong();
            lot = new AuctionLotEntity(lotId,
                                        startPrice,
                                        lotName,
                                        lastRate,
                                        lastRateUserId,
                                        amountObservers,
                                        timeToFinish);
            result.addLotToCollection(lot);
        }
        log.debug(classname, "");
    }
    
    public AuctionQuery decode(String query) throws Exception {
        this.query = query;       
        
        jsonElement = parser.parse(query);
        rootObject = jsonElement.getAsJsonObject();

        String queryType = rootObject.get("queryType").getAsString();
        String time = rootObject.get("time").getAsString();
        Long packetId = rootObject.get("packetId").getAsLong();
        Integer userId = rootObject.get("userId").getAsInt();        
        
        AuctionQuery result = null;
        if(queryType.equals(QueryType.ANSWER.toString())) {
            result = new AnswerQuery(packetId, userId, time, "");
            Decoder.this.decode((AnswerQuery)result);
        } else if(queryType.equals(QueryType.NEW_RATE.toString())) {
            result = new NewRateQuery(packetId, userId, time);
            Decoder.this.decode((NewRateQuery)result);
        } else if(queryType.equals(QueryType.NOTIFY.toString())) {
            Decoder.this.decode((NotifyQuery)result);
        } else if(queryType.equals(QueryType.PING.toString())) {
            result = new PingQuery(packetId, userId, time);
            Decoder.this.decode((PingQuery)result);
        } else if(queryType.equals(QueryType.POLL_ANSWER.toString())) {
            result = new PollAnswerQuery(packetId, userId, time);
            Decoder.this.decode((PollAnswerQuery)result);
        } else if(queryType.equals(QueryType.POLL.toString())) {
            Decoder.this.decode((PollQuery)result);
        } else if(queryType.equals(QueryType.REGISTRATION.toString())) {
            result = new RegistrationQuery(packetId, userId, time);
            Decoder.this.decode((RegistrationQuery)result);
        }
        
        return result;
    }
}

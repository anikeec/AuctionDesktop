/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.auctiondesktop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 *
 * @author apu
 */
public class Time {
    
    private static final Log log = Log.getInstance();
    private static final Class classname = Time.class;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
    
    public static String getTime() {        
        return dateFormat.format(new Date());
    }
    
    public static String timeToDateString(long time) {
        return dateFormat.format(new Date(time));
    }
	
	public static String timeToFinishToString(long diff) {		
		long ms = diff % 1000l;
		diff = diff / 1000l;

		long sec = diff % 60l;
		diff = diff / 60l;

		long min = diff % 60l;
		diff = diff / 60l;

		long hours = diff % 24l;
		diff = diff / 24l;

		long days = diff;

		String out = String.format("%d days, %2d:%2d:%2d", days, hours, min, sec);
        return out;
    }
    
    public static Date timeToDate(String time) {
        try {
            return dateFormat.parse(time);
        } catch (ParseException ex) {
            log.debug(classname,ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }
    
    public static String getDelay(String timeAsk, String timeAnswer) {
        try {
            long timeAskLong = dateFormat.parse(timeAsk).getTime();
            long timeAnswerLong = dateFormat.parse(timeAnswer).getTime();
            long delay = timeAnswerLong - timeAskLong;
            return delay + " ms";
        } catch (ParseException ex) {
            log.debug(classname,ExceptionUtils.getStackTrace(ex));
        }
        return "Count error";
    }
    
}

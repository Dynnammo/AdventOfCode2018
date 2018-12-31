/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author dynnammo
 */
public class Guard {
    int guardId;
    long asleepTime;
    public ArrayList<Log> logs;

    public Guard(int guardId) {
        logs = new ArrayList<>();
        this.guardId = guardId;
        asleepTime = 0;
    }
    
    public void harvestLogs(LogManager logs){
        for (Log log : logs.logs) {
            if (log.guardId == guardId) {
                this.logs.add(log);
            }
        }
    }

    public int[] getMostAsleepMinute(){
        Calendar c = Calendar.getInstance();
        c.setTime(logs.get(0).d);
        boolean tempStatus = true;
        int gapBegin = c.get(Calendar.MINUTE);
        int gapEnd = c.get(Calendar.MINUTE);
        int[][] minutesCount = new int[60][2];
        int[] max = {0,0};
        for (int i = 0; i < 60; i++){
            minutesCount[i][0] = i;
            minutesCount[i][1] = 0;
        }
        for (Log log : logs) {
            if (!log.s && tempStatus) {
                c.setTime(log.d);
                gapBegin = c.get(Calendar.MINUTE);
                tempStatus = false;
            }
            else if (log.s && !tempStatus){
                c.setTime(log.d);
                gapEnd = c.get(Calendar.MINUTE);
                tempStatus = true;
                for (int i = gapBegin; i < gapEnd; i++)
                    minutesCount[i][1]++;
            }
        }
        for (int i = 0; i < 60; i++) {
            if (max[1] < minutesCount[i][1]){
                max[1] = minutesCount[i][1];
                max[0] = minutesCount[i][0];
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Guard{" + "guardId=" + guardId + "\n"+ 
                logs.toString() + "\n" +
                "AsleepTime=" + asleepTime /1000 +
                + '}';
    }

    public long getAsleepTime() {
        return asleepTime;
    }

    public ArrayList<Log> getLogs(LogManager lm) {
        for (Log log : lm.logs) {
            if (log.guardId == guardId)
                logs.add(log);
        }
        return logs;
    }    
}

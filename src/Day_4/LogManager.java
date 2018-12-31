/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_4;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import utils.DateManager;
import utils.FileReader;
import utils.MainClass;

/**
 *
 * @author dynnammo
 */
public class LogManager extends MainClass{
    ArrayList<Log> logs;
    
    public LogManager(String path) throws FileNotFoundException, ParseException {
        super(path);
        logs = new ArrayList();
        for (String logString : new FileReader(this.getPath()).fileStream()){
            int guardIdTemp = 0;
            Log log = new Log(logString);
            logs.add(log);
        }
        this.sortLogs();
        this.setGuardIdForLogs();
    }
    
    public void sortLogs(){
        Collections.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log arg0, Log arg1) {
                if (arg0.d.after(arg1.d)) {
                    return 1;
                }
                return -1;
            }
        });
    }

    private void setGuardIdForLogs() {
        int guardIdTemp = 0;
        for (Log log : logs) {
            if (log.guardId != 0) {
                guardIdTemp = log.guardId;
            } else {
                log.guardId = guardIdTemp;
            }
        }
    }
    
   public ArrayList<Integer> getGuardIds(){
       ArrayList<Integer> guardIds;
       guardIds = new ArrayList<>();
       for (Log log : logs) {
           if (!guardIds.contains(log.guardId))
                guardIds.add((Integer) log.guardId);
       }
       return guardIds;
   }
   
    public Collection<Guard> computeAsleepTime(){
        HashMap<Integer,Guard> guards = new HashMap<Integer, Guard>();
        boolean tempStatut = true;
        guards.put(logs.get(0).guardId, new Guard(logs.get(0).guardId));
        Date tempDate = logs.get(0).d;
        for (Log log : logs) {
            if (guards.containsKey(log.guardId)) {
                Guard g = guards.get(log.guardId);
                if (log.s == false) {
                    tempStatut = false;
                    tempDate = log.d;
                }
                else {
                    if(tempStatut == false){
                        g.asleepTime += (log.d.getTime() - tempDate.getTime());
                        tempStatut = true;
                    }
                }
            }
            else {
                guards.put(log.guardId, new Guard(log.guardId));
                tempStatut = log.s;
                tempDate = log.d;
            }
        }
        return guards.values();
    }
    
    public HashMap<Integer, ArrayList<Log>> guardsLogSet(){
       HashMap<Integer, ArrayList<Log>> hashGuardLogs = new HashMap<>();
       this.getGuardIds().forEach((guardId) -> {
           ArrayList<Log> guardLogs = new ArrayList<Log>();
           for (Log log : logs) {
               if (log.guardId == guardId)
                   guardLogs.add(log);
           }
           hashGuardLogs.put(guardId, guardLogs);
        });
        return hashGuardLogs;
    }
    
    
    @Override
    public String toString() {
        String s = "";
        for (Log log : logs) {
            s += log.toString();
        }
        return s;
    }
}

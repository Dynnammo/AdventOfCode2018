/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_4;

import java.io.FileNotFoundException;
import java.rmi.server.LogStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author dynnammo
 */
public class Day_4 {    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        LogManager logs = new LogManager(System.getProperty("user.dir")+ "/src/Day_4/GuardLog.txt");
        Collection<Guard> colGuards = logs.computeAsleepTime();
        for (Iterator<Guard> iterator = colGuards.iterator(); iterator.hasNext();) {
            Guard next = iterator.next();
            next.getLogs(logs);
            System.out.println(next.guardId);
            System.out.println(next.getMostAsleepMinute()[0]);
            System.out.println(next.getMostAsleepMinute()[1] + "\n");
        }
    }
}


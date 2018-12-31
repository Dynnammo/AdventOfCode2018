/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_4;

import java.text.ParseException;
import java.util.Date;
import utils.DateManager;

/**
 *
 * @author dynnammo
 */
public class Log {
    Date d;
    int guardId;
    boolean s;

    public Log(String logString) throws ParseException {
        guardId = 0;
        String[] splited = logString.split(" Guard | falls | wakes ");
        for (String string : splited) {
            d = new DateManager().parseString(splited[0]);
            s = splited[1].equals("asleep") ? false : true;
            if (splited[1].charAt(0) == '#')
                guardId = Integer.parseInt(splited[1].split(" ")[0].substring(1));
        }
    }

    @Override
    public String toString() {
        return ("Log{" + "d=" + d + ", GuardID=" + guardId + ", s=" + s + "}\n");
    }
}

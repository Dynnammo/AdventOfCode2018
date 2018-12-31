/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author dynnammo
 */
public class DateManager {
    SimpleDateFormat formatter;
    Date d;
    
    public DateManager() throws ParseException{
        formatter = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");
    }

    public Date parseString(String date) throws ParseException{
        return formatter.parse(date);
    }

    @Override
    public String toString() {
        return formatter.format(d);
    }
}

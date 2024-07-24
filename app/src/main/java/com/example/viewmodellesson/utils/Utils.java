package com.example.viewmodellesson.utils;
import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String format = "dd/MM/YYYY"; // ex: 30/09/2004
    @SuppressLint({"SimpleDateFormat", "WeekBasedYear"})
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(format);

    public static Date stringToDate(String dateStr){
        try{
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dateToString(Date date){
        return dateFormat.format(date);
    }
}

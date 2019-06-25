package com.codigo.venadostest.utilities;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormatDate {
    public String date;

    public static String getDayWeek(String date){

        java.util.Calendar cal = java.util.Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int diaSemana = cal.get(java.util.Calendar.DAY_OF_WEEK);
        switch (diaSemana){
            case 1:
                date="DOM";
                break;
            case 2:
                date="LUN";
                break;
            case 3:
                date="MAR";
                break;
            case 4:
                date="MIE";
                break;
            case 5:
                date="JUE";
                break;
            case 6:
                date="VIE";
                break;
            case 7:
                date="SAB";
                break;
        }
        return date;
    }

    public static String getDayMonth(String date){

        java.util.Calendar cal = java.util.Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }
}

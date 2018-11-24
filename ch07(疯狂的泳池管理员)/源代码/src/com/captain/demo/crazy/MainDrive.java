package com.captain.demo.crazy;

import java.util.Calendar;
import java.util.Timer;
/**
 * Created by captain on 2017/7/27.
 */
public class MainDrive {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                00,0,0
        );
        WaterTimeTask task = new WaterTimeTask();
        Timer timer = new Timer();
        timer.schedule(task,calendar.getTime(),1000*60*60*24);
    }
}

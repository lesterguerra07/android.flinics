package com.flinics.history.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {

    public static int getAge(Date birthDate) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(new Date()));
        int age = (d2 - d1) / 10000;
        return age;
    }


}

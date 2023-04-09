package com.dataMigration.database;

import java.sql.Date;
import java.time.LocalDate;

public class LocalDateConverterToDate {

    public static Date convertDate(LocalDate date) {

        return java.sql.Date.valueOf(date);
    }

}

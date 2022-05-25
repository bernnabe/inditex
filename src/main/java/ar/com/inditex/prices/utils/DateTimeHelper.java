package ar.com.inditex.prices.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static LocalDateTime parse(String datetime) throws Exception {

        DateTimeFormatter format;

        if (datetime.length() == 10) {
            format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(datetime, format).atTime(0, 0, 0);
        }

        if (datetime.length() >= 16) {
            format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(datetime, format);
        }

        throw new Exception("invalid date. provide yyyy-MMdd or yyyy-MM-dd hh:mm format");
    }
}

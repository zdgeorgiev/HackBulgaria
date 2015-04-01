package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factory {
    public static Time createTimeNow() {

        Time now = new Time(5, 5, 5, 5, 5, 5);
        String a = new SimpleDateFormat("hh:mm:ss dd.MM.YY").format(new Date());

        now.setHours(Integer.parseInt(a.substring(0, 2)));
        now.setMinutes(Integer.parseInt(a.substring(3, 5)));
        now.setSeconds(Integer.parseInt(a.substring(6, 8)));
        now.setDay(Integer.parseInt(a.substring(9, 11)));
        now.setMonth(Integer.parseInt(a.substring(12, 14)));
        now.setYear(Integer.parseInt(a.substring(15, 17)));

        return now;
    }
}

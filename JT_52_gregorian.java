import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class JT_52_gregorian {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.SECOND));
        System.out.println(c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
//        *****************************************************************************************
        GregorianCalendar p = new GregorianCalendar();
        System.out.println(p.isLeapYear(2020));
        System.out.println(TimeZone.getAvailableIDs()[0]);
        System.out.println((TimeZone.getAvailableIDs()[1]));

    }
}
/*
java.util.calender
java.util.gregoriancalender
java.util.date
java.util.timezone
these are old or deprecated classes
Latest version is available on java.time package
 */
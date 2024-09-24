import java.util.Calendar;
import java.util.TimeZone;

public class JT_51_calenderclass {
    public static void main(String k[]) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getCalendarType());
        System.out.println(c.getTimeZone()); // returns time zone
        System.out.println(c.getTimeZone().getID()); // returns timezone id

        Calendar p = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        System.out.println(p.getTimeZone());
    }
    }

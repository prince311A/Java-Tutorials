import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JT_53_javatime {
    public static void main(String[] args) {
        LocalDate p = LocalDate.now();
        System.out.println(p);

        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
//        *****************************************************************************
        // Format date and time
        LocalDateTime s = LocalDateTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd/mm/yyyy--E h:m a"); // available in java.time pacakge
        String text = s.format(tf);
        System.out.println(text);

        DateTimeFormatter wf = DateTimeFormatter.ISO_DATE;
        String ts = s.format(wf);
        System.out.println(ts);
//        *************************************************************************QUIZ
        LocalTime lt = LocalTime.now();
        System.out.println(lt.getHour()+":"+ dt.getMinute()+":"+dt.getSecond());
        // another way
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:m:s");
        String y = lt.format(dtf);
        System.out.println(y);
    }
}

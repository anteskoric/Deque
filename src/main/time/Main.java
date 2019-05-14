package time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ante Skoric, Timo Quednau
 * The class Main exicutes the code of the class Time.
 */

public class Main {
    public static void main(String[] args) {
        LocalDate dateWithOutTimeZone = LocalDate.now();
        System.out.println("Date with out time-zone " + dateWithOutTimeZone);
        ZoneId zoneGermany = ZoneId.of("Europe/Berlin");
        LocalDate dateWithTimeZone = LocalDate.now(zoneGermany);
        System.out.println("Date with time-zone" + dateWithTimeZone);
        LocalDate standardFormat = LocalDate.of(1998,02,13);
        System.out.println("Random date " + standardFormat);
        //TODO fix this code
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String europeanFormatString = date.format(formatter);
        LocalDate europeanFormat = LocalDate.parse(europeanFormatString,formatter);
        System.out.println("Random date " + europeanFormat);
    }
}

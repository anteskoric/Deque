package time;

import java.time.LocalDate;
import java.time.ZoneId;
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



        LocalDate month = LocalDate.of(1970,7,2);
        System.out.println("The name of the month " + month.getMonth());
        System.out.println("Day of the month " + month.getDayOfMonth());
        System.out.println("Value of the month " + month.getMonthValue());
        int monthLength = month.lengthOfMonth();
        System.out.println("Value of the days that the month contains " + monthLength);
        System.out.println("The month contains " + monthLength * 24 + " hours");
        System.out.println("The month contains " + monthLength * 24 * 60 + " minutes");
        System.out.println("The month contains " + monthLength * 24 * 60 * 3600 + " seconds");

        System.out.println("The next monday " + Time.getDate(LocalDate.now(),"sunday"));


    }
}

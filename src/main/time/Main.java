package time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.DayOfWeek.SUNDAY;

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
        System.out.println("Date with time-zone " + dateWithTimeZone);

        LocalDate standardFormat = LocalDate.of(1998,2,13);
        System.out.println("Random date " + standardFormat);

        String dateEuropeanFormat = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT ).withLocale(Locale.GERMANY));
        System.out.println("European Format " + dateEuropeanFormat);

        Instant timeOne = Instant.now();
        Instant timeTwo = Instant.now();
        Instant endTime = timeTwo.plus(Duration.ofDays(2));
        System.out.println("Days between two instants " + Duration.between(timeOne,endTime).toDays());
        System.out.println("Hours between two instants " + Duration.between(timeOne,endTime).toHours());
        System.out.println("Nanoseconds between two instants " + Duration.between(timeOne,endTime).toNanos());
        System.out.println("Minutes between two instants " + Duration.between(timeOne,endTime).toMinutes());
        System.out.println("Seconds between two instants " + Duration.between(timeOne,endTime).toSeconds());

        LocalDate dateOne = LocalDate.of(1970,7,2);
        LocalDate dateTwo = LocalDate.of(1980,8,3);
        int years = Period.between(dateOne,dateTwo).getYears();
        int days = Period.between(dateOne,dateTwo).getDays();
        int months = Period.between(dateOne,dateTwo).getYears();
        System.out.println("Year, days and hours between dateOne and dateTwo " + "\n" + "Years " + years + "\n" + "Months " + months + "\n" + "Days " + days);


        System.out.println("The name of the dateOne " + dateOne.getMonth());
        System.out.println("Day of the dateOne " + dateOne.getDayOfMonth());
        System.out.println("Value of the dateOne " + dateOne.getMonthValue());
        int monthLength = dateOne.lengthOfMonth();
        System.out.println("Value of the days that the dateOne contains " + monthLength);
        System.out.println("The dateOne contains " + monthLength * 24 + " hours");
        System.out.println("The dateOne contains " + monthLength * 24 * 60 + " minutes");
        System.out.println("The dateOne contains " + monthLength * 24 * 60 * 60 + " seconds");

        System.out.println("The next sunday " + Time.getDate(LocalDate.now(),SUNDAY));

        System.out.println("All year from 1998 till 2060 with 30.09 that fall on sunday " + Time.findDates(MonthDay.of(9,30),SUNDAY,1998,2060));
    }
}
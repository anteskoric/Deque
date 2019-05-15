package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Ante Skoric, Timo Quednau
 * The class Time gives us some usefull methods for manipulation of time.
 */
public class Time {
    public static LocalDate getDate(LocalDate date, String day) {
       LocalDate dateOfTheDay = date;
       String ignoreCaseDay = day.toLowerCase();
       switch (ignoreCaseDay) {
            case "monday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                break;
            case "tuesday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                break;
            case "wednesday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                break;
            case "thursday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                break;
            case "friday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                break;
            case "saturday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                break;
            case "sunday":
                dateOfTheDay = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                break;
            default:
                throw new IllegalArgumentException("The given day is not part of the week");
        }
        return dateOfTheDay;
    }
}

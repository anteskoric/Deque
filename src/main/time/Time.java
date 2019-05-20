package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ante Skoric, Timo Quednau
 * The class Time gives us some usefull methods for manipulation of time.
 */
public class Time {
    /**
     * Returns the date with the next day of the week.
     * @param date LocalDate of some specific date.
     * @param day DayOfWeek of with we want to get the new date.
     * @return date with new values.
     */
    public static LocalDate getDate(LocalDate date, DayOfWeek day) {
        return date.with(TemporalAdjusters.next(day));
    }

    /**
     * Returns a list with all dates that start with the year startYear and end at finalYear, the dates in the list
     * have the same month and day as the input.
     * @param monthDay The month and day of the year.
     * @param dayOfWeek The day of the week we want to find.
     * @param startYear The start year.
     * @param finalYear The final year.
     * @return ArrayList with all dates.
     */
    public static List<LocalDate> findDates(MonthDay monthDay, DayOfWeek dayOfWeek, int startYear, int finalYear){
        ArrayList<LocalDate> allDates = new ArrayList<>();
        LocalDate date = LocalDate.of(startYear,monthDay.getMonth(),monthDay.getDayOfMonth());
        for(int i = startYear; i <= finalYear; i++){
            if(date.getDayOfWeek() == dayOfWeek){
                allDates.add(date);
            }
            date = date.plusYears(1);
        }
        return allDates;
    }
}
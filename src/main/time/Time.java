package time;

import java.time.LocalDate;

/**
 * @author Ante Skoric, Timo Quednau
 * The class Time gives us some usefull methods for manipulation of time.
 */
public class Time {
    private Days day;
    //TODO repair the enums!!!!
    public enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    //TODO Repair the method
    public LocalDate getDate(LocalDate date, String day) {
        switch (day) {
           // case {MONDAY: {
           //     LocalDate monday = LocalDate.now();
           //     return monday;
           // }
            default: {
                throw new IllegalArgumentException("Such day does not exist");
            }
        }
    }
}

package time;

import java.security.InvalidParameterException;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;

    public Time(int hours, int minutes, int seconds, int day, int month, int year) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public static Time now() {
        return Factory.createTimeNow();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%02d:", this.hours));
        output.append(String.format("%02d:", this.minutes));
        output.append(String.format("%02d ", this.seconds));
        output.append(String.format("%02d.", this.day));
        output.append(String.format("%02d.", this.month));
        output.append(String.format("%02d", this.year));
        return output.toString();
    }

    public void setHours(int hours) {
        if (hours < 0 || hours >= 24)
            throw new InvalidParameterException("Hours cannot be less than 0 or more than 23");

        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= 60)
            throw new InvalidParameterException("Minutes cannot be less than 0 or more than 59");

        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds >= 60)
            throw new InvalidParameterException("Seconds cannot be less than 0 or more than 59");

        this.seconds = seconds;
    }

    public void setDay(int day) {
        if (day <= 0 || day >= 32)
            throw new InvalidParameterException("Days cannot be less than 0 or more than 31");

        this.day = day;
    }

    public void setMonth(int month) {
        if (month <= 0 || month > 12)
            throw new InvalidParameterException("Month cannot be less than 1 or more than 12");

        this.month = month;
    }

    public void setYear(int year) {
        if (year < 1 || year > 5000)
            throw new InvalidParameterException("Year cannot be less than 1 or more than 5000");

        this.year = year;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
}
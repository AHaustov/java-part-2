import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class dayConverter {
    LocalDate birthday;

    public dayConverter(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.birthday = LocalDate.parse(birthdate, formatter);
    }

    public String dayOfWeekOnBirth() {
        DateTimeFormatter formatterWeekDay = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter formatterYearDay = DateTimeFormatter.ofPattern("D");

        return birthday.format(formatterWeekDay)
                + " the " + birthday.format(formatterYearDay)
                + " day in that year";
    }

    public boolean isBirthDayBeforeToday() {
        LocalDate now = LocalDate.now();
        return birthday.withYear(now.getYear())
                .isBefore(now);
    }

    public String daysTillBD() {
        LocalDate now = LocalDate.now();
        LocalDate dayOfBirthday = birthday.withYear(now.getYear());

        if (!isBirthDayBeforeToday()) {
            return "Your Birthday is in "
                    + (dayOfBirthday.getDayOfYear() - now.getDayOfYear())
                    + " days.";
        } else
            return "Your Birthday was "
                    + (now.getDayOfYear() - dayOfBirthday.getDayOfYear())
                    + " days ago.";
    }
}

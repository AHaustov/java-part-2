import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        dayConverter day = new dayConverter("26.05.1989");

        System.out.println(day.dayOfWeekOnBirth());
        System.out.println(day.daysTillBD());
        System.out.println(daysTillNewYear());

    }

    public static String daysTillNewYear() {
        LocalDate now = LocalDate.now();
        return "You have to wait "
                + (now.lengthOfYear() - now.getDayOfYear())
                + " until New Year";
    }
}

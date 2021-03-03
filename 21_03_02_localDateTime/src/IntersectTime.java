import java.time.*;


// is not working
public class IntersectTime {

    public int intersectWorkingTime(LocalTime start1, int hours, ZoneId zone1
            , LocalTime start2, int hours2, ZoneId zone2) {

        LocalTime localEnd = start1.plusHours(hours);

        LocalTime offBroadStart = ZonedDateTime.of(LocalDate.now(), start2, zone2)
                .withZoneSameInstant(zone1).toLocalTime();
        LocalTime offBroadEnd = offBroadStart.plusHours(hours2);

        int delta1 = Duration.between(start1, offBroadEnd).toHoursPart();
        int delta2 = Duration.between(offBroadStart, localEnd).toHoursPart();
        int max = Math.max(delta1, delta2);

        return Math.max(0, max);
    }
}

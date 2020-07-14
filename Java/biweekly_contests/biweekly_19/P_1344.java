package biweekly_contests.biweekly_19;

public class P_1344 {

    public double angleClockOld(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        final double hAngle = 0.5 * (hour * 60 + minutes);
        final double mAngle = 6 * minutes;
        final double angle = Math.abs(hAngle - mAngle);
        return Math.min(360 - angle, angle);
    }

    public double angleClock(int hour, int minutes) {
        final double h = (hour % 12) * 30 + (minutes / 60.0) * 30;
        final double m = minutes * 6;
        final double angle = Math.abs(h - m);
        return Math.min(360 - angle, angle);
    }
}

package biweekly_19;

public class P_1344 {

    public double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        final double hAngle = 0.5 * (hour * 60 + minutes);
        final double mAngle = 6 * minutes;
        final double angle = Math.abs(hAngle - mAngle);
        return Math.min(360 - angle, angle);
    }
}

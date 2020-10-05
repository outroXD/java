import java.util.Calendar;
import java.util.Date;

public class WeekdayState implements WeekState {
    private final static WeekState weekdayState = new WeekdayState();

    private WeekdayState() {
        super();
    }

    // シングルトン
    public static WeekState getInstance() {
        return weekdayState;
    }

    @Override
    public void setDate(Shop shop) {
        Date workDate = shop.getDate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(workDate);

        int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        if (calDayOfWeek == Calendar.SATURDAY || calDayOfWeek == Calendar.SUNDAY) {
            shop.changeState(HolidayState.getInstance());
        }
    }

    @Override
    public void open(Date date) {
        System.out.println(sdf.format(date) + "平日：開店時間は11時です。");
    }

    @Override
    public void close(Date date) {
        System.out.println(sdf.format(date) + "平日：閉店時間は20時です。");
    }
}

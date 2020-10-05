import java.util.Calendar;
import java.util.Date;

public class HolidayState implements WeekState {
    private final static WeekState holidayState = new HolidayState();

    private HolidayState() {
        super();
    }

    // シングルトン
    public static WeekState getInstance() {
        return holidayState;
    }

    @Override
    public void setDate(Shop shop) {
        Date workDate = shop.getDate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(workDate);

        int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        if (!(calDayOfWeek == Calendar.SATURDAY || calDayOfWeek == Calendar.SUNDAY)) {
            shop.changeState(WeekdayState.getInstance());
        }
    }

    @Override
    public void open(Date date) {
        System.out.println(sdf.format(date) + "⭐️土日：開店時間は10時です。");
    }

    @Override
    public void close(Date date) {
        System.out.println(sdf.format(date) + "⭐️土日：閉店時間は21時です。");
    }
}

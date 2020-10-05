import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 現在日付を生成
        Date date = new Date();
        // ショップを生成
        Shop shop = new Shop();
        // 1週間のループ
        for (int i = 0; i < 7; i++) {
            shop.setDate(date);
            shop.open();
            shop.close();
            date = addOneDay(date);
        }
    }

    private static Date addOneDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, 1);

        return cal.getTime();
    }
}

import greeting.Greeting;
import greeting.GreetingEN;
import greeting.GreetingJA;

import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Greeting greeting;
        String lang = Locale.getDefault().getLanguage();

        // インスタンス化するオブジェクトをLocaleを元に切り替える
        if (lang.equals("ja")) {
            greeting = new GreetingJA();
        } else {
            greeting = new GreetingEN();
        }

        // 実行するメソッドの判定
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 5 && hour < 13) {
            System.out.println(greeting.getMornig());
        } else if (hour >= 13 && hour < 17) {
            System.out.println(greeting.getAfternoon());
        } else {
            System.out.println(greeting.getEvening());
        }
    }
}

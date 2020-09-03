import greeting.Greeting;
import greeting.GreetingFactory;

import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        // インスタンス化処理をFactoryに任せた
        Greeting greeting = GreetingFactory.create(Locale.getDefault());

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

package greeting;

/**
 * 挨拶の実装(日本語)
 */
public class GreetingJA implements Greeting {
    @Override
    public String getMornig() {
        return "おはようございます。";
    }

    @Override
    public String getAfternoon() {
        return "ご機嫌よう。";
    }

    @Override
    public String getEvening() {
        return "こんばんわ。";
    }
}

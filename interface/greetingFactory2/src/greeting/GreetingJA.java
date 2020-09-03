package greeting;

/**
 * 挨拶の実装(日本語)
 */
class GreetingJA implements Greeting {
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

    @Override
    public boolean isSupported(String lang) {
        return (lang.equals("ja"));
    }
}

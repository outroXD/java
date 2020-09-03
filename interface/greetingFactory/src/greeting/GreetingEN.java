package greeting;

/**
 * 挨拶の実装(英語)
 */
class GreetingEN implements Greeting {
    @Override
    public String getMornig() {
        return "Hello.";
    }

    @Override
    public String getAfternoon() {
        return "Hi, how are you doing?";
    }

    @Override
    public String getEvening() {
        return "Hey, What's up man?";
    }
}

package greeting;

import java.util.Locale;

public class GreetingFactory {
    private final static Greeting[] ARRAY_GREETING = {
            new GreetingJA(),
            new GreetingEN(),
    };

    public static Greeting create(Locale locale) {
        String lang = locale.getLanguage();

        Greeting supported = new GreetingEN(); // デフォルトは英語
        for (Greeting greeting : ARRAY_GREETING) {
            if (greeting.isSupported(lang)) {
                supported = greeting;
                break;
            }
        }

        return supported;
    }
}

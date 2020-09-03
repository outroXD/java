package greeting;

import java.util.Locale;

public class GreetingFactory {
    public static Greeting create(Locale locale) {
        Greeting greeting;

        String lang = locale.getLanguage();
        if (lang.equals("ja")) {
            greeting = new GreetingJA();
        } else {
            greeting = new GreetingEN();
        }
        return greeting;
    }
}

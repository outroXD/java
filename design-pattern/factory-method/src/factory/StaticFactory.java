package factory;

import pc.Pc;
import pc.PcApple;
import pc.PcMicrosoft;

public class StaticFactory {
    public static Product create(String param) {
        if (param.equals("Ms")) {
            return new PcMicrosoft("Ms");
        } else if (param.equals("Apple")) {
            return new PcApple("Apple");
        } else {
            return new Pc("Others");
        }
    }
}

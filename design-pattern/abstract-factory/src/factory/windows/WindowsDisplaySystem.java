package factory.windows;

import factory.OsDisplaySystem;

public class WindowsDisplaySystem extends OsDisplaySystem {
    @Override
    public void displayOsName() {
        System.out.println("* Windows *");
        System.out.println();
    }

    @Override
    public void displayStr(String str) {
        System.out.println("*" + str + "*");
        System.out.println();
    }
}

import factory.OsDisplaySystem;
import factory.OsFactory;
import factory.OsFileSystem;

public class Main {
    public static void main(String args[]) {
        final String classnameWindows = "factory.windows.WindowsFactory";
        OsFactory factory = OsFactory.getFactory(classnameWindows);

        // DisplaySystemの生成
        OsDisplaySystem displaySystem = factory.createDisplaySystem();
        displaySystem.displayOsName();
        displaySystem.displayStr("サンプル");

        // FileSystemの生成
        OsFileSystem osFileSystem = factory.createFileSystem();
        osFileSystem.saveFile("sample.txt");

        final String classnameLinux = "factory.linux.LinuxFactory";
        factory = OsFactory.getFactory(classnameLinux);

        // DisplaySystemの生成
        displaySystem = factory.createDisplaySystem();
        displaySystem.displayOsName();
        displaySystem.displayStr("サンプル");

        // FileSystemの生成
        osFileSystem = factory.createFileSystem();
        osFileSystem.saveFile("sample.txt");
    }
}

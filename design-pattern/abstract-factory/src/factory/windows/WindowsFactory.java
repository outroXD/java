package factory.windows;

import factory.OsDisplaySystem;
import factory.OsFactory;
import factory.OsFileSystem;

public class WindowsFactory extends OsFactory {
    @Override
    public OsFileSystem createFileSystem() {
        return new WindowsFileSystem();
    }

    @Override
    public OsDisplaySystem createDisplaySystem() {
        return new WindowsDisplaySystem();
    }
}

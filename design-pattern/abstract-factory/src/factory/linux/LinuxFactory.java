package factory.linux;

import factory.OsDisplaySystem;
import factory.OsFactory;
import factory.OsFileSystem;

public class LinuxFactory extends OsFactory {
    @Override
    public OsFileSystem createFileSystem() {
        return new LinuxFileSystem();
    }

    @Override
    public OsDisplaySystem createDisplaySystem() {
        return new LinuxDisplaySystem();
    }
}

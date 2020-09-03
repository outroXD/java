package factory.linux;

import factory.OsFileSystem;

public class LinuxFileSystem extends OsFileSystem {

    @Override
    public String getFileSeparator() {
        return "/";
    }

    @Override
    public String getRootPath() {
        return "/";
    }

    @Override
    public void saveFile(String fileName) {
        String dir = getRootPath() + "usr" + getFileSeparator() + fileName;
        System.out.println("save: " + dir);
    }
}

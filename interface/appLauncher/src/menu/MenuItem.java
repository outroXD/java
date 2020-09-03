package menu;

import com.sun.source.tree.ReturnTree;
import launcher.AppLauncher;
import launcher.AppLauncherException;

public class MenuItem {
    // 項目番号
    private int no;

    // 項目名
    private String name;

    // アプリランチャー
    private AppLauncher launcher;

    MenuItem(int no, String name, AppLauncher launcher) {
        this.no = no;
        this.name = name;
        this.launcher = launcher;
    }

    public int getNo() {
        return this.no;
    }

    public boolean isAvailable() {
        return launcher.isAvailable();
    }

    public void launch(MenuOption option) throws AppLauncherException {
        try {
            this.launcher.launch(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

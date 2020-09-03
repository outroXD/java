package launcher;

import menu.MenuOption;

public interface AppLauncher {
    /**
     * アプリ起動が可能かどうかを返す
     * @return
     */
    boolean isAvailable();

    /**
     * アプリを起動する
     * @param option
     * @throws Exception
     */
    void launch(MenuOption option) throws Exception;
}

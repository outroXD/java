package launcher;

import menu.MenuOption;
import java.util.Map;

public class IEFavoriteLauncher implements AppLauncher{
    /**
     * OSがwindowsである時のみtrue
     * windows環境以外では実行できない仕組み
     * @return
     */
    @Override
    public boolean isAvailable() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.startsWith("windows"));
    }

    @Override
    public void launch(MenuOption option) throws Exception {
        // 環境変数の取得
        Map<String, String> envMap = new ProcessBuilder().environment();

        // エクスプローラーでお気に入りを表示
        String[] cmd = {"explorer", envMap.get("USERPROFILE") + "¥¥Favorites"};
        new ProcessBuilder(cmd).start();
    }
}

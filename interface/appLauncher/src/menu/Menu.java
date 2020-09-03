package menu;

import launcher.AppLauncher;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // メニュー項目リスト
    private List<MenuItem> items;

    // メニューを生成する
    public Menu() {
        items = new ArrayList<>();
    }

    // メニュー項目を追加する
    public void add(String itemName, AppLauncher launcher) {
        int itemNo = items.size() + 1;
        items.add(new MenuItem(itemNo, itemName, launcher));
    }

    // メニュー項目リストを返す
    public List<MenuItem> items() {
        return (new ArrayList<>(items));
    }

    // 入力されたメニュー項目番号に対応するメニュー項目を返す
    public MenuItem select(String inputItemNo) {
        MenuItem selected = null;
        try {
            int itemNo = Integer.parseInt(inputItemNo);
            for (MenuItem item : items) {
                if (itemNo == item.getNo()) {
                    if (item.isAvailable()) {
                        selected = item;
                    }
                    break;
                }
            }
        } catch (NumberFormatException ex) { }
        return selected;
    }
}

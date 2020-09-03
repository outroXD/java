package menu;

public class MenuOption {
    // 終了フラグ
    private boolean isTerminate;

    // メニューを終了する
    public void terminate() {
        isTerminate = true;
    }

    // メニューを収容するか否かを返す
    public boolean isTerminate() {
        return this.isTerminate;
    }
}

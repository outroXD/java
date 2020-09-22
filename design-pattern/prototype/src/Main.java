public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        // 原型を作成
        Potion redPotion = new Potion("赤のポーション");
        manager.register("redPortion", redPotion);

        Potion orangePotion = new Potion("オレンジのポーション");
        manager.register("orangePotion", orangePotion);

        Sword copperSword = new Sword("銅の剣");
        manager.register("copperSword", copperSword);

        // クローンを作成
        Item sword1 = manager.create("copperSword");
        sword1.get();
        sword1.use();

        Item potion1 = manager.create("redPortion");
        potion1.get();
        potion1.use();

        Item potion2 = manager.create("orangePotion");
        potion2.get();
        potion2.use();
    }
}

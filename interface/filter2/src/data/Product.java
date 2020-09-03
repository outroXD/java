package data;

public class Product {
    private String name;
    private int price;
    private int weight;

    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    /**
     * 商品名を返す。
     *
     * @return 商品名
     */
    public String getName() {
        return name;
    }

    /**
     * 価格を返す。
     *
     * @return 価格
     */
    public int getPrice() {
        return price;
    }

    /**
     * 重量（g）を返す。
     *
     * @return 重量（g）
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "・" + name + " [価格] " + String.format("%,d(円)", price) + " [重量] " + String.format("%,d(g)", weight);
    }
}

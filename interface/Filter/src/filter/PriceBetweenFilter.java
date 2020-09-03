package filter;

import data.Product;

/**
 * 商品の価格が指定価格の範囲内にあるか判定するフィルター
 */
public class PriceBetweenFilter implements ProductFilter {
    // 下限価格
    private int lowest;
    // 上限価格
    private int highest;

    public PriceBetweenFilter(int lowest, int highest) {
        if (lowest > highest) {
            throw new IllegalArgumentException("Price is upside down.");
        }
        this.lowest = lowest;
        this.highest = highest;
    }

    @Override
    public boolean isMatches(Product target) {
        int targetPrice = target.getPrice();
        return (targetPrice >= this.lowest && targetPrice <= this.highest);
    }
}

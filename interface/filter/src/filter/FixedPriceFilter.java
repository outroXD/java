package filter;

import data.Product;

/**
 * 商品の価格が指定の価格(フィールド変数price)かどうかを判定する
 */
public class FixedPriceFilter implements ProductFilter {
    private int price;

    public FixedPriceFilter(int price) {
        this.price = price;
    }

    @Override
    public boolean isMatches(Product target) {
        return (target.getPrice() == this.price);
    }
}
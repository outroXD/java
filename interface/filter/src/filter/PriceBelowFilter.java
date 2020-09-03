package filter;

import data.Product;

public class PriceBelowFilter implements ProductFilter {
    private int price;

    public PriceBelowFilter(int price) {
        this.price = price;
    }

    /**
     * true: 商品価格が指定価格proce以下の場合
     * @param target
     * @return
     */
    @Override
    public boolean isMatches(Product target) {
        return (target.getPrice() <= this.price);
    }
}

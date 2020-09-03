package filter;

import data.Product;

/**
 * 複数のフィルターを1つにする「複合商品フィルター」
 */
public class CompoundFilter implements ProductFilter {
    private ProductFilter[] filters;

    public CompoundFilter(ProductFilter... filters) {
        this.filters = filters;
    }

    @Override
    public boolean isMatches(Product target) {
        // 複数の条件(フィルター)を条件「かつ」の元で組み合わせているのと同じ
        for (ProductFilter filter : filters) {
            // フィルター条件に1つでも合致しなければfalse
            if (!filter.isMatches(target)) {
                return false;
            }
        }
        return true;
    }
}

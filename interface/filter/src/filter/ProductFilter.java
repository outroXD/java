package filter;

import data.Product;

public interface ProductFilter {
    boolean isMatches(Product target);
}

package filter;

import data.Product;

public class WeightBelowFilter implements ProductFilter {
    private int weight;

    public WeightBelowFilter(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean isMatches(Product target) {
        return (target.getWeight() <= this.weight);
    }
}

package factory;

public abstract class Factory {
    public final Product create(String serialNumber) {
        Product product = createProduct(serialNumber);
        registerProduct(product);
        return product;
    }

    // Productを生成するメソッド
    protected abstract Product createProduct(String serialNumber);

    // Productを登録する抽象メソッド
    protected abstract void registerProduct(Product product);
}

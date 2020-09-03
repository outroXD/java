package pc;

import factory.Factory;
import factory.Product;

import java.util.ArrayList;
import java.util.List;

public class PcFactory extends Factory {
    private List<String> serialNumbers = new ArrayList<>();

    @Override
    protected Product createProduct(String serialNumber) {
        return new Pc(serialNumber);
    }

    @Override
    protected void registerProduct(Product product) {
        serialNumbers.add(((Pc) product).getSerialNumber());
    }

    public List<String> getSerialNumbers() {
        return this.serialNumbers;
    }
}

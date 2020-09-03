package pc;

import factory.Product;

public class PcMicrosoft extends Product {
    private final String serialNumber;

    public PcMicrosoft(String serialNumber) {
        super();
        this.serialNumber = serialNumber;
        System.out.println("MsPCの生成。");
    }

    @Override
    public void use() {
        System.out.println("MsPCの使用。");
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
}

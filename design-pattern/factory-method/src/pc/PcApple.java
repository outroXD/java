package pc;

import factory.Product;

public class PcApple extends Product {
    private final String serialNumber;

    public PcApple(String serialNumber) {
        super();
        System.out.println("ApplePCの生成。");
        this.serialNumber = serialNumber;
    }

    @Override
    public void use() {
        System.out.println("ApplePCの使用。");
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
}

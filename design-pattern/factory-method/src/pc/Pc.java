package pc;

import factory.Product;

public class Pc extends Product {
    private final String serialNumber;

    public Pc(String serialNumber) {
        super();
        System.out.println(serialNumber + "のPCを作ります。");
        this.serialNumber = serialNumber;
    }

    @Override
    public void use() {
        System.out.println(serialNumber + "のPCを使います。");
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
}

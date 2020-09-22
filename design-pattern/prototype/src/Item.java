public interface Item extends Cloneable {
    public void get();
    public void use();
    public Item createClone();
}

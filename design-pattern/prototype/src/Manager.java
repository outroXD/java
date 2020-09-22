import java.util.HashMap;
import java.util.Map;

public class Manager {

    // prototypeを保持
    private Map<String, Item> itemMap = new HashMap<>();

    // prototypeを登録
    public void register(String name, Item item) {
        itemMap.put(name, item);
    }

    // クローン生成
    public Item create(String itemName) {
        Item item = (Item) itemMap.get(itemName);
        return item.createClone();
    }
}

package Models.Items;

public abstract class Item implements IItem{
    private int id;
    private String name;
    private ItemType itemType;

    public Item(int id, String name, ItemType itemType) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}

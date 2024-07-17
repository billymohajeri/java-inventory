package inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
  private List<Item> items;

  public Store() {
    this.items = new ArrayList<>();
  }

  public List<Item> getItemsList() {
    return new ArrayList<>(items);
  }

  public Map<String, Item> getItemsMap() {
    Map<String, Item> itemsNameMap = new HashMap<>();
    for (Item item : items) {
      itemsNameMap.put(item.getName(), item);
    }
    return itemsNameMap;
  }

  public Map<String, Integer> getItemQuantities() {
    Map<String, Integer> itemsQuantityMap = new HashMap<>();
    for (Item item : items) {
      itemsQuantityMap.put(item.getName(), item.getQuantity());
    }
    return itemsQuantityMap;
  }
}























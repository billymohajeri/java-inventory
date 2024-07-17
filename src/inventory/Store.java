package inventory;

import java.util.*;

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

  public Set<String> getUniqueItemNames() {
    Set<String> uniqueItemNames = new HashSet<>();
    for (Item item : items) {
      uniqueItemNames.add(item.getName());
    }
    return uniqueItemNames;
  }

  public boolean addItem(Item newItem) {
    if (this.items.contains(newItem)) {
      return false;
    }
    //    for (Item item : items) {
    //      if (item.getName().equals(newItem.getName())) {
    //        return false;
    //      }
    //    }
    this.items.add(newItem);
    return true;
  }

  public void deleteItem(Item delItem) {
    this.items.remove(delItem);
  }

}























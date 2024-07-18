package inventory;

import java.util.*;

public class Store {
  private List<Item> items;
  private int maximumCapacity;
  private Map<String, Stack<Item>> itemHistory;

  public Store(int maximumCapacity) {
    items = new ArrayList<>();
    this.maximumCapacity = maximumCapacity;
    this.itemHistory = new HashMap<>();
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
    int totalSum = 0, itemSum = 0;

    for (Item item : items) {
      totalSum += item.getQuantity();
      if (item.getName().equals(newItem.getName())) {
        itemSum += item.getQuantity();
      }
    }

    System.out.println("sum: " + totalSum);
    if (totalSum + newItem.getQuantity() > maximumCapacity) {
      System.out.println("Amount of each item cannot be more than " + maximumCapacity);
      return false;
    }
    if (itemSum + newItem.getQuantity() < 0) {
      System.out.println("Amount of each item cannot be negative");
      return false;
    }
    if (items.contains(newItem)) {
      return false;
    }
    items.add(newItem);
    trackItemHistory(newItem, false);
    return true;
  }

  public void deleteItem(Item delItem) {
    if (!items.contains(delItem)) {
      System.out.println("The item you are looking for (" + delItem.getName() + ") is not available in our inventory.");
      return;
    }
    items.remove(delItem);
    trackItemHistory(delItem, true);
  }

  public int getCurrentVolume() {
    return items.size();
  }

  public Item findItemByName(String itemName) {
    for (Item item : items) {
      if (Objects.equals(itemName, item.getName())) {
        return item;
      }
    }
    return null;
  }

  public void trackItemHistory(Item newItem, boolean isDeleted) {
    itemHistory.putIfAbsent(newItem.getName(), new Stack<>());
    System.out.println(newItem.getName() + " isDeleted " + isDeleted);
    if (isDeleted) {
      Item delItem = new Item(newItem.getName(), (-1 * newItem.getQuantity()), newItem.getCreatedDate());
      itemHistory.get(delItem.getName()).add(delItem);

    } else {
      itemHistory.get(newItem.getName()).add(newItem);
    }
  }

  public void displayItemHistory(Item item) {

    int currentAmount = 0;
    String history = "";
    for (Item historyItem : itemHistory.get(item.getName())) {
      currentAmount += historyItem.getQuantity();
      history += historyItem.getCreatedDate() + ": " + historyItem.getQuantity() + "\n";
    }
    System.out.println("\nHistory for " + item.getName() + ": Current amount = " + currentAmount);
    System.out.println(history);
  }
}























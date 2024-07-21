package inventory;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    boolean isOverCapacity = totalSum + newItem.getQuantity() > maximumCapacity;
    if (isOverCapacity) {
      System.out.println("Amount of each item cannot be more than " + maximumCapacity);
      return false;
    }
    boolean isSumNegative = itemSum + newItem.getQuantity() < 0;
    if (isSumNegative) {
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
    System.out.println("\nHistory for " + item.getName() + ": (Current amount = " + currentAmount + ")");
    System.out.println(history);
  }

  public List<Item> filterItemsByQuantity(int minQuantity, int maxQuantity) {
    return items.stream()
            .filter(item -> item.getQuantity() > minQuantity && item.getQuantity() < maxQuantity).toList();
  }

  public List<Item> sortItemsByName() {
    return items.stream()
            .sorted(Comparator.comparing(Item::getName)).toList();
  }

  public List<Item> sortItemsByDate(boolean ascending) {
    Comparator<Item> comparator = Comparator.comparing(Item::getCreatedDate);
    if (!ascending) {
      comparator = comparator.reversed();
    }
    return items.stream()
            .sorted(comparator).toList();
  }

  public List<Item> getItemsCreatedAfter(LocalDate date) {
    return items.stream()
            .filter(item -> item.getCreatedDate().isAfter(date)).toList();
  }

  public Map<String, Long> countItemsByName(String name) {
    long count = items.stream()
            .filter(item -> item.getName().equals(name)).count();
    return Map.of(name, count);
  }

  public int getTotalQuantity() {
    int totalQuantity = items.stream()
            .mapToInt(Item::getQuantity).sum();
    return totalQuantity;
  }

  public List<String> findItemNamesContaining(String searchString) {
    List<String> foundItems = items.stream()
            .map(Item::getName).filter(name -> name.contains(searchString)).toList();
    return foundItems;
  }

  public Map<String, List<Item>> groupItemsByQuantityRange() {
    Map<String, List<Item>> groupItems = items.stream()
            .collect(Collectors.groupingBy(item -> getQuantityRange(item.getQuantity())));
    return groupItems;
  }

  private String getQuantityRange(int quantity) {
    return switch (quantity / 5) {
      case 0 -> "1-4: a little!";
      case 1 -> "5-9: more!";
      case 2 -> "10-14: a lot!";
      case 3 -> "15-19: a great deal!";
      case 4 -> "20-24: abundant!";
      default -> "+24: excessive!";
    };
  }
}























import inventory.Item;
import inventory.Store;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    Item waterBottle = new Item("Water Bottle", 10, LocalDate.of(2023, 1, 1));
    Item chocolateBar = new Item("Chocolate Bar", 15, LocalDate.of(2023, 2, 1));
    Item notebook = new Item("Notebook", 5, LocalDate.of(2023, 3, 1));
    Item pen = new Item("Pen", 20, LocalDate.of(2023, 4, 1));
    Item tissuePack = new Item("Tissue Pack", 30, LocalDate.of(2023, 5, 1));
    Item chipsBag = new Item("Chips Bag", 25, LocalDate.of(2023, 6, 1));
    Item sodaCan = new Item("Soda Can", 8, LocalDate.of(2023, 7, 1));
    Item soap = new Item("Soap", 12, LocalDate.of(2023, 8, 1));
    Item shampoo = new Item("Shampoo", 40, LocalDate.of(2023, 9, 1));
    Item toothbrush = new Item("Toothbrush", 50, LocalDate.of(2023, 10, 1));
    Item coffee = new Item("Coffee", 20);
    Item sandwich = new Item("Sandwich", 15);
    Item batteries = new Item("Batteries", 10);
    Item umbrella = new Item("Umbrella", 5);
    Item sunscreen = new Item("Sunscreen", 8);
    Item sunscreen2 = new Item("Sunscreen", -7);

    Store myStore = new Store(300);

    System.out.println(myStore.addItem(pen));
    System.out.println(myStore.addItem(sunscreen));
    System.out.println(myStore.addItem(sunscreen2));
    System.out.println(myStore.addItem(pen));
    myStore.deleteItem(pen);
    myStore.deleteItem(pen);
    myStore.deleteItem(pen);
    myStore.addItem(coffee);
    System.out.println(myStore.addItem(pen));
    System.out.println(myStore.addItem(batteries));
    System.out.println(myStore.addItem(umbrella));

    System.out.println("to str" + myStore.getItemsMap().toString());

    System.out.println(myStore.getCurrentVolume());


    System.out.println(myStore.findItemByName("Umbrella"));

    System.out.println("getItemsList: " + myStore.getItemsList());
    myStore.displayItemHistory(sunscreen);
    myStore.displayItemHistory(umbrella);
    myStore.displayItemHistory(pen);

    myStore.deleteItem(pen);
    myStore.displayItemHistory(pen);

    System.out.println(myStore.filterItemsByQuantity(5, 58));
    myStore.addItem(chipsBag);


    System.out.println("\nSorted items by name: " + myStore.sortItemsByName());

    System.out.println("\nSorted items by date: " + myStore.sortItemsByDate(false));

    LocalDate newDate = LocalDate.of(2023, 10, 1);
    System.out.println("\nItems created after " + newDate + ": " +
            myStore.getItemsCreatedAfter(newDate));
  }
}
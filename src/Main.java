import inventory.Item;
import inventory.Store;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    // items example - You do not need to follow exactly the same
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

    Store myStore = new Store();
    System.out.println(myStore.addItem(pen));
    System.out.println(myStore.addItem(sunscreen));
    System.out.println(myStore.addItem(pen));
    myStore.deleteItem(pen);
    System.out.println(myStore.addItem(pen));
    System.out.println(myStore.addItem(batteries));
    System.out.println(myStore.addItem(umbrella));
    System.out.println(myStore.getItemsMap());

    System.out.println(myStore.getCurrentVolume());


  }
}
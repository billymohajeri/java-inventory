# Inventory Management

In this assignment, you will create a simple inventory management system which allows users to add, remove,
and view items in the inventory.

## Requirements

## Level 1

- Create class `Item`, which has at least name (readonly), quantity, and created date, which are private.
- Amount of each item cannot be negative.
- Constructor to take parameters of the needed fields, however, created date (optional, if not set, it will be current date).

2. Create class `Store` with the following properties and methods:
- A collection to store items, which is private. Initially, this will be an empty collection.
- Implement a method getItemsList that returns a list of all items in the store.
- Implement a method getItemsMap that returns a map where keys are item names and values are item objects.
- Write a function getItemQuantities that returns a map where keys are item names and values are quantities.
- Implement a method getUniqueItemNames that returns a set of all unique item names in the store.
- Methods to add/delete one item to the collection. Do not allow adding items with the same name to the store.
- Method `getCurrentVolume` to compute the total amount of items in the store.
- Method `findItemByName` to find an item by name.

```java
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
```

## Level 2

Class `Store` should have these additional features:

- Maximum capacity, which is the total amount of items allowed in the store, and the constructor should also take
an integer value as the maximum capacity of the inventory.
  - Modify the add method to not overload the capacity.
- Implement a method trackItemHistory that uses a stack to keep track of changes made to an item’s quantity over time.
Each change (addition or subtraction) is pushed onto the stack.


#### More tasks to come during the week...
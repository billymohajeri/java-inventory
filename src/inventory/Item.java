package inventory;

import java.util.Date;

public class Item {
  private final String NAME;
  private int quantity;
  private Date createdDate;

  Item(String name, int quantity) {
    this.NAME = name;
    if (quantity < 0) {
      throw new IllegalArgumentException("Amount of each item cannot be negative");
    }
    this.quantity = quantity;
    this.createdDate = new Date();
  }

  Item(String name, int quantity, Date createdDate) {
    this.NAME = name;
    if (quantity < 0) {
      throw new IllegalArgumentException("Amount of each item cannot be negative");
    }
    this.quantity = quantity;
    this.createdDate = createdDate;
  }
}

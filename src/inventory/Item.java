package inventory;

import java.util.Date;

public class Item {
  private final String name;
  private int quantity;
  private Date createdDate;

  Item(String name, int quantity) {
    this.name = name;
    if (quantity < 0) {
      throw new IllegalArgumentException("Amount of each item cannot be negative");
    }
    this.quantity = quantity;
    this.createdDate = new Date();
  }

  Item(String name, int quantity, Date createdDate) {
    this.name = name;
    if (quantity < 0) {
      throw new IllegalArgumentException("Amount of each item cannot be negative");
    }
    this.quantity = quantity;
    this.createdDate = createdDate;
  }

  public String getNAME() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public Date getCreatedDate() {
    return createdDate;
  }
}

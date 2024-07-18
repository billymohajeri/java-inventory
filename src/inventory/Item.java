package inventory;

import java.time.LocalDate;

public class Item {
  private final String name;
  private int quantity;
  private LocalDate createdDate;

  public Item(String name, int quantity, LocalDate createdDate) {
    this.name = name;
    this.quantity = quantity;
    this.createdDate = createdDate == null ? LocalDate.now() : createdDate;
  }

  public Item(String name, int quantity) {
    this(name, quantity, LocalDate.now());
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "Item{" +
            "name='" + name + '\'' +
            ", quantity=" + quantity +
            ", createdDate=" + createdDate +
            '}';
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }
}

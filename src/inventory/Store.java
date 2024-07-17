package inventory;

import java.util.ArrayList;
import java.util.List;

public class Store {
  private List<Item> items;

  public Store() {
    this.items = new ArrayList<>();
  }

  public List<Item> getItemsList() {
    return new ArrayList<>(items);
  }
}

package api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="item", schema = "public")
public class Item {

    @Id
    @GeneratedValue
    int id;
    String name;
    Integer quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
      return this.quantity;
    }

    public void setQuantity(Integer quantity) {
      this.quantity = quantity;
    }
}
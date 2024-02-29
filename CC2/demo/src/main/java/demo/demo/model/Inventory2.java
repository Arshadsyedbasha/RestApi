package demo.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String supplier;
    String quantity;
    String category;
    
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

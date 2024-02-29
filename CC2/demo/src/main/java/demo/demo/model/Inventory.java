package demo.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name="Inventory")
@Transactional
public class Inventory {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    int productId;
    String productname;
    String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_forgeinkey")
    List<Inventory2> inventory2=new ArrayList<>();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Inventory2> getInventory2() {
        return inventory2;
    }

    public void setInventory2(List<Inventory2> inventory2) {
        this.inventory2 = inventory2;
    }

    
}

package demo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.demo.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
    
    @Query(value = "Select * from inventory s JOIN inventory2 h on s.product_id=h.product_forgeinkey",nativeQuery = true)
    List<Inventory> joinall();
}

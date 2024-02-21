package demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.demo.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
    
}

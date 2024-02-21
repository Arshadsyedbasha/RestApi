package demo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.demo.model.Inventory;
import demo.demo.repository.InventoryRepo;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryrepo;
    public Inventory addInventory(Inventory inventory){
        return inventoryrepo.save(inventory);
    }
    public List<Inventory>getInventory(){
        return inventoryrepo.findAll();
    }
    public Optional<Inventory> getbyId(int id)
    {
        return inventoryrepo.findById(id);
    }
    public String delete(int id)
    {
        inventoryrepo.deleteById(id);
        return "Deleted";
    }
    public Inventory put(int id,Inventory po)
    {
        Inventory user=inventoryrepo.findById(id).orElse(null);
        if(user!=null)
        {
            user.setProductId(user.getProductId());
            user.setProductname(user.getProductname());
            user.setDescription(user.getDescription());
            user.setCategory(user.getCategory());
            user.setQuantity(user.getQuantity());
            user.setSupplier(user.getSupplier());
            return inventoryrepo.saveAndFlush(user);
        }
        else{
            return null;
        }
    }
}

package demo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Inventory> get()
    {
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
            user.setProductname(po.getProductname());
            user.setDescription(po.getDescription());
            // user.setCategory(po.getCategory());
            // user.setQuantity(po.getQuantity());
            // user.setSupplier(po.getSupplier());
            return inventoryrepo.saveAndFlush(user);
        }
        else{
            return null;
        }
    }
    public List<Inventory> page(int pgno,int pgsize)
    {
        Pageable p=PageRequest.of(pgno, pgsize);
        return inventoryrepo.findAll(p).getContent();
    }
    public List<Inventory> sort(String f)
    {
        Sort s=Sort.by(Sort.Direction.ASC,f);
        return inventoryrepo.findAll(s);
    }
    public List<Inventory> pageandsort(int pgno,int pgsize,String field)
    {
        return inventoryrepo.findAll(PageRequest.of(pgno, pgsize).withSort(Sort.Direction.ASC,field)).getContent();
    }

    public List<Inventory> getall()
    {
        return inventoryrepo.joinall();
    }
}

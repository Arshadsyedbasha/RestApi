package demo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import demo.demo.model.Inventory;
import demo.demo.model.Login;
import demo.demo.service.InventoryService;
import demo.demo.service.Loginservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class InventoryController {
    @Autowired Loginservice l;
    @Autowired InventoryService p;
    @GetMapping("/getlogin")
    public  List<Login> getMethodName() {
        return l.get();
    }
    @GetMapping("/getproduct")
    public  List<Inventory> getMethod() {
        return p.getInventory();
    }
    @PostMapping("/addlogin")
    public Login postMethodName(@RequestBody Login entity) {
        return l.post(entity);
    }
    @PostMapping("/addproduct")
    public Inventory postMethodName(@RequestBody Inventory entity) {
        return p.addInventory(entity);
    }
    @PutMapping("/putlogin/{id}")
    public Login putMethodName(@PathVariable int id, @RequestBody Login entity) {
        return l.put(id, entity);
    }
    @PutMapping("/putproduct/{id}")
    public Inventory putMethodName(@PathVariable int id, @RequestBody Inventory entity) {
        return p.put(id, entity);
    }
    @DeleteMapping("/deletelogin/{id}")
    public String deleteLogin(@PathVariable int id)
    {
        return l.delete(id);
    }
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return p.delete(id);
    }
    @GetMapping("/getlogin/{id}")
    public Optional<Login> getbyid(@PathVariable int id) {
        return l.getById(id);
    }
    @GetMapping("/getProduct/{id}")
    public Optional<Inventory> getbyId(@PathVariable int id) {
        return p.getbyId(id);
    }


    
}

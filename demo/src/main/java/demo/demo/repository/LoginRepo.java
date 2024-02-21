package demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.demo.model.Login;

public interface LoginRepo extends JpaRepository<Login,Integer>{
    
}

package com.springboot.hrk.calorietracker.repository;

import com.springboot.hrk.calorietracker.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    //All CRUD Operations are available in this DAO Layer.
    //No need to add @Repository annotation. When we extend JPARepo, it is already taken care.

}
